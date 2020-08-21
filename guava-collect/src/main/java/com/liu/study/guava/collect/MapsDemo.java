package com.liu.study.guava.collect;

import com.google.common.base.Converter;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 *
 * @author Liuweian
 * @createTime 2020/8/20 21:59
 * @version 1.0.0
 */
public class MapsDemo {

    public static void main(String[] args) {
        Converter<Object, Object> objectObjectConverter = Maps.asConverter(HashBiMap.create());
        System.out.println(objectObjectConverter);

        Set<String> collect = IntStream.range(0, 10).filter(item -> item > 0).mapToObj(item -> String.valueOf(item)).collect(Collectors.toSet());
        //IntStream.range(0, 10).collect()
        System.out.println(collect);

    }


}
