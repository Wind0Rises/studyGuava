package com.liu.study.guava.collect;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * sets测试
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/12/8 12:31
 */
public class SetsDemo {

    public static void main(String[] args) {
        // 01、交集
        // intersectionTest();

        // 02、差集
        // differentTest();

        // 03、交集
        unionTest();
    }

    /**
     * 交集
     */
    public static void intersectionTest() {
        Set<String> first = new HashSet<>(Arrays.asList("1", "2", "3"));
        Set<String> second = new HashSet<>(Arrays.asList("2", "3", "9"));

        Sets.SetView<String> result = Sets.intersection(first, second);

        System.out.println(result);
        System.out.println(result.isEmpty());
        System.out.println(result.parallelStream().collect(Collectors.toSet()));
    }

    /**
     * 差集，
     * <note>第一个参数和第二参数，交换后结果是不一样的。</note>
     */
    public static void differentTest() {
        Set<String> first = new HashSet<>(Arrays.asList("1", "2", "3"));
        Set<String> second = new HashSet<>(Arrays.asList("2", "3", "9"));

        Sets.SetView<String> result = Sets.difference(first, second);

        System.out.println(result);
        System.out.println(result.isEmpty());
        System.out.println(result.parallelStream().collect(Collectors.toSet()));

        System.out.println("=====================================");
        Sets.SetView<String> result1 = Sets.difference(second, first);
        System.out.println(result1);
        System.out.println(result1.isEmpty());
        System.out.println(result1.parallelStream().collect(Collectors.toSet()));
    }

    /**
     * 并集
     */
    public static void unionTest() {
        Set<String> first = new HashSet<>(Arrays.asList("1", "2", "3"));
        Set<String> second = new HashSet<>(Arrays.asList("2", "3", "9"));

        Sets.SetView<String> result = Sets.union(first, second);

        System.out.println(result);
        System.out.println(result.isEmpty());
        System.out.println(result.parallelStream().collect(Collectors.toSet()));
    }

}
