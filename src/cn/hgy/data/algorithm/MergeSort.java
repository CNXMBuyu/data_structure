package cn.hgy.data.algorithm;

/**
 * 归并排序
 * <pre>
 *     算法介绍：将待排序数组进行分组，分组的最终目标是两个元素一组；将每个分组的元素排序，再合并
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arrays = {11, 8, 3, 9, 7, 1, 2, 5};
        sort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    public static void sort(int[] content, int start, int end) {
        // 将元素进行递归分组，递归结束条件是两个元素一组
        if (start < end) {
            int mid = (start + end) / 2;
            sort(content, start, mid);
            sort(content, mid + 1, end);
            // 合并元素
            merge(content, start, mid, end);
        }
    }

    /**
     * 合并元素，保证每个元素组是有序的
     *
     * @param content
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] content, int start, int mid, int end) {
        // 因为归并排序合并时，是两个元素集合进行合并，所以需要两个指针下标
        // p2指针为第二个元素的下标，所以是mid+1
        // 例如元素集合（11 8），那么第一个元素集合下标就是0，第二个就是1，以此类推
        int p1 = start, p2 = mid + 1;
        int[] temp = new int[end - start + 1];
        int i = 0;
        while (p1 <= mid && p2 <= end) {
            if (content[p1] < content[p2]) {
                temp[i++] = content[p1++];
            } else {
                temp[i++] = content[p2++];
            }
        }

        // 当存在其中一个元素集合为空的时候，直接将另一个元素集合的元素追加在尾部
        while (p1 <= mid) {
            temp[i++] = content[p1++];
        }

        while (p2 <= end) {
            temp[i++] = content[p2++];
        }

        for (int j = start; j <= end; j++) {
            content[j] = temp[j - start];
        }
    }

}