package com.fouo.xs.day03;

import java.util.Arrays;

/**
 * 二分查询无序数组中局部最小的一个数
 * 相邻的数据不相等
 *
 * @author fouo
 * @date 2021/11/21 20:54
 */
public class BinSearchNoSortMin {
    public static void main(String[] args) {
//        int[] arr = {3,2,6,2,5};
        int maxLen = 50;
        int maxValue = 30;
        int testTime = 1000000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            System.out.println(Arrays.toString(arr));
            System.out.println(check(arr, getMinIndex(arr)));
        }
//        int minIndex = getMinIndex(arr);
//        System.out.println(minIndex);

    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;

        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    /**
     * arr 整体无序，但要满足相邻的数不相等
     *
     * @param arr
     * @return
     */
    public static int getMinIndex(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        if (arr[0] < arr[1]) {
            return 0;
        } else if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 返回一个长度、值都是随机的数组
     *
     * @param maxLen   [0,maxLen-1]
     * @param maxValue [0,maxVale-1]
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];

        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }
}
