package com.fouo.xs.day03;

/**
 * 二分查找法 有序数组中找到>=num的最左位置
 * 查出目标函数最左的index    [1,2,2,2,2,3]  获取 index = 1  （>=2最左的位置 1）
 * 找大于等于num  最左的位置
 *
 * @author fouo
 * @date 2021/11/21 19:56
 */
public class BinSearchNearLeft {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3};
        System.out.println(mostLeftNoLessNumIndex(arr, 2));
    }

    /**
     * @param arr
     * @return
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length;
        //最晚发生的key
        int ans = -1;
        while (left <= right) {
            //t更新
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
