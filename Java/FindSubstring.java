// 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。

//  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。

// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
// 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }
        int subLen = words[0].length();
        int n = s.length(), m = words.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < subLen; ++i) {
            Map<String, Integer> cnt1 = new HashMap<>();
            int l = i, r = i;
            int t = 0;
            while (r + subLen <= n) {
                String w = s.substring(r, r + subLen);
                r += subLen;
                if (!cnt.containsKey(w)) {
                    l = r;
                    cnt1.clear();
                    t = 0;
                    continue;
                }
                cnt1.put(w, cnt1.getOrDefault(w, 0) + 1);
                ++t;
                while (cnt1.get(w) > cnt.get(w)) {
                    String remove = s.substring(l, l + subLen);
                    l += subLen;
                    cnt1.put(remove, cnt1.get(remove) - 1);
                    --t;
                }
                if (m == t) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "rtabcdefabcpp";
        String[] b = new String[] {"abc", "def"};
        FindSubstring c = new FindSubstring();

        System.out.println(c.findSubstring(a, b));
    }
}
