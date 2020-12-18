package com.liu.study.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Lists测试。
 *
 * @author Liuweian
 * @createTime 2020/8/20 21:25
 * @version 1.0.0
 */
public class ListsDemo {

    public static void main(String[] args) {
        // 01、第一次测试
        // firstTest();


    }

    /**
     * 第一次测试。
     */
    public static void firstTest() {
        /**
         * 创建一个不可变的List。
         */
        List<String> unmodifiable = Lists.asList("liuweian", new String[] {"we"});
        // System.out.println(unmodifiable.add("wed"));

        /**
         * cartesianProduct()：产生笛卡尔积。
         */
        System.out.println("--------------------------------  cartesianProduct  -----------------------------------------");
        List<List<String>> cartesianProduct = Lists.cartesianProduct(unmodifiable,Arrays.asList("li", "wang", "you"), Arrays.asList("1", "2", "3"));
        System.out.println(cartesianProduct);

        /**
         * 将一个字符串转换成一个字符集合。
         */
        System.out.println("--------------------------------  charactersOf  -----------------------------------------");
        ImmutableList<Character> characters = Lists.charactersOf("liuweian");
        System.out.println(characters);

        /**
         * 创建一个可变的、空的List
         * 在Java7以后，这个方法没有必要，简易直接使用ArrayList的构造函数直接创建。
         */
        ArrayList<String> volatileList = Lists.newArrayList();
        volatileList.add("volatile");

        /**
         * Java7以上的版本直接使用ArrayList构造函数。
         */
        ArrayList<Object> ld = Lists.newArrayListWithCapacity(4);

        /**
         * 创建一个可变的CopyOnWriteArrayList，底层直接调用CopyOnWriteArrayList的构造函数。
         */
        CopyOnWriteArrayList<Object> copyOnWrite = Lists.newCopyOnWriteArrayList();

        /**
         * 将一个大的List划分为多少个小的List。
         */
        System.out.println("--------------------------------  partition  -----------------------------------------");
        ArrayList arrayList = new ArrayList(Arrays.asList("1", "2", "3", "4","5", "6", "7", "8", "9", "10"));
        List partition = Lists.partition(arrayList, 3);
        System.out.println(partition);

        /**
         * 翻转List
         */
        System.out.println("--------------------------------  Lists.reverse、Collections.reverse()  -----------------------------------------");
        System.out.println(arrayList);
        List reverse = Lists.reverse(arrayList);
        System.out.println(reverse);
        Collections.reverse(reverse);
        System.out.println(reverse);
    }


}
