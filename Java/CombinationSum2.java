// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的每个数字在每个组合中只能使用 一次 。

// 注意：解集不能包含重复的组合。 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s > target) {
            return;
        }
        if (s == target) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = i; j < candidates.length; ++j) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            t.add(candidates[j]);
            dfs(j + 1, s + candidates[j]);
            t.remove(t.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {10, 1, 2, 7, 6, 1, 5};
        int b = 8;

        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> d = new ArrayList<>();
        d = c.combinationSum2(a, b);

        for (int i = 0; i < d.size(); i++) {
            System.out.println(d.get(i));
        }
    }
}
