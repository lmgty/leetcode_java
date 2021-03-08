package model;

import java.util.Arrays;

/**
 * @author LiuYe
 * @date 2021/3/8 12:05 下午
 */
public class QS {
    public static void qc(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int left = L;
        int right = R;
        int pivot = array[left];
        while (left< right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
            if (left >= right) {
                array[left] = pivot;
            }
        }
        qc(array,L, right - 1);
        qc(array, right + 1, R);
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 7, 6, 2, 9, 3, 10};
        qc(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}