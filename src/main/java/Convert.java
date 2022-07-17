import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {

    /**
     * 以从上往下、从左到右进行 Z 字形排列
     * 暴力解法
     *   主要是更新flag
     * 二维数组直接填充后遍历
     * <p>
     * P I N
     * ALSIG
     * YAHR
     * P I
     */
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        char[][] charArray = new char[numRows][len];

        int i = 0, j = 0;
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (flag) {
                charArray[i][j] = c;
                i++;
                if (i == numRows) {
                    i--;
                    flag = false;
                }
            } else {
                i--;
                j++;
                charArray[i][j] = c;
                if (i == 0) {
                    flag = true;
                    i++;
                }
            }

        }
//
        for (int m = 0; m < numRows; m++) {
            for (int n = 0; n < len; n++) {
                if (charArray[m][n] != '\0') {
                    res.append(charArray[m][n]);
                }
            }
        }
        return res.toString();
    }


    /*
    大佬解法，主要是需要妙用flag,来进行方向的改变  由s1->sn至sn->s1;
     */

    public String convert1(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i<numRows; i++){
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1) flag = -flag; //转折点控制方向
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row :rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Convert convert = new Convert();
        System.out.println(convert.convert(s,3));

    }

}
