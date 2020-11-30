package com.liu.study.gvaua.concurrent.limit;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * 滴桶算法。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/14 11:19
 */
public class LeakyBucketByGuava {

    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();

    private final static int BUCKET_LIMIT = 1000;

    private final static RateLimiter limiter = RateLimiter.create(10d);

    private Monitor monitor = new Monitor();

    private Monitor consumerMonitor = new Monitor();

    /**
     * 向桶中添加数据。
     *
     * @param data
     */
    public void putDataBucket(Integer data) {
        if (monitor.enterIf(monitor.newGuard(() -> container.size() < BUCKET_LIMIT))) {

            try {
                container.offer(data);
                System.out.println(currentThread() + " submit.." + data + " container size is :[" + container.size() + "]");
            } finally {
                monitor.leave();
            }
        } else {
            throw new IllegalStateException(currentThread().getName() + "The bucket is ful..Pls latter can try...");
        }
    }

    /**
     * 消费
     *
     * @param consumer
     */
    public void takeThenConsumer(Consumer<Integer> consumer) {
        if (consumerMonitor.enterIf(consumerMonitor.newGuard(() -> !container.isEmpty()))) {
            try {
                System.out.println(currentThread() + "  waiting" + limiter.acquire());
                Integer data = container.poll();
                consumer.accept(data);
            } finally {
                consumerMonitor.leave();
            }
        } else {
            System.out.println("will consumer Data from MQ...");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        final LeakyBucketByGuava bucket = new LeakyBucketByGuava();

        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);

        /**
         * 生产线程 10个线程 每秒提交 50个数据  1/0.2s*10=50个
         *
         */
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                for ( ; ;) {
                    int data = DATA_CREATOR.incrementAndGet();
                    try {
                        bucket.putDataBucket(data);
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (Exception e) {
                        //对submit时，如果桶满了可能会抛出异常
                        if (e instanceof IllegalStateException) {
                            System.out.println(e.getMessage());
                            //当满了后，生产线程就休眠1分钟
                            try {
                                TimeUnit.SECONDS.sleep(60);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        });


        //消费线程  采用RateLimiter每秒处理10个  综合的比率是5:1
        IntStream.range(0, 10).forEach(i -> {
            new Thread(
                    () -> {
                        for (; ; ) {
                            bucket.takeThenConsumer(x -> {
                                System.out.println(currentThread() + "C.." + x);
                            });
                        }
                    }
            ).start();
        });
    }
}