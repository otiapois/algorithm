package com.fouo.xs.day01;

/**
 * 获取 1!+2!+3!+...N!
 * 1!   ===>1
 * 2!   ===>1!*2
 * 3!   ===>2!*3
 * n!   ===>(n-1)!*n
 *
 * @author fouo
 * @date 2021/11/9 0:30
 */
public class GetNJie {
    public static void main(String[] args) {
        int n = 3;
        testN(n);

    }

    private static void testN(int n) {
        int cur = 1;
        int temp = 0;

        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            temp = temp + cur;
        }
        System.out.println(temp);

    }


    private static void getN(int n) {
        int cur = 1;
        int temp = 0;

        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            temp += cur;
        }
        System.out.println(temp);
    }
}
