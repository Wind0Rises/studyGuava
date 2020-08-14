package com.liu.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

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

}