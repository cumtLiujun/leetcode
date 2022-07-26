package Offer.Offer_44;

public class Solution {
//    规律题目，看规律求结果
    public int findNthDigit(int n) {
//        位数
        int digit = 1;
//        当前位数下数据
        long count = 9;
//       当下位数下起始数字
        long start = 1;

        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
//        从数字 start 开始的第 [(n - 1) / digit][(n−1)/digit] 个 数字 中（ starts 为第 0 个数字）
        long num = start + (n - 1) / digit;
//        所求数位为数字 num 的第 (n - 1) % digit(n−1)%digit 位（ 数字的首个数位为第 0 位)
        return Long.toString(num).charAt(( (n -1) % digit)) - '0';
    }
}
