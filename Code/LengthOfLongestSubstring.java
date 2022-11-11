// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> cup = new HashSet<>();
        int start = 0, length = 0;
        for (int end = start; end < s.length(); end++) {
            char c = s.charAt(end);
            while (cup.contains(s.charAt(end))) {
                cup.remove(s.charAt(start)); // 如果有重复字符则去除
                start++;
            }
            cup.add(c);
            length = Math.max(length, end - start + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcde"));
    }
}