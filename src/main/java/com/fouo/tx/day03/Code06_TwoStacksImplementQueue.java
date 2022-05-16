package com.fouo.tx.day03;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {

    /**
     * PUSH    POP
     * 1
     * 2
     * 3
     * 7        4
     * 6        5
     * <p>
     * PUSH栈倒数据要一次性倒完全
     * <p>
     * POP栈没有拿完，PUSH不能倒数据
     */

    public static class TwoStacksQueue1 {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStacksQueue1() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        public void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public boolean isEmpty() {
            return popStack.isEmpty();
        }

        public void add(Integer value) {
            pushToPop();
            pushStack.push(value);
        }

        public int poll(){
            pushToPop();
            if(isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            int ans = popStack.pop();
            return ans;
        }

        public int peek(){
            pushToPop();
            if(isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            int ans = popStack.peek();
            return ans;
        }
    }

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPop = new Stack<>();
            this.stackPush = new Stack<>();
        }

        //倒数据
        public void pushToPop() {
            if (this.stackPop.isEmpty()) {
                while (!this.stackPush.isEmpty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }
        }

        //添加数据（向组成的队列中）
        public void add(int pushInt) {
            pushToPop();
            this.stackPush.push(pushInt);
        }

        public int poll() {
            pushToPop();
            if (this.stackPop.isEmpty()) {
                throw new RuntimeException("your queue is empty");
            }
            return this.stackPop.pop();
        }

        public int peek() {
            pushToPop();
            if (this.stackPop.isEmpty()) {
                throw new RuntimeException("your queue is empty");
            }
            return this.stackPop.peek();
        }

    }

    public static void main(String[] args) {
        TwoStacksQueue1 test = new TwoStacksQueue1();
        test.add(1);
        test.add(2);
        test.add(3);
//		System.out.println(test.peek());
        System.out.println(test.poll());
//		System.out.println(test.peek());
        System.out.println(test.poll());
//		System.out.println(test.peek());
        System.out.println(test.poll());
    }

}
