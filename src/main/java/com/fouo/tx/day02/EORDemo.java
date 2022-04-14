package com.fouo.tx.day02;

/**
 * 一个集合中 存在唯一一个出现奇数次的数 ，找出该数
 * 因为异或不存在顺序
 * 两个相同的值异或 为0
 * 0和其他的值异或 为其他任意值
 *
 * @author fouo
 * @date 2022/1/5 0:35
 */
public class EORDemo {
    public static void main(String[] args) {
//        int[] arr ={1,1,2,2,2,2,3,3,4,4,4,4,5};
        int[] arr = {5};
        int eor = getEor(arr);
        System.out.println(eor);
    }

    private static int getEor(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        } else if (arr.length == 1) {
            return arr[0];
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        return eor;
    }
}
