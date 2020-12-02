package com.liu.study.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;

/**
 * {@link BiMap}（bidirectional map）一个key和value都是唯一的。
 *
 * @author Liuweian
 * @createTime 2020/8/20 22:12
 * @version 1.0.0
 */
public class BiMapDemo {

    /**
     * BiMap：一个key和value都是唯一的。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("1", "liu");
        hashBiMap.put("2", "luie");
        System.out.println(hashBiMap);

        hashBiMap.put("1", "liuweian");
        System.out.println(hashBiMap);

        /**
         * 抛错：value already present
         */
        try {
            hashBiMap.put("3", "liuweian");
            System.out.println(hashBiMap);
        } catch (Exception e) {
            System.err.println("向BiMap插入不同的key，但是对应的value已经存在，就会报错！");
        }


        BiMap<String, String> inverse = hashBiMap.inverse();
        System.out.println("------------------");
        System.out.println(hashBiMap);
        System.out.println(inverse);


        /**
         * 强制添加数据，把原有可key覆盖掉。保留原来的value值，把对应的key值换成新的。
         */
        System.out.println("-----------------  forcePut -------------------");
        System.out.println(hashBiMap);
        hashBiMap.forcePut("3", "liuweian");
        System.out.println(hashBiMap);
    }

}
