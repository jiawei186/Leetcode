// 编写一个函数来查找字符串数组中的最长公共前缀。

// 如果不存在公共前缀，返回空字符串 ""。

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < n; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    // 超过后者元素长度时, 或遇到不相等的字符时, 就返回
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] a = new String[] {"flower", "flow", "flight"};
        LongestCommonPrefix b = new LongestCommonPrefix();

        System.out.println(b.longestCommonPrefix(a));
    }
}
