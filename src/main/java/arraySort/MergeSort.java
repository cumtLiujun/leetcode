package arraySort;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start +1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i<=mid&&j<=end){
            if (arr[i]<arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i<=mid) {
            tmp[k++] =arr[i++];
        }
        while (j<=end) {
            tmp[k++] = arr[j++];
        }

        for (i = 0; i < k; i++)
            arr[start + i] = tmp[i];

        tmp = null;

    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {123,2,4,5,723,23,45};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
