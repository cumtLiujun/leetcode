import java.util.ArrayList;
import java.util.List;

public class generateParenthesis_22 {
    //    从 n 到 0 计数，满足条件开始回溯
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtraceParenthesis(res, new StringBuilder(), n, n);
        return res;

    }

    private void backtraceParenthesis(List<String> res, StringBuilder stringBuilder, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(stringBuilder.toString());
            return;
        }
        if (left == right) {
            stringBuilder.append("(");
            backtraceParenthesis(res, stringBuilder, left - 1, right);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                stringBuilder.append("(");
                backtraceParenthesis(res, stringBuilder, left - 1, right);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")");
            backtraceParenthesis(res, stringBuilder, left, right - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    //    从0 到 n 计数，满足条件回溯
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtraceParenthesis1(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtraceParenthesis1(List<String> res, StringBuilder stringBuilder, int left, int right, int max) {
        if (stringBuilder.length() == 2 * max) {
            res.add(stringBuilder.toString());
            return;
        }
        if (left < max) {
            stringBuilder.append("(");
            backtraceParenthesis1(res, stringBuilder, left + 1, right, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right < left) {
            stringBuilder.append(")");
            backtraceParenthesis1(res, stringBuilder, left, right + 1, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


}
