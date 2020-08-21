package com.liu.study.guava.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;

/**
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
        Multimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("2", "3");
        multimap.put("4", "7");
        System.out.println(multimap.size());
        System.out.println(multimap);
        System.out.println(multimap.get("1"));

        Map<String, Collection<String>> stringCollectionMap = multimap.asMap();
        System.out.println(stringCollectionMap);

    }

}
