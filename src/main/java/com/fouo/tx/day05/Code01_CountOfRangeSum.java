package com.fouo.tx.day05;

// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length-1, lower, upper);
    }

    private static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)
                + merge(sum, L, M, R, lower, upper);
    }

    private static int merge(long[] sums, int L, int M, int R, int lower, int upper) {
        int res = 0;
        int windowR = L;
        int windowL = L;
        for (int i = M + 1; i <= R; i++) {
            long max = sums[i]-lower;
            long min = sums[i]-upper;
            while(windowR<=M && sums[windowR]<=max){
                windowR++;
            }
            while(windowL<=M && sums[windowL]<min){
                windowL++;
            }
            res += windowR - windowL;
        }

        long[] help = new long[R-L+1];
        int p1 = L;
        int p2 = M+1;
        int i=0;
        while(p1<=M && p2<=R){
            help[i++] = sums[p1]<=sums[p2]?sums[p1++]:sums[p2++];
        }
        while(p1<=M ){
            help[i++] = sums[p1++];
        }
        while(p2<=R){
            help[i++] = sums[p2++];
        }

        for(i=0;i< help.length;i++){
            sums[L+i] = help[i];
        }
        return res;
    }


//	public static int countRangeSum(int[] nums, int lower, int upper) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		long[] sum = new long[nums.length];
//		sum[0] = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			sum[i] = sum[i - 1] + nums[i];
//		}
//		return process(sum, 0, sum.length - 1, lower, upper);
//	}
//
//	public static int process(long[] sum, int L, int R, int lower, int upper) {
//		if (L == R) {
//			return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
//		}
//		int M = L + ((R - L) >> 1);
//		return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper)+ merge(sum, L, M, R, lower, upper);
//	}
//
//	public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
//		int ans = 0;
//		int windowL = L;
//		int windowR = L;
//		// [windowL, windowR)  对右组的每个数X 求左组中有多少个数 位于[X-UP ,X-LOWER]之间
//		for (int i = M + 1; i <= R; i++) {
//			long min = arr[i] - upper;
//			long max = arr[i] - lower;
//			while (windowR <= M && arr[windowR] <= max) {
//				windowR++;
//			}
//			while (windowL <= M && arr[windowL] < min) {
//				windowL++;
//			}
//			ans += windowR - windowL;
//		}
//		long[] help = new long[R - L + 1];
//		int i = 0;
//		int p1 = L;
//		int p2 = M + 1;
//		while (p1 <= M && p2 <= R) {
//			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//		}
//		while (p1 <= M) {
//			help[i++] = arr[p1++];
//		}
//		while (p2 <= R) {
//			help[i++] = arr[p2++];
//		}
//		for (i = 0; i < help.length; i++) {
//			arr[L + i] = help[i];
//		}
//		return ans;
//	}

}
