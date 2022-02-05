package com.fouo.xs.day01;

/**
 * 打印二进制
 * 打印整数32机制的状态
 * 整型4字节 4*8 = 32位
 * <p>
 * 打印整数的32位
 * <p>
 * & 运算    1& 1 = 1    0& 1 = 1  0 & 0 = 0
 *
 * @author fouo
 * @date 2021/11/8 0:41
 */
public class PrintB {
    public static void main(String[] args) {
        test(1);
//        int num = 1;
//        print(num);//00000000000000000000000000000001
//        System.out.println();//~取反
//        print(~num);//11111111111111111111111111111110

//        int num1 = 321421421;
//        int num2 = 2131421;
//        print(num1);
//        System.out.println();
//        print(num2);
//        System.out.println();
//        System.out.println("====================");
//        print(num1 | num2); // 或
//        System.out.println();
//        System.out.println("====================");
//        print(num1 & num2); // 与
//        System.out.println();
//        System.out.println("====================");
//        print(num1 ^ num2);  //  异或，相同为0 相反为1
//        System.out.println();
//        System.out.println("====================");


//        int a =-4;
//        int b = a>>1;    //两个>右移，补位的时候会拿符号位补  带符号右移
//        print(a);
//        System.out.println();
//        print(b);

//        int a =-4;
//        int b = a>>>1;    //三个>右移，补位的时候都会拿0补  不带符号右移
//        print(a);
//        System.out.println();
//        print(b);
//        int a =4;
//        int b = -a;
//        int c = ~a+1;  //取反+1  也表示符号
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        int a =Integer.MIN_VALUE;
//        int b = -a;
//        int c = ~a+1;  //取反+1  也表示符号
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        int a =0;
//        int b = -a;
//        int c = ~a+1;  //取反+1  也表示符号
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);


    }

    public static void test(int num) {
        for(int i=31;i>=0;i--){
            System.out.print((num & (1<<i))==0?"0":"1");
        }

    }







    /**
     * 打印整型的32进制
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
}
