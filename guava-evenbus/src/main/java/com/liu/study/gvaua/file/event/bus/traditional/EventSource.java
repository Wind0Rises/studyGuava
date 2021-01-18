package com.liu.study.gvaua.file.event.bus.traditional;

import java.util.ArrayList;
import java.util.List;

/**
 * 传统java程序--事件源。
 *
 * 向事件源中添加事件监听器--监听事件源。
 * 时间源达到某个条件触发事件。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 14:55
 */
public class EventSource {

    List<CustomerChangeListener> listeners = new ArrayList<>(16);

    public void register(CustomerChangeListener eventListener) {
        listeners.add(eventListener);
    }

    public void changeStatus() {
        System.out.println("==================");
        CustomerEvent event = new CustomerEvent("liuweian");
        listeners.stream().forEach(item -> {
            item.process(event);
        });
    }
}