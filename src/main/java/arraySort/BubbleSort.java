package arraySort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean flag ;

        for (int i = len - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j< i;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
