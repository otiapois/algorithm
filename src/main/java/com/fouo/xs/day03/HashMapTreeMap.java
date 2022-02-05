package com.fouo.xs.day03;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * hash表
 * 增删改查都是 O(1) 时间复杂度
 * 但是这个常数时间很大
 * hash表中 全按照值传递  基本类型包装类
 * 普通类型按照引用传递
 *
 * TreeMap 时间复杂度 O(lgn)
 * Node 类型（普通对象类型） 不能直接用了 用了会出错
 * 因为要求key一定要求可比较的
 * @author fouo
 * @date 2021/11/21 22:56
 */
public class HashMapTreeMap {
    public static class Node {
        public int n;

        public Node(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        System.out.println(map.containsKey("name"));
        System.out.println(map.containsKey("nam"));
        System.out.println(map.get("name"));
        map.put("name", "lisi");
        System.out.println(map.get("name"));
        map.remove("name");
        System.out.println(map.containsKey("name"));


        String k1 = "zhangsan";
        String k2 = "zhangsan";
        map.put(k1, "zhangsan");
        System.out.println(map.containsKey(k1));
        System.out.println(map.containsKey(k2));


        Map<Integer, String> map2 = new HashMap<>();
        Integer k5 = 1;
        Integer k6 = 1;
        map2.put(k5, "zhangsan");
        System.out.println(map2.containsKey(1));
        System.out.println(map2.containsKey(k5));
        System.out.println(map2.containsKey(k6));

        Map<Integer, String> map1 = new HashMap<>();
        Integer k3 = 1213123;
        Integer k4 = 1213123;
        map1.put(k3, "zhangsan");
        System.out.println(map1.containsKey(1213123));
        System.out.println(map1.containsKey(k3));
        System.out.println(map1.containsKey(k4));
        System.out.println(k3 == k4);

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Map<Node, String> map4 = new HashMap<>();
        map4.put(node1, "111");
        System.out.println(map4.containsKey(node1));
        System.out.println(map4.containsKey(node2));


        System.out.println("============================有序表=============");
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(3, "333");
        treeMap1.put(1, "333");
        treeMap1.put(2, "333");
        treeMap1.put(55, "333");
        treeMap1.put(4, "333");
        treeMap1.put(5, "333");
        System.out.println(treeMap1.containsKey(1));
        System.out.println(treeMap1.get(1));
        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        //<=5 离5最近的返回来
        System.out.println(treeMap1.floorKey(5));
        //<=6 离6最近的返回来
        System.out.println(treeMap1.floorKey(6));
        //>=5 离5最近的返回来
        System.out.println(treeMap1.ceilingKey(5));
        //>=6 离6最近的返回来
        System.out.println(treeMap1.ceilingKey(6));
    }
}
