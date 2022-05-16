package com.fouo.tx.day03;

/**
 * 通过数组的方式实现队列
 */
public class Code04_RingArray {

    public static class MyQueue1 {
        private int[] arr;
        private int pushi;
        private int popi;
        private int limit;
        private int size;

        public MyQueue1(int limit) {
            this.arr = new int[limit];
            this.pushi = 0;
            this.popi = 0;
            this.size = 0;
            this.limit = limit;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public boolean isFull(){
            return size == limit;
        }

        public void add(Integer value){
            if(isFull()){
                throw new RuntimeException("queue is full");
            }
            size++;
            arr[pushi] = value;
            pushi = nextInt(pushi);
        }

        public int poll(){
            if(isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            size--;
            int ans = arr[popi];
            popi = nextInt(popi);
            return ans;
        }
        private int nextInt(int pushi) {
            return pushi<limit-1?pushi+1:0;
        }

    }





    public static class MyQueue {
        private int[] arr;
        private int pushi;// end
        private int polli;// begin
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
