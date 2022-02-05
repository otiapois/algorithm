package com.fouo.tx.day02;

/**
 * 把一个int类型的数提取出最右侧的1来
 * 0111010100 ---》 0000000100
 * 公式 a&(-a)
 * -a 也可以写成 ~a + 1 取反加1
 *
 * 0111 -> 0001
 * 1001
 * @author fouo
 * @date 2022/1/6 23:43
 */
public class RightOneDemo {
    public static void main(String[] args) {
        int a = 7;
        int ans = a&(-a);
        System.out.println(ans);
    }
}
