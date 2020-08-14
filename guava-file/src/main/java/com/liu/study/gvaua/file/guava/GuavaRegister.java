package com.liu.study.gvaua.file.guava;

import com.google.common.eventbus.EventBus;

/**
 * 注册监听器。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 14:55
 */
public class GuavaRegister {

    private EventBus eventBus;

    public EventBus getEventBus() {
        if (eventBus == null) {
            eventBus = new EventBus("111111");
        }
        return eventBus;
    }

    /**
     * 想EventBus注册监听。
     *
     * @param listener
     */
    public void register(GuavaListener listener) {
        /**
         * 注册这个listener所有的订阅方法（被@Subscribe注解修饰的）
         * 并根据@Subscribe修饰的方法的参数分组。也就是根据事件进行分组。
         *
         */
        getEventBus().register(listener);
    }

}