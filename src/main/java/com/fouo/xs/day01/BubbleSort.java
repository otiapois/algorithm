package com.fouo.xs.day01;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 两两比较  谁大谁往后
 *
 * @author fouo
 * @date 2021/11/10 0:26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 22, 1, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //首先考虑边界
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 - n
        // 0 - n-1
        // 0 - n-2
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }












  /*      //0  n-1
        //0  n-2
        //0  n-3
        //0   end
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            // 01 12  23   end -1 end
            for (int j = 0; j <= end - 1; j++) {
              if(arr[j]>=arr[j+1]){
                  swap(j, j+1, arr);
              }
            }

        }*/

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
