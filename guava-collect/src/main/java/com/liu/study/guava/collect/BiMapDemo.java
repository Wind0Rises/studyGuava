package com.liu.study.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;

/**
 * @desc 
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
        hashBiMap.put("1", "liu");
        System.out.println(hashBiMap);
        hashBiMap.put("we", "we");
        System.out.println(hashBiMap);
        /**
         * 抛错：value already present: liu
         */
        /**
        hashBiMap.put("3", "liu");
        System.out.println(hashBiMap);
         */


        BiMap<String, String> inverse = hashBiMap.inverse();
        System.out.println("------------------");
        System.out.println(hashBiMap);
        System.out.println(inverse);

        /**
         * 强制添加数据，把原有可key覆盖掉。
         */
        hashBiMap.forcePut("liweeee", "we");
        System.out.println(hashBiMap);
    }

}
