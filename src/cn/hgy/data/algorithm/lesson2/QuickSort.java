package cn.hgy.data.algorithm.lesson2;

/**
 * 快速排序
 * <pre>
 *     算法介绍：
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrays = {11, 8, 3, 9, 7, 1, 2, 5};
//        sort(arrays, 0, arrays.length - 1);
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.print(arrays[i] + " ");
//        }
        partition(arrays, 0, 0,0);
    }

    public static void sort(int[] content, int start, int end) {

    }

    public static void partition(int[] content, int start, int mid, int end) {
        int value = content[content.length-1];
        int i = 0, j =0;
        for( ;i < content.length-1; i++){
            if(content[i] < value){
                int tmp = content[i];
                content[i] = content[j];
                content[j] = tmp;
                j++;
            }
        }
        content[i] = content[j];
        content[j] = value;

        i = 0;
        for (; i < content.length; i++) {
            System.out.print(content[i] + " ");
        }
    }

}
