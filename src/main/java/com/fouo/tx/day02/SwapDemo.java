package com.fouo.tx.day02;

import java.util.Arrays;

/**
 * 通过异或进行交换
 *
 * @author fouo
 * @date 2022/1/5 0:07
 */
public class SwapDemo {
    public static void main(String[] args) {
        int[] arr = {3,2};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
//        int a = 10;
//        int b = 2;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println("===========完成异或交换操作=========================");
//        a = a^b;
//        b = a^b;
//        a = a^b;
//
//        System.out.println(a);
//        System.out.println(b);
    }

    /**
     * 普通的交换
     * @param arr
     * @param a
     * @param b
     */
    public static void swapo(int[] arr,int a,int b){
       int temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
    }

    /**
     * 通过异或形式的交换
     * @param arr
     * @param a
     * @param b
     * 注意 a 和 b 在内存中的地址不能为同一个 否则则会变成0
     *         int[] arr = {3,2};
     *         swap(arr, 0, 0);
     *         System.out.println(Arrays.toString(arr));
     *         结果为 [0,2] 结果就是错误的
     */
    public static void swap(int[] arr,int a,int b){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }
}
