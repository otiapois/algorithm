package com.fouo.xs.day02;

/**
 * 前缀和数组
 *
 * @author fouo
 * @date 2021/11/15 0:09
 */
public class RangeSum {

    private static int[] intSum;

    public RangeSum(int[] arr) {
        int N = arr.length;
        intSum = new int[N];
        intSum[0] = arr[0];

        for (int i = 1; i < N; i++) {
            intSum[i] = intSum[i - 1] + arr[i];
        }
    }
    public int getSun(int[] arr,int L,int R){
        if(L>R || L<0 || R<0){
            return -1;
        }
       return L==0?intSum[R]:intSum[R]-intSum[L-1];
    }

    public static void main(String[] args) {

    }
}

