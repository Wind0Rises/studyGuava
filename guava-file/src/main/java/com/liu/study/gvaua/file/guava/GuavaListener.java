package com.liu.study.gvaua.file.guava;

import com.google.common.eventbus.Subscribe;

/**
 * 一个{@link Subscribe}修饰的方法，代表一个订阅，{@link Subscribe}修饰的方法只能有一个参数。
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 14:52
 */
public class GuavaListener {

    /**
     * 订阅一
     * @param event
     */
    @Subscribe
    public void subscribe(GuavaEvent event) {
        System.out.println("subscribe：       " + event.toString());
    }

    /**
     * 订阅二
     * @param event
     */
    @Subscribe
    public void subscribeAnother(GuavaEvent event) {
        System.out.println(event.toString());
        throw new RuntimeException("----------");
    }

    /**
     * 订阅三
     * @param event
     */
    @Subscribe
    public void subscribeAnother1(GuavaEvent event) {
        System.out.println("subscribeAnother1：      " + event.toString());
    }

    /**
     * 监听另一事件
     *
     * @param event
     */
    @Subscribe
    public void subscribeSecond(GuavaSecondEvent event) {
        System.out.println("subscribeSecond：       " + event.toString());
    }

}