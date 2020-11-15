package kt.sort;

import java.util.Arrays;

/**
 * @Author petterp
 * @Date 2020/11/12-4:30 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 快速排序
 * <p>
 * 主要难点在于理解 pro 方法。
 * 解释：
 * <p>
 * 快速排序的准则是，每次先定一个 [基准数] 和两个指针，left和right.
 * 这个基准数的作用是，每次都先移动right指针，向左移动，即right--
 * 将小于基准数的移到最左边，然后更换相应的数组位置，开始left指针移动，否则继续移动，直至right==left就停止。
 * 移动之后就更换left开始向右移动，即left++,大于基准数的移动最右边，效果同理。
 * 经过上述的一个过程，我们可以得到一个当前的基准数left,也就是移动导致 right==left时的位置。
 */
public  class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = pro(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int pro(int[] arr, int left, int right) {
        //基准数
        int temp = arr[left];
        while (left < right) {
            //如果小于基准数，则退出while,移动位置，否则继续遍历直至left=right
            while (left < right && arr[right] >= temp) {
                --right;
            }
            //此时小于基准数，将数字移动到最左边
            arr[left] = arr[right];

            //如果大于基准数，则退出while,移动位置，否则继续遍历至left=right
            while (left < right && arr[left] <= temp) {
                ++left;
            }
            //此时如果大于基准数，将数字移到最右边
            arr[right] = arr[left];

            // TODO: 2020/11/12 left==right 代表两个指针指的同一个位置，也代表
        }
        //扫描完成，还原基准数
        arr[left] = temp;
        return left;
    }
}
