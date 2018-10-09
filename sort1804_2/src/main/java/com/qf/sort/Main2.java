package com.qf.sort;

/**
 * 希尔排序 -> 插入排序
 */
public class Main2 {


    public static void main(String[] args) {
//        int[] arrays = {1,6,8, 3, 10, 9, 187, 45, 34, 15, 18,25};
//        shellSort(arrays);
//        System.out.println(Arrays.toString(arrays));

        int[] arrays = new int[200000];
        for(int i = 0; i < arrays.length;i++){
            arrays[i] = (int) (Math.random() * 500000);
        }

        long begin = System.currentTimeMillis();
        insertSort(arrays);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的耗时：" + (end - begin));

    }


    public static void shellSort(int[] arrays){
        int h = 1;//随着希尔排序的发展，最后增量一定要回到1，进行一次基本的插入排序
        while(h <= arrays.length/3){
            h = 3*h + 1;
        }

        //进行多次的插入排序 h=6
        while(h >= 1){
            System.out.println("当前插入排序的增量：" + h);
            //外层循环控制轮数
            for(int i = h; i < arrays.length; i++){
                //内层循环控制每一轮的比较次数
                for(int j = i; j >= h; j = j - h){
                    //arrays[j] ~ arrays[j-h]
                    if(arrays[j] < arrays[j-h]){
                        swap(arrays, j, j-h);
                    } else {
                        break;
                    }
                }
            }

            //增量的递减
            h = (h-1)/3;
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arrays){
        int h = 1;

        //外层循环控制轮数
        for(int i = h; i < arrays.length; i++){
            //内层循环控制每一轮的比较次数
            for(int j = i; j >= h; j = j - h){
                //arrays[j] ~ arrays[j-h]
                if(arrays[j] < arrays[j-h]){
                    swap(arrays, j, j-h);
                } else {
                    break;
                }
            }
        }
    }


    public static void swap(int[] arrays, int x, int y){
        int temp = arrays[x];
        arrays[x] = arrays[y];
        arrays[y] = temp;
    }

}
