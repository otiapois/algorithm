package com.fouo.xs.day04;

/**
 * 双端链表构成双向队列
 *
 * @author fouo
 * @date 2021/11/28 22:26
 */
public class DoubleLinkedListToDeque {
    public static class DoubleNode<V> {
        public V value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(V data) {
            this.value = data;
        }
    }

    public static class MyDeque<V> {
        private DoubleNode<V> head;
        private DoubleNode<V> tail;
        private int size;

        public MyDeque() {
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

        /**
         * 从头部加
         *
         * @param value
         */
        public void offerHead(V value) {
            DoubleNode<V> curr = new DoubleNode<V>(value);
            if (size == 0) {
                head = curr;
                tail = curr;
            } else {
                curr.next = head;
                head.last = curr;
                head = curr;
            }
            size++;
        }

        /**
         * 从尾部加
         *
         * @param value
         */
        public void offerTail(V value) {
            DoubleNode<V> curr = new DoubleNode<V>(value);
            if (size == 0) {
                head = curr;
                tail = curr;
            } else {
                curr.last = tail;
                tail.next = curr;
                tail = curr;
            }
            size++;
        }

        /**
         * 从头部弹出
         *
         * @return
         */
        public V popHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                tail = null;
                head = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        /**
         * 从尾部弹出
         *
         * @return
         */
        public V popTail() {
            V ans = null;
            if (tail == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }
    }

}
