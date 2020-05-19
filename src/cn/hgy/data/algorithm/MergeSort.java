package cn.hgy.data.algorithm;

/**
 * 归并排序
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
        if (start < end) {
            int mid = (start + end) / 2;
            sort(content, start, mid);
            sort(content, mid + 1, end);
            merge(content, start, mid, end);
        }
    }

    /**
     * 合并start到end之间的元素
     *
     * @param content
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] content, int start, int mid, int end) {

        int p1 = start, p2 = mid + 1;
        int[] temp = new int[end - start + 1];
        int i = 0;
        while (p1 <= mid && p2 <= end) {
            if (content[p1] < content[p2]) {
                temp[i] = content[p1];
                p1++;
            } else {
                temp[i] = content[p2];
                p2++;
            }
            i++;
        }

        for (; p1 <= mid; p1++) {
            temp[i] = content[p1];
            i++;
        }

        for (; p2 <= end; p2++) {
            temp[i] = content[p2];
            i++;
        }

        for (int j = start; j <= end; j++) {
            content[j] = temp[j - start];
        }
    }

}