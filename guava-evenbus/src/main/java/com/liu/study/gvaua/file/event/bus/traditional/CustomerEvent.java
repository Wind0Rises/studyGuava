package com.liu.study.gvaua.file.event.bus.traditional;

import java.util.EventObject;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 15:37
 */
public class CustomerEvent extends EventObject {

    public CustomerEvent(Object source) {
        super(source);
    }
}