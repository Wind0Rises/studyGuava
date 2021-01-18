package com.liu.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 缓存处理。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 13:05
 */
public class CacheApplication {

    public static void main(String[] args) throws Exception {
        Cache<Object, Object> cache = CacheBuilder.newBuilder().expireAfterAccess(10, TimeUnit.SECONDS).build();

        cache.put("li", "we");

        System.out.println(cache.get("li", () -> {
            return "sdd";
        }));

        TimeUnit.SECONDS.sleep(11);


        System.out.println(cache.get("li", () -> {
            return "sdd";
        }));
    }



    /**
     * 通过CacheBuilder构建一个缓存对象。
     * CacheBuilder：是Cache和LocalCache实例的构造期，具有以下功能的任意组合：
     *      1. 自动将条目加载到缓存中
     *      2.
     *
     * @return
     */
    public static Cache createCacheByBuild() {
        /**
         * 不加任何属性的。
         */
        final CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();

        CacheBuilder.newBuilder()
                /**
                 * 设置并发级别为8，并发级别是指可以同时写缓存的线程数。默认值也是8
                 */
                .concurrencyLevel(8)

                /**
                 * 当缓存项在指定的时间段内没有被读或写就会被回收
                 */
                .expireAfterAccess(10, TimeUnit.SECONDS)

                /**
                 * 当缓存项在指定的时间段内没有更新就会被回收。
                 */
                .expireAfterWrite(10, TimeUnit.SECONDS)

                /**
                 * 当缓存项上一次更新操作之后的多久会被刷新。
                 */
                .refreshAfterWrite(10, TimeUnit.SECONDS)

                /**
                 * 设置缓存容器的初始容量为60。默认也是60L
                 */
                .initialCapacity(60)

                /**
                 *
                 */
                .maximumSize(10L);

        return cacheBuilder.build();
    }

    public static Cache createCacheByForm() {
        String spec = "maximumSize=10000,expireAfterWrite=10m";

        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.from(spec);

        cacheBuilder.newBuilder()
                /**
                 * 设置并发级别为8，并发级别是指可以同时写缓存的线程数。默认值也是8
                 */
                .concurrencyLevel(8)

                /**
                 * 当缓存项在指定的时间段内没有被读或写就会被回收
                 */
                .expireAfterAccess(10, TimeUnit.SECONDS)

                /**
                 * 当缓存项在指定的时间段内没有更新就会被回收。
                 */
                .expireAfterWrite(10, TimeUnit.SECONDS)

                /**
                 * 当缓存项上一次更新操作之后的多久会被刷新。
                 */
                .refreshAfterWrite(10, TimeUnit.SECONDS)


                // ############################################################################
                /**
                 * 设置缓存容器的初始容量为60。默认也是60L
                 */
                .initialCapacity(60)

                /**
                 *
                 */
                .maximumSize(10L);

        return cacheBuilder.build();
    }

}