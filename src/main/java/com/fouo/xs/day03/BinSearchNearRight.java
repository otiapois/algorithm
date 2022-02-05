package com.fouo.xs.day03;

/**
 * 二分查找法 有序数组中找到<=num的最右位置
 * 查出目标函数最左的index    [1,2,2,2,2,3]  获取 index = 4  （<=2最右的位置 4）
 *
 * @author fouo
 * @date 2021/11/21 19:56
 */
public class BinSearchNearRight {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3,5};
        System.out.println(mostLeftNoThanNumIndex(arr, 4));
    }

    /**
     * @param arr
     * @return
     */
    public static int mostLeftNoThanNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
