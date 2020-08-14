package com.liu.study.gvaua.file.guava;

import com.google.common.eventbus.Subscribe;

/**
 * 一个@Subscribe修饰的方法，代表一个订阅。
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 14:52
 */
public class GuavaListener {

    /**
     *
     * 只有一个参数。
     * @param event
     */
    @Subscribe
    public void subscribe(GuavaEvent event) {
        System.out.println(event.toString());
    }

    /**
     * 只有一个参数。
     * @param event
     */
    @Subscribe
    public void subscribeAnother(GuavaEvent event) {
        System.out.println(event.toString());
        throw new RuntimeException("----------");
    }

    /**
     * 只有一个参数。
     * @param event
     */
    @Subscribe
    public void subscribeAnother1(GuavaEvent event) {
        System.out.println(event.toString());
    }

    /**
     * 监听另一事件
     *
     * @param event
     */
    @Subscribe
    public void subscribeSecond(GuavaSecondEvent event) {
        System.out.println(event.toString());
    }

}