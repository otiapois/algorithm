package com.fouo.xs.day05;

/**
 * 位运算实现 + - * /
 *
 * @author fouo
 * @date 2021/12/5 15:28
 */
public class BitAddMinusMultiDev {
    public static void main(String[] args) {
        System.out.println(minus(5, 6));
        System.out.println(negNum(2));
        System.out.println(div2(Integer.MIN_VALUE, 3));
    }

    /**
     * 位运算加
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b; //无进位相加信息 ->sum
            b = (a & b) << 1; //进位信息-> b ->b'(进位信息)
            a = sum; // a->a' 无进位相加信息
        }
        return sum;
    }

    /**
     * a-b
     *
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return res;
    }

    //判断是否是负数
    public static boolean isNeg(int n) {
        return n < 0;
    }

    //取反
    public static int negNum(int a) {
        return add(~a, 1);
    }

    /**
     * a b 先转为负数
     * 该方法没有办法对系统最小值进行绝对值
     * 系统最小值的绝对值还是它本身
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        //  x/y
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res = res | (1 << i);
                x = minus(x, y << i);
            }
        }
        //判断 a和b的符号是否一样
//        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
        return isNeg(a) != isNeg(b) ? negNum(res) : res;
    }


    public static int div2(int a, int b) {
        // a 和 b 都是系统最小
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
            //b是系统最小
        } else if (b == Integer.MIN_VALUE) {
            return 0;
            //a是系统最小
        } else if (a == Integer.MIN_VALUE) {
            if(b==negNum(1)){//b == -1
                return Integer.MAX_VALUE;
            }else {
                // a/b
                // (a+1)/b = c
                // a - (c*b) = d   -20 -19  5  得到 -3   -3*5 = -15  -20-（-15） = -5 补偿值 d = -5
                // d / b = e   -5 / 5 = -1       这一步可以使用div的方法去除
                // return c+e
                int ans = div(add(a,1), b);
                return add(ans,div(minus(a, multi(ans,b)),b));
            }
        } else {
            // a和b都是系统最小
            return div(a, b);
        }

    }

}

