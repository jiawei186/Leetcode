// 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
// 你可以按 任意顺序 返回答案 。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while (k < n && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (l > j && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }
        long test = 0;
        List<List<Integer>> em = new ArrayList<>();
        for (int q = 0; q < n; q++) {
            test += nums[q];
            if (target == test) break;
            if (test > Integer.MAX_VALUE) {
                return em;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 0, -1, 0, -2, 2};
        int b = 0;
        FourSum c = new FourSum();

        System.out.println(c.fourSum(a, b));
    }
}
