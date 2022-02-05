package com.fouo.xs.day02;

import com.fouo.xs.day01.BubbleSort;
import com.fouo.xs.day01.InsertSort;
import com.fouo.xs.day01.SelectSort;

import java.util.Arrays;

/**
 * 对数器
 *
 * @author fouo
 * @date 2021/11/16 22:56
 */
public class Comp {


    /**
     * 对数器
     */
    public static void comp() {

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

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * arr1 和 arr2等长度
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean equalValue(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSorted(int[] arr) {
        if(arr.length<2){
            return  true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max >arr[i]) {
                return false;
            }
            max = Math.max(max , arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 55, 3, 22, 5, 33, 2, 11, 3, 0};
//        InsertSort.sort(arr);
//        int[] ints = lenRandomValueRandom(20, 3);
//        System.out.println(Arrays.toString(ints));

        int maxLen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);

            InsertSort.sort(arr1);
            SelectSort.sort(arr2);

            if( !isSorted(arr1)){
                System.out.println("插入排序错误");
            }
            if( !isSorted(arr2)){
                System.out.println("选择排序错误");
            }
        }
    }
}
