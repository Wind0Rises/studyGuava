package com.liu.study.gvaua.file.guava;

import com.google.common.eventbus.EventBus;

/**
 * 测试。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 15:59
 */
public class GuavaTest {

    public static void main(String[] args) {
        GuavaRegister guavaRegister = new GuavaRegister();

        /**
         * 获取EventBus。
         *
         * EventBus可以指定自己的异常处理。
         */
        EventBus eventBus = guavaRegister.getEventBus();

        /**
         * 注册监听器到EventBus。
         */
        guavaRegister.register(new GuavaListener());


        /**
         *
         */
        eventBus.post(new GuavaEvent("liuweian"));

        System.out.println("++++++++++++++++++++++++++++++++++++");

        eventBus.post(new GuavaSecondEvent("zhangsan"));
    }

    public static void test(EventBus eventBus) {
        // eventBus.unregister();
    }

}