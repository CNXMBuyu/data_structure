package cn.hgy.data.algorithm;

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
     *
     * @param content
     */
    public static int[] sort(int[] content) {
        for (int i = 0; i < content.length; i++) {
            int temp = content[i];
            // 在有序的数组中找到合适的位置，将其插入
            for (int j = i - 1; j >= 0; j--) {
                if (content[j] > temp) {
                    content[j + 1] = content[j];
                    content[j] = temp;
                }
            }
        }
        return content;
    }

}

