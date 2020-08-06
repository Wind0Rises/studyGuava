package com.liu.study.guava.basis;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableBiMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * （实现了Iterable接口的类）list、map合并成字符串。
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 13:05
 */
public class JoinerTest {


    private static List<String> notNullList = Arrays.asList("liu", "weian", "hello", "world");

    private static List<String> hasNullList = Arrays.asList("liu", "weian", "hello", null, "world");

    /**
     * 其实是一个HashMap的子类，在子类的构造函数中调用了put方法。
     */
    private static Map<String, String> notNullMap = new HashMap<String, String>(){{
        put("liu", "weian");
        put("xiao", "ming");
    }};

    private static Map<String, String> hasNullMap = ImmutableBiMap.of("liu", "weian", "xiao", "ming", "", "slie");

    public static void main(String[] args) {
        // joinerListTest();

        joinerMapTest();
    }

    public static void joinerListTest() {
        String joinString = Joiner.on("$").join(notNullList);
        System.out.println(joinString);

        try {
            String joinNullString = Joiner.on("$").join(hasNullList);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("##################################");
        }

        String joinSkipNull = Joiner.on("$").skipNulls().join(notNullList);
        System.out.println(joinSkipNull);

        StringBuilder sb = new StringBuilder();
        StringBuilder appendResult = Joiner.on("$").skipNulls().appendTo(sb, notNullList);
        System.out.println(sb == appendResult);
        System.out.println(appendResult.toString());

        String defaultResult = Joiner.on("$").useForNull("DEFAULT").join(hasNullList);
        System.out.println(defaultResult);
    }

    public static void joinerMapTest() {
        String notNulMapResult = Joiner.on("#").withKeyValueSeparator("=").join(notNullMap);
        System.out.println(notNulMapResult);

        try {
            String hasNullMapResult =Joiner.on("#").withKeyValueSeparator("#").join(hasNullMap);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("##################################");
        }

        /**
         * map是不能使用skipNulls()。
         */
        String hasNullSkipMapResult =Joiner.on("#").withKeyValueSeparator("#").join(hasNullMap);
        System.out.println(hasNullSkipMapResult);
    }


}