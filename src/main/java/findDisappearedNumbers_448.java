import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] index = new int[nums.length + 1];
        for (int num : nums) {
            index[num] = 1;
        }
        for (int i = 1; i < index.length; i++) {
            if (index[i] != 1) res.add(i);
        }
        return res;
    }
}
