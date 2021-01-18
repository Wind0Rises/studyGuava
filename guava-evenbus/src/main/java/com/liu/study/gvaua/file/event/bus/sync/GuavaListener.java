package com.liu.study.gvaua.file.event.bus.sync;

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
     * 订阅三
     * @param event
     */
    @Subscribe
    public void subscribeAnother1(GuavaEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subscribeAnother1：      " + event.toString());
    }

    /**
     * 订阅二
     * @param event
     */
    @Subscribe
    public void subscribeAnother(GuavaEvent event) {
        System.out.println("subscribeAnother：" + event.toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("----------");
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