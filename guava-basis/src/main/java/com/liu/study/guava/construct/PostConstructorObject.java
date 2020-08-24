package com.liu.study.guava.construct;

import javax.annotation.PostConstruct;

/**
 * {@link javax.annotation.PostConstruct} 测试对象。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/24 10:16
 */
public class PostConstructorObject {

    public PostConstructorObject() {
        System.out.println("------ constructor method --------");
    }

    /**
     * 只能作用在分静态的void的方法。
     *
     * PostConstruct注解  用于 需要依赖注入完成 以执行任何初始化之后需要执行的方法上。 用于依赖注入完成后的初始化操作。
     *
     */
    @PostConstruct
    public void initMethod() {
        System.out.println("------ is modified PostConstruct annotation --------");
    }


}