package cn.hgy.data.algorithm.lesson2;

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

    /**
     * 排序，适用递归方式来实现
     *
     * @param content
     * @param p
     * @param r
     */
    public static void sort(int[] content, int p, int r) {
        // 递归停止条件，表示这时候元素集合最小单位是2个
        if (p < r) {
            int mid = (p + r) / 2;
            sort(content, p, mid);
            sort(content, mid + 1, r);

            // 开始合并元素
            merge(content, p, mid, r);
        }
    }

    /**
     * 合并元素，保证每个元素集合是有序的
     *
     * @param content
     * @param p
     * @param mid
     * @param r
     */
    public static void merge(int[] content, int p, int mid, int r) {
        // 因为归并排序合并时，是两个元素集合进行合并，所以需要两个指针下标
        // p2指针为第二个元素的下标，所以是mid+1
        // 例如元素集合（11 8），那么第一个元素集合下标就是0，第二个就是1，以此类推
        int p1 = p, p2 = mid + 1;
        // 申请一个临时数组，用于暂存有序集合
        int[] temp = new int[r - p + 1];
        int i = 0;
        while (p1 <= mid && p2 <= r) {
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

        while (p2 <= r) {
            temp[i++] = content[p2++];
        }

        // 将有序部分进行替换
        for (int j = p; j <= r; j++) {
            content[j] = temp[j - p];
        }
    }

    /**
     * 带哨兵实现的合并
     * @param content
     * @param p
     * @param mid
     * @param r
     */
    public static void mergeWithSentinel(int[] content, int p, int mid, int r) {
        // 因为归并排序合并时，是两个元素集合进行合并，所以需要两个指针下标
        // p2指针为第二个元素的下标，所以是mid+1
        // 例如元素集合（11 8），那么第一个元素集合下标就是0，第二个就是1，以此类推
        int p1 = p, p2 = mid + 1;
        // 申请一个临时数组，用于暂存有序集合
        int[] temp = new int[r - p + 1];
        int i = 0;
        while (p1 <= mid && p2 <= r) {
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

        while (p2 <= r) {
            temp[i++] = content[p2++];
        }

        // 将有序部分进行替换
        for (int j = p; j <= r; j++) {
            content[j] = temp[j - p];
        }
    }

}