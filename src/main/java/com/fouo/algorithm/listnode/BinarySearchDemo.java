package com.fouo.algorithm.listnode;

/**
 * 二分查找
 *  每次都要缩减区域
 *  每次缩减都不能排除潜在答案
 *
 *
 *  三大模板
 *  1.找一个准确的值
 *      循环条件 lo<=hi
 *      缩减空间 lo = mid +1  hi = mid -1;
 *  2.找一个模糊值(比4大的最小值)
 *       循环条件 lo<hi
 *       缩减空间 lo = mid hi = mid -1 或者 lo = mid+1 ,hi = mid;
 *  3.通用
 *        循环条件 lo <hi-1
 *        缩减空间 lo = mid ,hi = mid;
 * @author fouo
 * @date 2020/10/30 23:06
 */
public class BinarySearchDemo {


    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4,5};
        System.out.println(search(4,arr));
        Thread.sleep(Integer.MAX_VALUE);
    }

    public static int search(int n,int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid = lo +(hi-lo)/2;

        while(lo<hi){
            if(arr[mid]<n){
                lo = mid +1;
            }else if(arr[mid] == n){
                hi = mid;
            }else{
                hi = mid;
            }
            mid = lo +(hi-lo)/2;
        }
        return lo;
    }

    /**
     * 最基本的 只能查一个 数的位置，比较局限
     * @param n
     * @param arr
     * @return

    public static int search(int n,int[] arr){
        //确立边界
        int lo = 0;
        int hi = arr.length-1;
        int mid = lo +(hi-lo)/2;

        //确立循环
        while(lo<=hi){
            if(n == arr [mid]){
                return mid;
            }else if(n<arr[mid]){
                hi = mid -1;
            }else{
                lo = mid + 1;
            }
            mid = lo +(hi-lo)/2;
        }
        return -1;
    }    */
}
