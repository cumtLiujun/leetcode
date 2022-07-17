public class ReverseLeftWords_58 {
    public String reverseLeftWords(String s, int n) {
        return  s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        ReverseLeftWords_58 reverseLeftWords58 = new ReverseLeftWords_58();
        String str = "lrloseumgh";
        int k = 6;
        System.out.println(reverseLeftWords58.reverseLeftWords(str, k));

    }
}
