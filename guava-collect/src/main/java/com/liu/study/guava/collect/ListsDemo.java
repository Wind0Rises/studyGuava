package com.liu.study.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Lists测试。
 *
 * @author Liuweian
 * @createTime 2020/8/20 21:25
 * @version 1.0.0
 */
public class ListsDemo {

    public static void main(String[] args) {
        /**
         * 创建一个不可变的List。
         */
        List<String> unmodifiable = Lists.asList("liuweian", new String[] {"we"});
        // System.out.println(unmodifiable.add("wed"));

        /**
         * cartesianProduct()：产生笛卡尔积。
         */
        List<List<String>> lists = Lists.cartesianProduct(unmodifiable, Arrays.asList("li", "wang", "you"));
        System.out.println(lists);
        List<List<String>> ee = Lists.cartesianProduct(unmodifiable,
                Arrays.asList("li", "wang", "you"), Arrays.asList("1", "2", "3"));
        System.out.println(ee);

        /**
         * 讲一个字符串转换成一个字符集合。
         */
        ImmutableList<Character> liuweian = Lists.charactersOf("liuweian");
        System.out.println(liuweian);

        /**
         * 创建一个可变的、空的List
         * 在Java7以后，这个方法没有必要，简易直接使用ArrayList的构造函数直接创建。
         */
        ArrayList<Object> objects = Lists.newArrayList();

        /**
         * Java7以上的版本直接使用ArrayList构造函数。
         */
        ArrayList<Object> ld = Lists.newArrayListWithCapacity(4);

        /**
         * 创建一个可变的CopyOnWriteArrayList,底层直接调用CopyOnWriteArrayList的构造函数。
         */
        CopyOnWriteArrayList<Object> copyOnWr = Lists.newCopyOnWriteArrayList();

        ArrayList arrayList = new ArrayList(Arrays.asList("1", "2", "3", "4",
                "5", "6", "7", "8", "9", "10"));
        List partition = Lists.partition(arrayList, 3);
        System.out.println(partition);

        /**
         * 翻转List
         */
        List reverse = Lists.reverse(arrayList);
        System.out.println(arrayList);
        System.out.println(reverse);

        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }

}
