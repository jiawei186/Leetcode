// 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

// P   A   H   N
// A P L S I I G
// Y   I   R
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

// 请你实现这个将字符串进行指定行数变换的函数：
// string convert(string s, int numRows);

public class ZConvertion {
    
    public String zConvertion(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int group = 2 * numRows - 2;

        for (int i = 1; i <= numRows; i++) {
            int interval = (i == numRows ? group : 2 * numRows - 2 * i); // 行数与间隔之间的关系
            int idx = i - 1;
            while (idx < s.length()) {
                result.append(s.charAt(idx));
                idx += interval;
                interval = group - interval; // 当行数和行序数满足一定条件时, interval并非固定不变
                if (interval == 0) {
                    interval = group;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String a = "abcdefg";
        ZConvertion b = new ZConvertion();

        System.out.println(b.zConvertion(a, 3));
    }
}
