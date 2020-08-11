package com.liu.study.guava.basis;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/9 13:58
 */
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {
        firstTestMethod();
    }

    public static void firstTestMethod() throws InterruptedException {
        Stopwatch stopWatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("------ " + stopWatch.stop());
    }
}