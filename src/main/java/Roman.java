public class Roman {

    public String intToRoman(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder res = new StringBuilder();
        res.append(thousands[num / 1000]);
        res.append(hundreds[num % 1000 / 100]);
        res.append(tens[num %100 /10]);
        res.append(ones[num % 10]);
        return res.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        Roman roman = new Roman();
        System.out.println(roman.intToRoman(num));
    }

}
