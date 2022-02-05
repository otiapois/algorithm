package com.fouo.xs.day03;

/**
 * 二分查找法
 * 需要数组是有序的
 *
 * @author fouo
 * @date 2021/11/21 19:56
 */
public class BinSearch {
    public static void main(String[] args) {

    }

    /**
     * @param arr
     * @return
     */
    public static boolean binrarySearch(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return false;
        }
        //左边
        int left = 0;
        //有边界
        int right = arr.length - 1;
        //循环终止条件
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
