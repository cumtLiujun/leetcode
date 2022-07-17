import java.util.*;
/*
看下回溯是怎么回溯的
 */
public class letterCombinations_17 {

//   存放结果
    private List<String> res = new ArrayList<>();
//    电话table
    private Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
//    存放路径
    private StringBuilder stringBuilder = new StringBuilder();
    public List<String> letterCombinations(String digits) {
//        初始化参数
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0);
        return res;

    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        String phone = phoneMap.get(digits.charAt(index));
        for (char ch: phone.toCharArray()) {
            stringBuilder.append(ch);
            backtrack(digits, index+1);
//            清空内容，回溯一位删除一位
            stringBuilder.deleteCharAt(index);
        }
    }


    public static void main(String[] args) {
        letterCombinations_17 letterCombinations17 = new letterCombinations_17();
        String digits = "23";
        System.out.println(letterCombinations17.letterCombinations(digits));

    }

}
