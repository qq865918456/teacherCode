package com.qf.sort;

import java.util.Arrays;

/**
 * 排序
 * 八大排序算法：
 * O(n^2)
 * 冒泡排序
 * 选择排序
 * 插入排序
 *
 * 归并排序
 * 希尔排序
 * 快速排序
 * 堆排序
 * 基数排序
 *
 * 冒泡排序
 * 选择排序：比较次数和冒泡一样，但是将交换次数降到了最低，因此选择排序的性能>=冒泡排序
 * 插入排序：对于一个基本有序的数组来说，插入排序的性能会非常好，相对来说降低了交换和比较的次数
 *  插入排序的性能：插入排序 略> 选择排序 >= 冒泡排序
 *  如果一个数组刚好完全倒叙，插入排序的性能就和冒泡排序一样了
 */
public class Main {

    public static void main(String[] args) {
//        int[] array = {10, 8, 5, 14, 29, 18, 55, 2, 108};
//        maopaoSort(array);

//        guibing();
//        guibingSort(array, new int[array.length], 0, array.length-1);

//        System.out.println("归并排序的结果：" + Arrays.toString(array));



        int[] arrays = new int[200000];
        int[] arrays2 = new int[200000];
        for(int i = 0; i < arrays.length;i++){
            arrays[i] = (int) (Math.random() * 500000);
            arrays2[i] = arrays[i];
        }

        long begin = System.currentTimeMillis();
        maopaoSort(arrays);
        long end = System.currentTimeMillis();
        System.out.println("冒泡的耗时：" + (end - begin));

        long begin2 = System.currentTimeMillis();
        guibingSort(arrays2, new int[arrays.length], 0, arrays.length-1);
        long end2 = System.currentTimeMillis();
        System.out.println("归并的耗时：" + (end2 - begin2));

    }


    /**
     * 冒泡排序法
     */
    public static void maopaoSort(int[] arrays){

        //外层循环控制轮数
        for(int i = 0; i < arrays.length - 1; i++){
            //内层循环控制这一轮中相邻的元素两两比较
            for(int j = 0; j < arrays.length - 1 - i; j++){
                //是哪两个元素比较 array[j] array[j+1]
                if(arrays[j] > arrays[j + 1]){
                    swap(arrays, j, j+1);
                }
            }
        }

//        System.out.println("排序的结果：" + Arrays.toString(arrays));
    }


    /**
     * 归并排序 - 递归
     */
    public static void guibingSort(int[] arrays, int[] arrays2, int begin, int end){

        if(begin == end){
            return;
        }

        int middle = (begin + end)/2;
        //arrays[begin] ~ arrays[middle]
        guibingSort(arrays, arrays2, begin, middle);
        //arrays[middle + 1] ~ arrays[end]
        guibingSort(arrays, arrays2, middle + 1, end);

        //对这两个数组进行归并算法
        for (int x = begin, y = middle + 1, z = 0; x<=middle || y<=end; z++){
            if((y==end+1) || (x <= middle && (arrays[x] < arrays[y]))){
                arrays2[z] = arrays[x];
                x++;
            } else {
                arrays2[z] = arrays[y];
                y++;
            }
        }

        //将第三方数组有序的而结果回填到原来数组中
        for(int z = 0, k = begin; k <= end; z++,k++){
            arrays[k] = arrays2[z];
        }
    }

    /**
     * 归并算法:将两个有序的数组合并成一个有序的数组
     */
    public static void guibing(){

        int[] a = {1, 8, 10, 15, 19, 25};
        int[] b = {9, 14, 18};

        //归并后的数组
        int[] array = new int[a.length + b.length];

//        int x, y, z; 分别代表3个数组的下标
        for(int x=0, y=0, z=0; z<array.length; z++){
            if((y == b.length) || a[x] < b[y]){
                array[z] = a[x];
                x++;
            } else if((x == a.length) || a[x] >= b[y]){
                array[z] = b[y];
                y++;
            }
        }

        System.out.println("归并的结果：" + Arrays.toString(array));
    }


    public static void swap(int[] arrays, int x, int y){
        int temp = arrays[x];
        arrays[x] = arrays[y];
        arrays[y] = temp;
    }

}
