package Offer.Offer_38;

/*
https://mp.weixin.qq.com/s/nMUHqvwzG2LmWA9jMIHwQQ
 */
import java.util.HashSet;
import java.util.LinkedList;

public class Solution_I {
    LinkedList<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        backtrack(0);
        return res.toArray(new String[0]);
    }
    private void backtrack(int index) {
        if (index == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = index; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, index);
            backtrack(index+1);
            swap(i, index);
        }
    }

    private void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
