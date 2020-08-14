package com.liu.study.gvaua.concurrent;

import com.google.common.util.concurrent.Monitor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 使用Monitor实现生产者消费者模式
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/14 13:31
 */
public class MonitorProductConsume {

    private static final ArrayBlockingQueue<Integer> container = new ArrayBlockingQueue<Integer>(10);

    private static final int MAX = 10;

    /**
     * 默认为非公平的monitor。
     */
    private static Monitor monitor = new Monitor();

    private static Monitor.Guard enableAdd = monitor.newGuard(() -> container.size() < MAX);

    private static Monitor.Guard enableRemove = monitor.newGuard(() -> !container.isEmpty());

    public static void main(String[] args) {
        IntStream.range(0, 3).forEach(item -> {
            new Thread(() -> {
                for (;;) {
                    producer(ThreadLocalRandom.current().nextInt(10));
                }
            }).start();
        });

        IntStream.range(0, 2).forEach(item -> {
            new Thread(() -> {
                for (;;) {
                    consumer();
                }
            }).start();
        });
    }

    public static void producer(int value) {
        try {
            monitor.enterWhen(enableAdd);
            container.add(value);
            System.out.println("新增的数据为：" + value + "，现有数据大小：" + container.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            monitor.leave();
        }
    }

    public static void consumer() {
        try {
            monitor.enterWhen(enableRemove);
            Integer poll = container.poll();
            System.out.println("移除的数据为：" + poll + "，现有数据大小：" + container.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            monitor.leave();
        }
    }

}