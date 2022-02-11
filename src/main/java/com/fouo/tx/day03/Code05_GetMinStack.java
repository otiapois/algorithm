package com.fouo.tx.day03;

import java.util.Stack;

public class Code05_GetMinStack {

    /**
     *  获取栈中的最小值方式 1
     *  两个栈 一个数据栈 一个最小数栈
     *  添加一个数时，当最小数栈为空，两个栈都直接添加数据
     *  当再有新值进来时候，当该值<= 最小栈顶值时才会两个栈都加，否则只添加数据栈
     *  弹栈时
     *  只有当两个栈的数据都一样时才会将两个栈都弹，否则只弹数据栈中的数据
     */
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (num <= this.getmin()) {
                this.stackMin.push(num);
            }
            this.stackData.push(num);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            Integer value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        //获取最小值值需要拿到最小栈栈顶值即可不需要弹出来
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }


//	public static class MyStack1 {
//		private Stack<Integer> stackData;
//		private Stack<Integer> stackMin;
//
//		public MyStack1() {
//			this.stackData = new Stack<Integer>();
//			this.stackMin = new Stack<Integer>();
//		}
//
//		public void push(int newNum) {
//			if (this.stackMin.isEmpty()) {
//				this.stackMin.push(newNum);
//			} else if (newNum <= this.getmin()) {
//				this.stackMin.push(newNum);
//			}
//			this.stackData.push(newNum);
//		}
//
//		public int pop() {
//			if (this.stackData.isEmpty()) {
//				throw new RuntimeException("Your stack is empty.");
//			}
//			int value = this.stackData.pop();
//			if (value == this.getmin()) {
//				this.stackMin.pop();
//			}
//			return value;
//		}
//
//		public int getmin() {
//			if (this.stackMin.isEmpty()) {
//				throw new RuntimeException("Your stack is empty.");
//			}
//			return this.stackMin.peek();
//		}
//	}

	/*public static class MyStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getmin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}*/


    /**
     * 思路：两个栈，一个数据栈，一个最小栈
     * 每次往数据栈中添加一个数，当最小栈为空，也同时往最小栈中添加该数作为最小数
     * 继续添加数据，当新增的数比最小栈中栈顶的数还小，则两个栈把该数都各自添加一份
     * 否则将新增的数添加到数据栈中，把最小栈栈顶的数也同时添加
     * <p>
     * 弹栈的时候数据站还最小栈同时弹。
     * <p>
     * 获取最小值时，peek最小栈栈顶的数即可
     */
    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        //压栈
        public void push(int num) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(num);
            } else if (num < getMin()) {
                this.stackMin.push(num);
            } else {
                this.stackMin.push(getMin());
            }
            this.stackData.push(num);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        //获取最小栈中最小值
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
