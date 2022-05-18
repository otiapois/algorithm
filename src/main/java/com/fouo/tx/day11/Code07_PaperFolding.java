package com.fouo.tx.day11;
/**
 * @author KONGLH
 * @title: 折纸，凹痕的左右可看作是左右子树
 * 			左子树是凹痕
 * 			右子树是凸痕
 * 		    按照中序排序的方式就可以将展开的痕迹完全打印出来
 * @projectName
 * @description:
 * @date  2022/5/17 17:28
 */
public class Code07_PaperFolding {

	public static void printAllFolds(int N) {
		process(1, N, true);
		System.out.println();
	}
//	public static void process(int i, int N, boolean down) {
//		if(i>N){
//			return;
//		}
//		process(i+1,N,true);
//		System.out.print(down?"凹 ":"凸 ");
//		process(i+1,N,false);
//	}
	// 当前你来了一个节点，脑海中想象的！
	// 这个节点在第i层，一共有N层，N固定不变的
	// 这个节点如果是凹的话，down = T
	// 这个节点如果是凸的话，down = F
	// 函数的功能：中序打印以你想象的节点为头的整棵树！
	public static void process(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		process(i + 1, N, true);
		System.out.print(down ? "凹 " : "凸 ");
		process(i + 1, N, false);
	}
	//凹 凹 凸 凹 凹 凸 凸
	//凹 凹 凸 凹 凹 凸 凸
	public static void main(String[] args) {
		int N = 3;
		printAllFolds(N);
	}
}
