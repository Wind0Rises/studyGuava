package com.liu.study.guava.basis;

import com.google.common.base.Splitter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/6 14:26
 */
public class SplitterTest {

    public static String testStr = "lw#liwe#sle####";

    public static void main(String[] args) {
        firstMethod();
    }

    public static void firstMethod() {
        List<String> testStr = Splitter.on("#").splitToList("lw#liwe#sle####");
        System.out.println(testStr);

        /**
         * 返回的是一个不可变得List
         */
        List<String> omitEmpty = Splitter.on("#").omitEmptyStrings().splitToList("lw#liwe#sle####");
        System.out.println(omitEmpty);

        /**
         * 这个输出是[lw, liwe#sle####]。不是[lw, liwe]
         */
        List<String> omitEmptyLimit = Splitter.on("#").omitEmptyStrings().limit(2).splitToList("lw#liwe#sle####");
        System.out.println(omitEmptyLimit);

        /**
         *
         */
        List<String> trimResult = Splitter.on("#").trimResults().omitEmptyStrings().splitToList(" lw #  liwe #   sle  ####");
        System.out.println(trimResult);


        Map<String, String> split = Splitter.on("#").trimResults().withKeyValueSeparator("=").split("liu=  weian    #   guo= lie");
        System.out.println(split);
    }

}