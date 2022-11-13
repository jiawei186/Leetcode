// 给你一个字符串 s，找到 s 中最长的回文子串。

public class LongestPalindrome {

    private String s;
    private int n;

    public String longestPalindrome(String s) {

        this.s = s;
        n = s.length();
        int start = 0, max = 1;
        for (int i = 0; i < n; ++i) {
            
            int a = dif(i, i);
            int b = dif(i, i + 1);
            int c = Math.max(a, b);
            if (max < c) {
                
                max = c;
                start = i - ((c - 1) >> 1); // /2
            }
        }
        return s.substring(start, start + max);
    }

    private int dif(int l, int r) { // Stop when finded the different element

        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            
            --l;
            ++r;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {

        String a = "abacd";
        LongestPalindrome b = new LongestPalindrome();

        System.out.println(b.longestPalindrome(a));
    }
}
