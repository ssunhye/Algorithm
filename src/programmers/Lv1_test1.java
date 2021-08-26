package programmers;

public class Lv1_test1 {
    public static void main(String[] args) {
        String s = "abcde";
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        if (len%2==0) {
            sb.append(s.charAt(len/2-1)).append(s.charAt(len/2));
        } else {
            sb.append(s.charAt(len/2));
        }
        System.out.println(sb.toString());
    }
}
