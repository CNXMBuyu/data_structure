package cn.hgy.data.algorithm.lesson2;

/**
 * 快速排序
 * <pre>
 *     算法介绍：
 *     1. 取一个中心点，将数组进行分区{@link #partition(int[], int, int)}，并返回中心点位置，数组为小于中心点，中心点，大于等于中心点
 *     2. 再分别对小于中心点，中心点和中心点，大于等于中心点进行分区{@link #sort(int[], int, int)}
 *     3. 当数组只有1个元素时，表示该数组已经排好序
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrays = {11, 8, 3, 9, 7, 1, 2, 5};
        sort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    public static void sort(int[] content, int p, int r) {
        // 递归停止条件:p>=r，表示这时候元素集合最小单位是2个
        if (p < r) {
            // 开始分区排序
            int mid = partition(content, p, r);

            sort(content, p, mid - 1);
            sort(content, mid + 1, r);
        }
    }

    /**
     * 分区，取分区中的最后一个元素作为pivot，将元素集合分为三个部分：小于pivot，pivot， 大于pivot
     *
     * @param content
     * @param p
     * @param r
     * @return 返回pivot的位置
     */
    public static int partition(int[] content, int p, int r) {
        int pivot = content[r];
        int i = p, j = p;
        for (; i < r; i++) {
            // 如果当前元素小于pivot，则需要将当前元素和j指向的元素交换位置
            if (content[i] < pivot) {
                int tmp = content[i];
                content[i] = content[j];
                content[j] = tmp;
                j++;
            }
        }
        // 最后交换pivot和j下标的位置
        content[r] = content[j];
        content[j] = pivot;

        return j;
    }

}
