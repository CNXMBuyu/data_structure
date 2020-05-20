package cn.hgy.data.algorithm.lesson1;

/**
 * 冒泡排序
 * <pre>
 *     算法介绍：遍历待排序的数，每次选出最大的数添加到合适的位置
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
     * <pre>
     *     两个优化点：
     *     1. 如果进行一轮的比较遍历后，没有发生过替换操作，则表示当前已是有序状态
     *     2. 每进行一轮比较遍历后，在进行第i轮之后，数组尾部的n-i到n的数是有序的，无需再判断
     * </pre>
     *
     * @param content
     */
    public static int[] sort(int[] content) {

        for (int i = 0; i < content.length; i++) {
            // 优化点1：有序性标识符
            boolean ordinalFlag = true;

            // 优化点2：在进行i轮之后，数组尾部的n-i到n的数是有序的
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j] > content[j + 1]) {
                    ordinalFlag = false;
                    int temp = content[j + 1];
                    content[j + 1] = content[j];
                    content[j] = temp;
                }
            }

            // 优化点1：进行一轮的比较遍历后，没有发生过替换操作，则表示当前已是有序状态
            if (ordinalFlag) {
                break;
            }
        }
        return content;
    }

}
