package com.liu.study.gvaua.file.event.bus.sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 【事件】--》用于{@link com.google.common.eventbus.Subscribe}修饰的方法传递参数。
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/13 15:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuavaEvent {

    private String data;

}