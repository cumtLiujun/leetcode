import java.util.HashMap;

public class String_type {
    public int lengthOfLongestSubstring(String s) {
//        异常值处理
        if (s.isEmpty()) return 0;
//        数据初始化
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;

        for (int i = 0;i < s.length();i++) {
            if (map.containsKey(s.charAt(i))){
//                找到更新后left位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String_type stringType = new String_type();
        System.out.println(stringType.lengthOfLongestSubstring(s));

    }
}
