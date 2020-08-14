package com.liu.study.gvaua.concurrent.limit;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 漏桶算法。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/14 9:18
 */
public class LeakyBucketBySemaphore {

    public static void main(String[] args) {
        LeakyBucketBySemaphore leakyBucket = new LeakyBucketBySemaphore();
        leakyBucket.addReqToContainer();
    }

    private static LinkedBlockingQueue<Integer> container = new LinkedBlockingQueue<>(500);

    private static Semaphore semaphore = new Semaphore(4);

    private static volatile boolean isStart = false;

    public LeakyBucketBySemaphore() {
        isStart = true;
        process();
    }

    public void addReqToContainer() {
        IntStream.range(0, 1000).forEach(item -> {
            try {
                container.add(item);
            } catch (Exception e) {
                System.out.println("-------------  请求达到极限，请求稍后重试！！！");
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    private ExecutorService service = Executors.newFixedThreadPool(3);

    public static void testConsumer() {
        while (isStart) {
            try {
                semaphore.acquire();
                Integer getContainer = container.take();
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，取出的数据为：" + getContainer + ", 现在的容器的大小为：" + container.size());
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    /**
     * 开始处理。
     */
    private void process() {
        IntStream.range(0, 3).forEach(item -> {
            service.submit(LeakyBucketBySemaphore::testConsumer);
        });
    }
}