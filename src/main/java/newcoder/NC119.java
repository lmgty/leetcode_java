package newcoder;

import java.util.ArrayList;

/**
 * @author LiuYe
 * @date 2021/3/14 5:34 下午
 */
public class NC119 {
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 5;
        System.out.println(GetLeastNumbers_Solution(a, k));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = input.length;
        if (k > length) {
            return arrayList;
        }
        int j = partition(input, 0, length - 1, k);
        for (int i = 0; i < j; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    private static int partition(int[] a, int low, int high, int k) {
        int i = low;
        int j = high;
        int pivot = a[low];

        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            while (i < j && a[i] <= pivot) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, low, i);


        if (k == i) {
            return i;
        } else if (k < i) {
            return partition(a, low, i - 1, k);
        } else {
            return partition(a, i + 1, high, k);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
