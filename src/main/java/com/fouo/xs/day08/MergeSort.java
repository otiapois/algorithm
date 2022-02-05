package com.fouo.xs.day08;

/**
 * 归并排序
 *
 * @author fouo
 * @date 2021/12/12 17:22
 */
public class MergeSort {
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //步长
        int step = 1;
        //步长小于等于总长度的时候才会继续
        while (step < arr.length) {
            int L = 0;
            while (L < arr.length) {
//            int M = Math.min(L + step - 1, arr.length - 1);   L + step - 1  这个数可能溢出，溢出就是个负数就错了
                int M = 0;
                // 最后位置到 L的长度  为了方便理解 没有化简
                if (arr.length - 1 - L + 1 >= step) {
                    M = L + step - 1;
                } else {
                    M = arr.length - 1;
                }

                if (M == arr.length - 1) {
                    break;
                }
                int R = 0;
                if (arr.length - 1 - (M + 1) + 1 >= step) {
                    R = M + 1 + step - 1;
                } else {
                    R = arr.length - 1;
                }
                // L....M  M+1 ...R R+1
                merge(arr, L, M, R);
//                L = R+1;  此时有可能R+1仍然越界
                if (R == arr.length - 1) {
                    break;
                } else {
                    L = R + 1;
                }
            }
            //规定每一步的步长
            if (step > (arr.length / 2)) {
                break;
            } else {
                step *= 2;
            }
        }
    }

    // arr[L...R]范围上，请让这个范围上的数，有序！
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        //int mid = (L+R)/2;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        //进行合并
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        //创建一个整体大小的数组
        int[] help = new int[R - L + 1];
        int i = 0;
        // 左侧起始
        int p1 = L;
        // 右侧起始
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //讨论有一半越界的情况
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        //帮助数组构建完，遍历帮助数组
        for (int n = 0; n < help.length; n++) {
            arr[L + n] = help[n];
        }
    }
}
