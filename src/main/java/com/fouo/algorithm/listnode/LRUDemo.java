package com.fouo.algorithm.listnode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU算法
 *
 * @author fouo
 * @date 2020/11/4 11:19
 */
public class LRUDemo<K,V> extends  LinkedHashMap<K,V> {

    private int capacity;//缓存容量

    /**
     *
     * @param capacity
     */
    public LRUDemo( int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }

    public static void main(String[] args) {
        LRUDemo<Object, Object> demo = new LRUDemo<>(3);

        demo.put(1, "a");
        demo.put(2, "b");
        demo.put(3, "c");

        System.out.println(demo.keySet());
        demo.put(4, "d");
        demo.put(1, "a");
        System.out.println(demo.keySet());
    }
}
