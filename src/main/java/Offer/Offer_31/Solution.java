package Offer.Offer_31;

import java.util.ArrayList;

public class Solution {

//    不需要过多考虑，只需要考虑什么时候出栈就可以
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) {
            return true;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        int popIndex = 0;
        while (index < len && popIndex < len) {
            res.add(pushed[index]);
            index++;

            while(res.size() != 0 && res.get(res.size() - 1) == popped[popIndex]) {
                res.remove(res.size() - 1);
                popIndex++;
            }
        }
        return popIndex == len;
    }

    public static void main(String[] args) {
        int [] pop = {2,1,0};
        int [] push = {1,2,0};
        System.out.println(validateStackSequences(pop,push));

    }
}
