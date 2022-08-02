package arraySort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr) {
        int i, j,k;
        int len = arr.length;
        for (i = 1; i < len; i++) {

//            为arr[i]在[0，i-1]中找到一个合适位置
            for (j = i-1; j>=0; j--) {
                if(arr[j] < arr[i])
                    break;
            }
//            找到一个合适位置，将该位置之后的位置后移；
            if (j != i -1) {
//                将比arr[i]大的数字后移
                int temp = arr[i];
                for (k = i-1; k > j; k--) {
                    arr[k+1] = arr[k];
                }
                arr[k+1] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
