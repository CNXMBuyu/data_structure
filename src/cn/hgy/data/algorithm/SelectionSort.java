package cn.hgy.data.algorithm;

/**
 * 选择排序
 * <pre>
 *     算法介绍：每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 *     时间复杂度：最优O(n)，最坏O(n^2)
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arrays = {4, 5, 6, 3, 2, 1};
        int[] sortArrays = sort(arrays);

        for (int i = 0; i < sortArrays.length; i++) {
            System.out.print(sortArrays[i] + " ");
        }
    }

    /**
     * 排序
     *
     * @param content
     */
    public static int[] sort(int[] content) {
        for (int i = 0; i < content.length; i++) {
            int min = content[i];
            int index = i;
            // 每次从未排序中找出最小的值，将其插入已排序数组的尾部
            for (int j = i; j < content.length; j++) {
                if (content[j] < min) {
                    index = j;
                    min = content[j];
                }
            }
            content[index] = content[i];
            content[i] = min;
        }
        return content;
    }
}
