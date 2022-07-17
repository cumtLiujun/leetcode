package Offer.Offer_11;

public class Solution {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        quickSort(numbers, 0, len - 1);
        return numbers[0];
    }

    private static void quickSort(int[] number, int l, int r) {
       if (l < r) {
           int i = l, j = r, temp = number[l];
           while (i < j) {
               while (i < j && number[j] > temp) {
                   j--;
               }
               if (i < j) {
                   number[i++] = number[j];
               }
               while (i < j && number[i] < temp) {
                   i++;
               }
               if (i < j) {
                   number[j--] = number[i];
               }
           }
           number[i] = temp;
           quickSort(number, l, i - 1);
           quickSort(number, i + 1, r);
       }
    }

    public static void main(String[] args) {

    }
}
