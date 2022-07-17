public class Atio {

    /**
     * 直观解法
     *  取值 判断 判断大小
     *
     */
    public int myAtoi(String s) {
        String str = s.trim();
        boolean flag = false;
        long res = 0;
        char[] charArray;
        if (str.length() == 0) return 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            charArray = str.substring(1).toCharArray();
            if (str.charAt(0) == '-') flag = true;
        } else {
            charArray = str.toCharArray();
        }

         for (int i = 0; i < charArray.length; i++) {
             if ( charArray[i] >= '0' && charArray[i] <= '9') {
                 if (flag) {
                     res = res * 10 - (Integer.parseInt(String.valueOf(charArray[i])));
                 } else {
                     res = res * 10 + (Integer.parseInt(String.valueOf(charArray[i])));
                 }
                 if (res >= Integer.MAX_VALUE) {
                     return 2147483647;
                 } else if (res <= Integer.MIN_VALUE) {
                     return -2147483648;
                 }
             } else {
                 break;
             }
         }
         return (int) res;
    }

    public static void main(String[] args) {

        String s = "words and 987";
        Atio atio = new Atio();
        System.out.println(atio.myAtoi(s));

    }
}
