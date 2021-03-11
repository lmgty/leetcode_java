package newcoder.jobcode;

import java.util.Arrays;

/**
 * @author LiuYe
 * @data 2021/3/11
 */
public class NC140 {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        MySort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] MySort(int[] arr) {
        // write code here
        int length = arr.length;
        quickSort(arr, 0, length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, start, right);
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);

    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


}
