package com.fouo.xs.day08;

import java.util.Stack;

/**
 * 快速排序问题
 * 先进行划分  splitNum方法   patation（分层）
 * 1.然后对 小于区   大于区进行递归（相同）处理 最后即可排好
 *
 * @author fouo
 * @date 2021/12/12 20:04
 */
public class PartitionAndQuickSort {


    /**
     * 小于等于区域左边  大于在右边
     *
     * @param arr
     */
    public static void splitNum1(int[] arr) {
        //小于等于区的有边界
        int lessEqualR = 1;
        int index = 0;
        //最右侧的位置
        int mostR = arr.length - 1;

        while (index < arr.length) {
            //当前数<= P  最右侧数 当前数和<= 区的右侧下一个数做交换，<=区右扩一个
            if (arr[index] <= arr[mostR]) {
                swap(arr, lessEqualR + 1, index);
                lessEqualR++;
                index++;
//                swap(arr, ++lessEqualR, index++);
            } else { //当>p 当前数直接下一个
                index++;
            }
        }
    }

    /**
     * [小于区][等于区][大于区]
     *
     * @param arr
     */
    public static void splitNum2(int[] arr) {
        //小于区
        int lessR = -1;
        //大于区
        int moreL = arr.length - 1;
        int index = 0;
        while (index < moreL) {
            //当前位置的数小于划分值
            if (arr[index] < arr[arr.length - 1]) {
                swap(arr, lessR + 1, index);
                lessR++;
                index++;
//                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[arr.length - 1]) {          //当前位置的数大于划分值
                //大于区的前一个位置 和当前位置做交换
                swap(arr, moreL - 1, index);
                //大于区前移
                moreL--;
                //当前位置不动
            } else {
                index++;
            }
        }
        //划分值 最后一个数 要跟大于区域第一个位置做交换
        swap(arr, moreL, arr.length - 1);
    }

    // arr[L...R]范围上，拿arr[R]做划分值，
    // L....R < = >
    public static int[] partition(int[] arr, int L, int R) {
        //小于区
        int lessR = L - 1;
        //大于区
        int moreL = R;
        int index = L;
        while (index < moreL) {
            //当前位置的数小于划分值
            if (arr[index] < arr[R]) {
                swap(arr, lessR + 1, index);
                lessR++;
                index++;
//                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {          //当前位置的数大于划分值
                //大于区的前一个位置 和当前位置做交换
                swap(arr, moreL - 1, index);
                //大于区前移
                moreL--;
                //当前位置不动
            } else {
                index++;
            }
        }
        //划分值 最后一个数 要跟大于区域第一个位置做交换
        swap(arr, moreL, R);
        //小于区的下一个坐标   到 划分值位置
        return new int[]{lessR + 1, moreL};
    }

    //递归版本
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //非递归版本
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        //最大的任务  0  ~arr.length-1 上去排序
        stack.push(new Job(0, arr.length));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            //获取当前任务的左右边界
            int L = cur.L;
            int R = cur.R;
            //获取等于区域的位置
            int[] equalZone = partition(arr, L, R);
            //然后把大任务分裂成子任务
            if (equalZone[0] > cur.L){//有小于区域       L  ...[等于区0 ---等于区最后] ...R 等于区前面都是小于区
                stack.push(new Job(cur.L, equalZone[0]-1));
            }
            if(equalZone[1]<cur.R){//有大于区域
                stack.push(new Job(equalZone[1]+1, cur.R));
            }
        }

    }

    public static class Job {
        public int L;
        public int R;

        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //L<R  获取等于区域坐标
        int[] equalZone = partition(arr, L, R);
        //equalZone[0] 等于区域第一个数 equalZone[1]等于区域最后一个数
        //左边进行递归  小于区
        process(arr, L, equalZone[0] - 1);
        process(arr, equalZone[1] + 1, R);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
