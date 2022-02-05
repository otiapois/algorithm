package com.fouo.algorithm.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.构造node节点
 * 2.构建一个双向链表
 *
 * @author fouo
 * @date 2020/11/4 11:42
 */
public class LRUDemo2 {

    //1.构造node节点
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = null;
            this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }


    }

    //2构建一个双向链表
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        //2.1构建一个双向链表
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //2.2添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //2.3 删除节点
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        //2.4 获取最后一个节点
        public Node getLast(){
            return tail.prev;
        }

    }

    //3.初始化参数
    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    //4.初始化构造方法
    public LRUDemo2(int cacheSize) {
        this.cacheSize = cacheSize;
        map  = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    //5 读 （代表最新用过一次） 插到对头
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        //插到对头  先删 后添加
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }
    //6 写
    public void put(int key,int value){

        //如果已经存在就更新
        if(map.containsKey(key)){//update
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);

            //再把这个最新的节点弄到队列最前面
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if(map.size() == cacheSize){
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);

                doubleLinkedList.removeNode(lastNode);
            }
            //新增
            Node<Integer, Integer> newNode = new Node<Integer, Integer>(key,value);
            map.put(newNode.key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }
    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.print("CNN ");
            }
        };
        t.run();
        System.out.print("FakeNews ");
        System.out.print("; ");
        t.start();
        System.out.print("FakeNews ");

    }
}
