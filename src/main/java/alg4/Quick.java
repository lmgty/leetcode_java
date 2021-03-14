package alg4;

/**
 * @author LiuYe
 * @date 2021/3/14 5:16 下午
 */
public class Quick {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = a[low];
        while (true) {
            while (a[++i] < pivot) {
                if (i == high) {
                    break;
                }
            }
            while (a[--j] > pivot) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
