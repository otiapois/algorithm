package com.fouo.xs.day01;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 插入排序
 *
 * @author fouo
 * @date 2021/11/10 0:50
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 22, 1, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort1(int[] arr) {
        //首先考虑边界
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0    0  完成
        // 0    1  范围上有序
        // 0    2  范围上有序
        // 0    3  范围上有序
        // 0    N  范围上有序      结尾位置在变，所以描述一个结尾   i表示描述  i表示结尾
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int newNumberIndex = i;
            while (newNumberIndex - 1 >= 0 && arr[newNumberIndex] < arr[newNumberIndex - 1]) {
                swap(newNumberIndex, newNumberIndex - 1, arr);
                newNumberIndex--;
            }
        }




            /*for (int i = 0; i < N; i++) {
                //从后往前插，先找最后一个数的位置
                int newNumberIndex = i;
                // i-1 表示左边有数 ,且 左边比右边大    那么 左边和右边进行交换    然后就再向左移动一次
                while (newNumberIndex - 1 >= 0 && arr[newNumberIndex - 1] > arr[newNumberIndex]) {
                    swap(newNumberIndex - 1, newNumberIndex, arr);
                    newNumberIndex--;
                }

            }
*/
    }

    /**
     * 优化版
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        //首先考虑边界
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0    0  完成
        // 0    1  范围上有序
        // 0    2  范围上有序
        // 0    3  范围上有序
        // 0    N  范围上有序      结尾位置在变，所以描述一个结尾   i表示描述  i表示结尾
        int N = arr.length;
        for(int i=0;i<N;i++){
            for(int j=i;j-1>=0 && arr[j]<arr[j-1];j--){
                swap(j, j-1, arr);
            }
        }




//        for (int i = 0; i < N; i++) {
//            //pre 是新数前一个位置 新数是i  所以是i-1
//            for (int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
//                swap(pre, pre + 1, arr);
//            }
//        }

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 插入排序对数期
     *
     * @author fouo
     * @date 2021/11/16 22:56
     */
    public static void comp(){

    }
}
