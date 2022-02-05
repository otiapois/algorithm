package com.fouo.xs.day02;

public class RandToRand {
    public static void main(String[] args) {
        //Math.random()  -->double  ->[0,1);  等概率返回
        int num = 1000000;
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < num; i++) {
            if (Math.random() < 0.9) {
                count++;
            }
        }

        System.out.println((double) count / (double) num);

        System.out.println("================================================");

        //  [0,1)->[0,8)
        for (int i = 0; i < num; i++) {
            if (Math.random() * 8 < 5) {
                count1++;
            }
        }
        System.out.println((double) count1 / (double) num);

        // [0,k)->[0,k-1]中的整数 等概率
        int k = 2;
        int ans = (int) Math.random() * k;
        System.out.println("================================================");


        double x = 0.7;
        for (int i = 0; i < num; i++) {
            if (xToPower2() < x) {
                count2++;
            }
        }
        System.out.println((double) count2 / (double) num);
        System.out.println(Math.pow(x, 2));
        System.out.println(xToPower2());
        System.out.println(Math.max(3, 2));
        System.out.println(Math.max(Math.random(), Math.random()));
//        for (int a=0;a<1000;a++){
//            System.out.print(f());
//        }
//        for (int a = 0; a < 100; a++) {
//            System.out.print(getZeroOne());
//        }

        int count4 = 0;
        for (int i = 0; i < 10000000; i++) {
            if (f5() == 0) {
                count4++;
            }
        }
        System.out.println((double) count4 / (double) 10000000);

    }

    /**
     * 实现0-x2的曲线的算法
     * 返回[0,1)的一个小数
     * 任意的x，x属于[0,1),[0,x)范围上的数出现概率由原来的x调成x平方
     */
    public static double xToPower2() {
        return Math.max(Math.random(), Math.random());
    }

    /**
     * 得到 1-5等待率返回一个
     *
     * @return
     */
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 得到 0 1 等概率返回一个
     *
     * @return
     */
    public static int getZeroOne() {
        int res = f();
        /*if(res == 0 || res ==1){
            return 0;
        }else if(res ==4 || res == 5){
            return 1;
        }else {
           return  getZeroOne();
        }*/

        while (res == 3) {
            res = f();
        }

        return res < 3 ? 0 : 1;
    }

    /**
     * 得到 0-7 等概率返回一个
     *
     * @return
     */
    public static int getZeroToSeven() {
        return (getZeroOne() << 2) + (getZeroOne() << 1) + (getZeroOne());
    }

    /**
     * 0-7等概率基础上 去掉7  遇到7 就重新执行
     * <p>
     * 1-7等概率
     *
     * @return
     */
    public static int getZeroToSixChangeOneToSeven() {
        int res = getZeroToSeven();
        while (res == 0) {
            res = getZeroToSeven();
        }
        return res;
    }


    /**
     * 3-19上等概率
     *
     * @return
     */
    public static int f2() {
        return (int) (Math.random() * 17) + 3;
    }

    /**
     * 做成 0-1等概率
     */
    public static int f3() {
        int res = f2();
        while (res == 19) {
            res = f2();
        }
        return res <= 10 ? 0 : 1;
    }

    /**
     * 20 -56 等概率
     * 0 - 36等概率  ==》0-63等概率  1 1 1  1 1 1 1
     *
     * @return
     */
    public static int f4() {
        return (f3() << 5) + (f3() << 4) + (f3() << 3) + (f3() << 2) + (f3() << 1) + f3();
    }

    /**
     * 0-36等概率 +20
     *
     * @return
     */
    public static int g() {
        int res = f4();
        while (res > 36) {
            res = f4();
        }
        return res + 20;
    }


    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 第1 2次结果相等  如 11   00的情况
     * 返回第二次 或第一次的结果即可为 0-1等概率
     *
     * 01  10 是等概率的 然后返回第一次 0    1  或者第二次  1   0  都是等概率
     * @return
     */
    public static int f5() {

        int res = x();
        while (res == x()) {
            res = x();
        }
        return res;
    }
}
