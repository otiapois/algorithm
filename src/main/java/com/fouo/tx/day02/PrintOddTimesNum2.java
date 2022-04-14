package com.fouo.tx.day02;

/**
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
 *
 * @author fouo
 * @date 2022/1/7 0:04
 */
public class PrintOddTimesNum2 {
    public static void main(String[] args) {
        int[] arr = {6, 10, 6, 6, 4, 4, 12, 12, 3, 3};
        printOddTimesNum3(arr);
    }

    private static void printOddTimesNum3(int[] arr) {
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor = eor ^ arr[i];
        }

        int rightOne = eor & (~eor+1);
        int onlyOne = 0 ;
        for(int i=0;i<arr.length;i++){
           if((arr[i]&rightOne)!=0){
               onlyOne = onlyOne ^ arr[i];
           }
        }
        System.out.println(onlyOne);
        System.out.println(onlyOne^eor);
    }

    private static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        //先用eor与整个数组遍历异或 最后能得出eor = 两个奇数异或     即eor = a^b
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        //找出eor的最右为1的数
        /**
         * eor = a ^ b;
         * eor!=0;
         * eor 必有一个位置上是1
         * 0110010
         * 0000010
         */
        int rightOne = eor &(~eor+1);// int rightOne = eor &(-eor);
        int onlyOne = 0;//eor'
        for (int i = 0; i < arr.length; i++) {
            // 000010   rightOne
            // 101011   arr[i]
            //即该位上是1的情况
            if((arr[i]&rightOne)!=0){
                onlyOne = onlyOne ^ arr[i];
            }
        }
        System.out.println(onlyOne);
        System.out.println(onlyOne^eor);
    }
}
