package com.fouo.xs.day01;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 0 - n-1 范围   遍历一遍 吧最小值放最左边
 * <p>
 * 注意首先要注意边界条件
 *
 * @author fouo
 * @date 2021/11/9 0:42
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 421, 532, 2, 3, 4511, 4, 34, 2, 32, 1, 5, 45, 452, 432, 6};
        long s = System.currentTimeMillis();
        sort(arr);
        long e = System.currentTimeMillis();
        System.out.println(e - s);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            swap(i, minValueIndex, arr);
        }

//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    swap(i, j, arr);
//                }
//            }
//        }
        // 0 - N-1
        // 1 - N-1
        // 2 - N-1


     /*   //0 ~ n-1
        //1 ~ n-1
        //2 ~ n-1

        //选择排序 每次二选一个小的
        for (int i = 0; i < arr.length; i++) {
            //0 ~ n-1
            //1 ~ n-1
            //2 ~ n-1
            //i ~ n-1
            //起初默认i位置上的值最小
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //每次将两个值比较大小，选择小的，继续跟后面的值进行比较
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            //将最小值位置上的值和i位置上的值交换
            swap(i, minValueIndex, arr);
        }*/

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
