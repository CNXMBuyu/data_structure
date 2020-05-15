package cn.hgy.data.algorithm;

/**
 * 冒泡排序
 * <pre>
 *     算法介绍：一次冒泡会让至少一个元素移动到它应该在的位置
 *     时间复杂度：最优-O(n)，最坏-O(n^2),
 * </pre>
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class BubbleSort {

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
        // 替换标识，判断是否为最好情况
        boolean swapFlag = false;
        for (int i = 0; i < content.length; i++) {
            // 每一轮排序，数组尾部都是合适的值
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j] > content[j + 1]) {
                    swapFlag = true;
                    int temp = content[j + 1];
                    content[j + 1] = content[j];
                    content[j] = temp;
                }
            }

            if (swapFlag) {
                swapFlag = false;
            } else {
                break;
            }
        }
        return content;
    }

}
