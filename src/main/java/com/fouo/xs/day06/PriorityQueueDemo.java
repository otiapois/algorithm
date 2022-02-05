package com.fouo.xs.day06;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 优先级队列，小根堆   最小的最优先       大根堆相反
 * O(lgn)
 * 跟有序有关的结构
 * @author fouo
 * @date 2021/12/6 23:47
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
//        PriorityQueue<Integer> head = new PriorityQueue<>(new MyComparator()); //添加比较器实现大根堆
        PriorityQueue<Integer> head = new PriorityQueue<>();
        head.add(4);
        head.add(3);
        head.add(9);
        head.add(6);

        while (!head.isEmpty()) {
            System.out.println(head.poll());
        }
        System.out.println("=================================");

        TreeSet set = new TreeSet();
        set.add(4);
        set.add(3);
        set.add(9);
        set.add(6);
    
    }

    /**
     * 比较器
     * 如果为负数 认为第一个返回
     * 如果为正数 认为第二个返回
     * 如果为0    认为返回哪个都可以
     */
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
