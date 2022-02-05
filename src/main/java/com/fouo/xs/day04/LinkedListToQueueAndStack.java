package com.fouo.xs.day04;

/**
 * 链表实现队列和堆
 *
 * @author fouo
 * @date 2021/11/25 21:42
 */
public class LinkedListToQueueAndStack {
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V data) {
            this.value = data;
            next = null;
        }
    }

    //队列实现
    public static class MyQueue<V> {

        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        //接受某个值  入队列
        public void offer(V value) {

            Node<V> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V pop() {
            V ans = null;
            if(head!=null){
                ans = head.value;
                head = head.next;
                size--;
            }else{
                tail = null;
            }
            return ans;
        }
        public V peek(){
            return head!=null?head.value:null;
        }
    }

    //栈实现
    public static class MyStack<V>{
        private Node<V> head;
        private int size;

        public MyStack(){
            this.head = null;
            this.size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
        //压栈    老头变新头
        public void push(V data){
            Node<V> cur = new Node<>(data);
            if(head ==null){
                head = cur;
            }else{
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public V pop(){
            V ans = null;
            if(head!=null){
                ans = head.value;
                head = head.next;
                size--;
            }

            return ans;
        }


    }
}
