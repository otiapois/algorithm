package com.fouo.tx.day03;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {

	/**
	 * PUSH    POP
	 *         1
	 *         2
	 *         3
	 * 7       4
	 * 6       5
	 *
	 * PUSH栈倒数据要一次性倒完全
	 *
	 * POP栈没有拿完，PUSH不能倒数据
	 */
	public static class TwoStacksQueue {
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;

		public TwoStacksQueue() {
			this.stackPop = new Stack<Integer>();
			this.stackPush = new Stack<Integer>();
		}

		//倒数据
		public void pushToPop(){
			if(this.stackPop.isEmpty()){
				while(!this.stackPush.isEmpty()){
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
			if(this.stackPop.isEmpty()){
				throw new RuntimeException("your queue is empty");
			}
			return this.stackPop.pop();
		}
		public int peek() {
			pushToPop();
			if(this.stackPop.isEmpty()){
				throw new RuntimeException("your queue is empty");
			}
			return this.stackPop.peek();
		}

	}
//	public static class TwoStacksQueue {
//		public Stack<Integer> stackPush;
//		public Stack<Integer> stackPop;
//
//		public TwoStacksQueue() {
//			stackPush = new Stack<Integer>();
//			stackPop = new Stack<Integer>();
//		}
//
//		// push栈向pop栈倒入数据
//		private void pushToPop() {
//			if (stackPop.empty()) {
//				while (!stackPush.empty()) {
//					stackPop.push(stackPush.pop());
//				}
//			}
//		}
//
//		public void add(int pushInt) {
//			stackPush.push(pushInt);
//			pushToPop();
//		}
//
//		public int poll() {
//			if (stackPop.empty() && stackPush.empty()) {
//				throw new RuntimeException("Queue is empty!");
//			}
//			pushToPop();
//			return stackPop.pop();
//		}
//
//		public int peek() {
//			if (stackPop.empty() && stackPush.empty()) {
//				throw new RuntimeException("Queue is empty!");
//			}
//			pushToPop();
//			return stackPop.peek();
//		}
//	}

	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
