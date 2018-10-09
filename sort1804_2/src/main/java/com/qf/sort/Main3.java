package com.qf.sort;

/**
 * 快速排序
 */
public class Main3 {

    public static void main(String[] args) {
//        int[] arrays = {6, 1, 5, 2 ,9, 8, 4, 10, 15};
//        quickSort(arrays, 0, arrays.length - 1);
//        System.out.println("划分之后的结果：" + Arrays.toString(arrays));


        int[] arrays = new int[200000];
        for(int i = 0; i < arrays.length;i++){
            arrays[i] = (int) (Math.random() * 500000);
        }

        long begin = System.currentTimeMillis();
        quickSort(arrays, 0, arrays.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序的耗时：" + (end - begin));
    }


    /**
     * 快速排序
     */
    public static void quickSort(int[] arrays, int begin, int end){

        if(begin >= end){
            return;
        }

        //先对整个数组进行划分
        int index = huafen(arrays, begin, end);

        //begin ~ index - 1
        quickSort(arrays, begin, index - 1);
        //index + 1 ~ end
        quickSort(arrays, index + 1, end);

    }

    /**
     * 划分算法的改良 - 划分一个数组的某个范围（being - end） - 返回基准值最终的位置
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    public static int huafen(int[] arrays, int begin, int end){
        //获取第一个元素为基数
        int key = arrays[begin];

        //
        int i = begin;
        int j = end;

        while(i < j){
            //从后往前比较
            while(i < j && arrays[j] >= key) j--;
            //为了提升性能，只做覆盖
            arrays[i] = arrays[j];

            while(i < j && arrays[i] <= key) i++;
            //
            arrays[j] = arrays[i];
        }

        //确定最终基准值的位置
        arrays[i] = key;
        return i;
    }


    /**
     * 划分算法
     *
     * 给一个数组，设置一个基数（第一个元素/最后一个元素），
     * 通过划分算法获得一个结果：
     * 这个基数的前面全部比基数要小，后面全部比基数要大
     *

    public static void pthuafen(int[] arrays){
        //获取第一个元素为基数
        int key = arrays[0];

        //
        int i = 0;
        int j = arrays.length - 1;

        while(i < j){
            //从后往前比较
            while(i < j && arrays[j] >= key) j--;
            //为了提升性能，只做覆盖
            arrays[i] = arrays[j];

            while(i < j && arrays[i] <= key) i++;
            //
            arrays[j] = arrays[i];
        }

        //确定最终基准值的位置
        arrays[i] = key;
    }*/
}
