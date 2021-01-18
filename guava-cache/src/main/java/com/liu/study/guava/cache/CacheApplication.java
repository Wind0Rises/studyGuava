package com.liu.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 缓存处理。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 13:05
 */
public class CacheApplication {

    public static void main(String[] args) throws Exception {
        Cache<Object, Object> cache = createCacheByBuild();

        /**
         * putDataAndCheckAfterAccess
         */
        // putDataAndCheckAfterAccess(cache);


        /**
         *
         */
        // expireAfterAccessTest();

        /**
         *
         */
        // concurrencyLevelTest();

        /**
         *
         */
        // expireAfterWriteTest();

        /**
         *
         */
        cacheOtherMethod();
    }


    /**
     * 通过CacheBuilder构建一个缓存对象。
     * CacheBuilder：是Cache和LocalCache实例的构造期，具有以下功能的任意组合：
     * 1. 自动将条目加载到缓存中
     * 2.
     *
     * @return
     */
    public static Cache createCacheByBuild() {

        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                /**
                 * 设置并发级别为8，并发级别是指可以同时写缓存的线程数。默认值也是8
                 */
                .concurrencyLevel(8)

                /**
                 * 当缓存项在指定的时间段内没有被读或写就会被回收
                 */
                .expireAfterAccess(3, TimeUnit.SECONDS)

                /**
                 * 当缓存项在指定的时间段内没有更新就会被回收。
                 */
                .expireAfterWrite(3, TimeUnit.SECONDS)

                /**
                 * 设置缓存容器的初始容量为60。默认也是60L
                 */
                .initialCapacity(5)

                /**
                 * 最大包含的数据个数。
                 */
                .maximumSize(10L)

                /**
                 * TODO:不理解。
                 */
                // .maximumWeight(1000L)
                ;

        return cacheBuilder.build();
    }

    public static Cache createCacheByForm() {
        String spec = "maximumSize=10000,expireAfterWrite=10s,expireAfterAccess=10s";

        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.from(spec);

        return cacheBuilder.build();
    }

    /**
     * @param cache
     */
    public static void putDataAndCheckAfterAccess(Cache<Object, Object> cache) {
        cache.put("data", "this is Data");
        System.out.println("getIfPresent1：" + cache.getIfPresent("data"));

        try {
            TimeUnit.SECONDS.sleep(14L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getIfPresent2：" + cache.getIfPresent("data"));
    }


    /**
     * 测试：
     *      expireAfterAccess(...)：放入缓存后，多久过期.
     */
    public static void expireAfterAccessTest() throws ExecutionException, InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(3L, TimeUnit.SECONDS)
                .build();

        String notKey = cache.get("first", () -> {
            System.out.println("--------not key---------");
            return "not key";
        });
        System.out.println("not exits such key：" + notKey);

        cache.put("first", "first");

        String exitsKey = cache.get("first", () -> {
            System.out.println("---------exitsKey--------");
            return "not key";
        });
        System.out.println("exits such key：" + exitsKey);


        TimeUnit.SECONDS.sleep(5L);

        String expireKey = cache.get("first", () -> {
            System.out.println("---------expireKey--------");
            return "expire key";
        });
        System.out.println("expire key：" + expireKey);
    }

    /**
     * IntStream.range(0, 10)：左包含：右包含。
     *
     * concurrencyLevel：最大只有一个线程进行处理。
     *
     * TODO：没有验证。
     */
    public static void concurrencyLevelTest() throws InterruptedException {

        int threadNumber = 100;

        CountDownLatch countDownLatch1 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .concurrencyLevel(1)
                .build();

        IntStream.range(0, threadNumber).forEach(item -> {
            new Thread(() -> {
                countDownLatch1.countDown();
                try {
                    countDownLatch2.await();
                    cache.put("key + " + item, "value->" + item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "线程" + item).start();
        });

        countDownLatch1.await();
        System.out.println("------------  开始put  ----------");
        Thread.sleep(3000L);
        countDownLatch2.countDown();
        Thread.sleep(3000L);
        System.out.println(cache.size());
    }

    /**
     *
     */
    public static void expireAfterWriteTest() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(4L, TimeUnit.SECONDS)
                .build();

        cache.put("first", "first");
        cache.put("second", "second");

        TimeUnit.SECONDS.sleep(5L);

        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("second"));

        cache.put("first", "first");
        cache.put("second", "second");

        TimeUnit.SECONDS.sleep(3L);
        cache.put("second", "second1");

        TimeUnit.SECONDS.sleep(3L);
        System.out.println("----------------------------");
        System.out.println(cache.getIfPresent("first"));
        System.out.println(cache.getIfPresent("second"));
    }

    /**
     *
     */
    public static void cacheOtherMethod() throws InterruptedException {
        /**
         * LocalCache：
         *      LocalManualCache
         */
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(4L, TimeUnit.SECONDS)
                .build();

        cache.put("first", "first");
        cache.put("second", "second");

        ConcurrentMap<String, String> asMap = cache.asMap();
        System.out.println(asMap);

        /**
         * invalidate：失效指定的key。
         */
        cache.invalidate("first");
        System.out.println(cache.getIfPresent("first") + "   size：" + cache.size());


        final CacheStats stats = cache.stats();
        System.out.println(stats);
    }
}