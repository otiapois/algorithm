package com.fouo.xs.day05;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 位图
 * %  表示取余
 * % 64 相当于保留后7位的数
 *
 * @author fouo
 * @date 2021/12/2 21:22
 */
public class BitMap2 {
    public static void main(String[] args) {
        System.out.println(129 % 64);
        System.out.println(129 >> 6);
    }

    public static class BitMap {

        private long[] bits;

        //max表示最大位图表示的最大数
        public BitMap(int max) {
            //max 0-63  +64  / 64  ==》1 表示 0-63的数用1个long就行     64~127 +64 / 64 ==>2  表示2个
            bits = new long[(max + 64) / 64];
        }

        public void add(int num) {
            // num >> 6 ->num/64  ->第几个整数  127/64 --》 1.xxx  等于说 第一个[0] 放 0-63  第二个[1] 放64-127
            //所以127 / 64 -》1.xxx ==》1  放在第[1]个里面
            //所以推出 num>>64 得出来的数 是几，就是下标为几的格子里面

            // num % 64 ->  num & 63
            bits[num >> 6] = bits[num >> 6] | (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] = bits[num >> 6] & ~(1L << (num & 63));
        }

        /**
         * 查询一个数在位图里面是否存在
         *
         * @param num
         * @return
         */
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }
}
