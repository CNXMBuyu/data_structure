package cn.hgy.data.algorithm.lesson1;

/**
 * 插入排序
 * <pre>
 *     算法介绍：每次从未排序中选择第一个数添加到已排序的合适位置
 *     时间复杂度：最优O(n)，最坏O(n^2)
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arrays = {4, 5, 6, 3, 2, 1};
        int[] sortArrays = sort(arrays);

        for (int i = 0; i < sortArrays.length; i++) {
            System.out.print(sortArrays[i] + " ");
        }
    }

    /**
     * 排序
     * <pre>
     *     优化点：
     *     1. 如果待排序的元素大于有序区的最大元素则直接在尾部插入
     *     2. 等已排序区间的元素都移动好位置，再将元素插入指定位置，减少赋值操作
     * </pre>
     *
     * @param content
     */
    public static int[] sort(int[] content) {
        for (int i = 0; i < content.length; i++) {
            int temp = content[i];
            // 优化点2：记录待插入的位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (content[j] > temp) {
                    content[j + 1] = content[j];
                } else {
                    // 优化点1：如果待排序的元素大于有序区的最大元素则直接在尾部插入
                    break;
                }
            }
            // 优化点2：将元素插入指定位置，减少赋值操作
            content[j + 1] = temp;
        }
        return content;
    }

}

