package arraySort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        if (l>=r) return;
        int i = l, j = r;
        int temp = arr[i];

        while (i < j) {
            while(i < j && arr[j] > temp) j--;
            arr[i] = arr[j];
            while(i < j && arr[i] < temp) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }

    public static void main(String[] args) {
        int[] arr = {12, 78, 234, 23, 43, 2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
