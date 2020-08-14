package com.liu.study.gvaua.file.traditional;

import java.util.EventListener;
import java.util.EventObject;

/**
 * 传统java程序，创建一个Event是通过实现Event接口。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 14:46
 */
public class CustomerChangeListener implements EventListener {

    public void process(EventObject event) {
        System.out.println("事件");
    }

}