package com.liu.study.guava.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;

/**
 * multiple[/ˈmʌltɪpl/]： 多重的；多样的；许多的
 *
 * <note>一个Key可以对应对个value</note>。
 *      1 - "1"
 *      1 - "2"
 *      2 - "3"
 *
 * @author Liuweian
 * @createTime 2020/8/20 22:20
 * @version 1.0.0
 */
public class MultimapDemo {

    /**
     * 可以放入重复的Key，并且这些key都会保存起来。内部value是一个集合。
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        // 01、Multimap的结构
        // testMultimapStructure();

        // 02、将MultiMap转换为Map
        // testMultiMapToMap();

        // 03、常用的方法
        commonMethod();
    }

    /**
     * Multimap数据结构，和Map<String, Collection<Object>>
     */
    public static void testMultimapStructure() {
        Multimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("2", "3");
        multimap.put("4", "7");
        System.out.println(multimap);
    }

    /**
     * 把MultiMap转换为MapMap<String, Collection<Object>>
     * <note>asMap()</note>方法。
     */
    public static void testMultiMapToMap() {
        Multimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("2", "3");

        Map<String, Collection<String>> stringCollectionMap = multimap.asMap();
        System.out.println(stringCollectionMap);
    }

    /**
     * 常用的方法。
     */
    public static void commonMethod() {
        Multimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("2", "3");

        System.out.println("multiMap.containKey()：" + multimap.containsKey("1"));
        System.out.println("multiMap.containValue()：" + multimap.containsValue("2"));
        System.out.println("multiMap.containEntry()：" + multimap.containsEntry("1", "2"));
        System.out.println("multiMap.size()：" + multimap.size());
    }

}
