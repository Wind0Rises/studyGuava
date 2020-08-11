package com.liu.study.guava.basis;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

/**
 * Strings and CharMatcher学习。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/7 12:48
 */
public class StringsTest {

    public static void main(String[] args) {
        // stringsFirstMethod();

        charMatcherTest();
    }

    public static void stringsFirstMethod() {
        String testStr = "wet";
        System.out.println(Strings.repeat(testStr, 2));

        System.out.println(Strings.padEnd(testStr, 3, '1'));
        System.out.println(Strings.padEnd(testStr, 4, '1'));
        System.out.println(Strings.padEnd(testStr, 8, '1'));
        System.out.println(Strings.padEnd(testStr, -1, '1'));

        System.out.println("##########");

        System.out.println(Strings.padStart(testStr, 2, '1'));
        System.out.println(Strings.padStart(testStr, 6, '1'));
        System.out.println(Strings.padStart(testStr, 3, '1'));

        System.out.println("-------------");
        String testStr1 = "wetwesdasfwe";
        System.out.println(Strings.commonPrefix(testStr1, "waaeg"));
        System.out.println(Strings.commonPrefix(testStr1, "weteasdfe"));
        System.out.println(Strings.commonPrefix(testStr1, "eteasdfe"));

        System.out.println("-------------");
        String testStr2 = "liuweian";
        System.out.println(Strings.commonSuffix(testStr2, "lsinandfan"));
        System.out.println(Strings.commonSuffix(testStr2, "liuweian"));


        System.out.println(Strings.lenientFormat("werwe-%s", "sdf"));
    }

    /**
     *
     */
    public static void charMatcherTest() {
        System.out.println(CharMatcher.any().matches('S'));
    }
}