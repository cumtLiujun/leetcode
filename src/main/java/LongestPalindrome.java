public class LongestPalindrome {

    /**
     * 暴力解法
     * isPalindrome 判断是否字符串是否是回文串，使用charArray 避免多次使用substring()造成的时间复杂度和空间复杂度浪费
     *  longestPalindrome  使用双重循环 记录最长字串的位置
     *
     *
     *
     */
    public Boolean isPalindrome(char[] charArray, int left , int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        char[] charArray = s.toCharArray();
        int max = 1, begin = 0;
        for (int i = 0; i < len -1; i++) {
            for (int j = i + 1; j < len; j++){
                if (isPalindrome(charArray, i, j) && j - i + 1 > max){
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    /**
     * 中心扩展法
     *
     */


    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0, end = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++){
            int len1 = expandAroundCenter(charArray, i, i);
            int len2 = expandAroundCenter(charArray, i, i + 1);
            int lenP = Math.max(len1, len2);
            if (lenP > end - begin){
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(begin, end + 1);
    }

    public int expandAroundCenter(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]){
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * 状态转移方程  dp[i][j] =  (s[i] == s[j]) ^ dp[i+1][j-1]  边界条件 （j-1) - (i+1) +1 < 2  子串长度小于2时一定为true
     *
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, begin = 0;
        Boolean[][] bp  = new Boolean[len][len];
        for(int i = 0;i < len; i++){
            bp[i][i] = true;
        }

        char [] charArray = s.toCharArray();
        //开始枚举字串长度
        for (int L = 2; L<=len; L++){
            //枚举左边界
            for (int i = 0;i<len;i++){
                // 根据左边界枚举有边界 关系为j-i+1 = L
                int j = L + i - 1;

                // 越界 退出
                if (j >= len ) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    bp[i][j] =false;
                } else {
                    if (j - i < 3){
                        bp[i][j] = true;
                    } else {
                       bp[i][j] = bp[i+1][j-1];
                    }
                }

                if (bp[i][j] && j -i + 1 > maxLen) {
                    maxLen = j -i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);

    }
    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        int end  = charArray.length -1, begin = 0;
        while (begin < end ){
            if (charArray[begin] != charArray[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;

    }


    public static void main(String[] args) {
//        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        String test = "ac";
//
        int test = -123;
        System.out.println(String.valueOf(test));
    }

}
