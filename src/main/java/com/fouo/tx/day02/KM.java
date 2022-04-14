package com.fouo.tx.day02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * arr中只有一种数出现K次
 * 其他数都出现了M次
 * K<M
 * 且M>1
 * 求出现K次的数是哪个
 *
 * @author fouo
 * @date 2022/2/1 21:01
 */
public class KM {
    public static int onlyKTimes2(int[] arr, int k, int m) {
        int[] temp = new int[32];
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                temp[i] += num >> i & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < temp.length; i++) {
           if(( temp[i] % m )!=0){
               res |= 1<<i;
           }
        }

        return res;
    }


    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
//                if (((num >> i) & 1) != 0) {
//                    t[i]++;
//                }
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int n = 0; n < t.length; n++) {
            if ((t[n] % m) != 0) {
                ans |= 1 << n;
            }
        }
        return ans;
    }


    public static int onlyKTimes1(int[] arr, int k, int m) {
        //准备一个长度为32的数组
        int[] t = new int[32];
        //t[0] 位置表示 0位置的1出现了几个
        //t[i] 位置表示 i位置的1出现了几个
        //封装数组
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                //当前位上是1(一次提取出每一位的状态 0|1)
//                if (((num >> i) & 1) != 0) {
//                    t[i]++;
//                }
                t[i] += (num >> i) & 1;//优化版本
            }
        }
        int ans = 0;
        for (int n = 0; n < t.length; n++) {
            if ((t[n] % m) != 0) {
                ans |= (1 << n);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {4,4,3,3,3,2,2,2};
//        int i = test(arr, 2, 3);
//        System.out.println(i);
        System.out.println("测试开始");
        int kinds = 30;
        int range = 200;
        int testTimes = 1000000;
        int max = 9;
        for (int i = 0; i < testTimes; i++) {
            int a = (int) Math.random() * max + 1; //a 的范围是 1-9之间的一个随机数
            int b = (int) Math.random() * max + 1; //b 的范围是 1-9之间的一个随机数
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes2(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("错误");
            }
        }
        System.out.println("测试结束");
    }

    public static int[] randomArray(int maxkinds, int range, int k, int m) {
        int ktimesNum = randomNumber(range);//出现K次的一种数
        int numKinds = (int) (Math.random() * maxkinds) + 2;//数的种类
        int[] res = new int[k + (numKinds - 1) * m];//创建数组
        int index = 0;
        //封装出现k次的那一种数
        for (; index < k; index++) {
            res[index] = ktimesNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimesNum);

        while (numKinds != 0) {
            int curNum;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                res[index++] = curNum;
            }
        }
        //打乱数组中的元素
//        for (int i = 0; i < res.length; i++) {
//            int j = (int)(Math.random()*res.length);
//            int temp = res[i];
//            res[j] = res[i];
//            res[j] = temp;
//        }

        return res;
    }

    public static int[] randomArray1(int maxkinds, int range, int k, int m) {
        int ktimenum = randomNumber(range);//k次的数 随机产生的目标数也就是result
        //一共有多少种数 >2
        int numKinds = (int) Math.random() * maxkinds + 2;
        //  k * 1 + (numKinds-1)*m数组长度
        int[] arr = new int[k + (numKinds - 1) * m];

        int index = 0;
        //数组下标 0- (k-1) 上都是  出现k次的数
        for (; index < k; index++) {
            arr[index] = ktimenum;
        }
        //除去一种出现次数为k的数 剩下都出现M次的 数的种类数
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimenum);

        while (numKinds != 0) {
            int curNum = 0;
            //保证每次roll出来的数是新的
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            //把新数放到set中去
            set.add(curNum);
            numKinds--;
            //把出现m次的数放到数组中去
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        //打乱数组中的数
        for (int i = 0; i < arr.length; i++) {
            //i位置的数想随机的跟j位置上的数做交换
            int j = (int) (Math.random() * arr.length);//0~N-1
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    // 返回从[-range,+range]中的一个
    public static int randomNumber(int range) {
        return (int) (Math.random() * range) + 1 - ((int) (Math.random() * range) + 1);
    }

    /**
     * @param arr 测试数组
     * @param k   唯一一种类型的数出现的次数
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                return key;
            }
        }
        return -1;
    }


    public static int test1(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() == k){
//                ans = entry.getKey();
//            }
//        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                return key;
            }
        }
        return -1;
    }
}
