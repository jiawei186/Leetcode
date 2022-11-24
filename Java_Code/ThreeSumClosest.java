// 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

// 返回这三个数的和。

// 假定每组输入只存在恰好一个解。

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            int t = twoSumClosest(nums, i + 1, n - 1, target - nums[i]);
            if (Math.abs(nums[i] + t - target) < diff) {
                res = nums[i] + t;
                diff = Math.abs(nums[i] + t - target);
            }
        }
        return res;
    }

    private int twoSumClosest(int[] nums, int start, int end, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        while (start < end) {
            int val = nums[start] + nums[end];
            if (val == target) {
                return val;
            }
            if (Math.abs(val - target) < diff) {
                res = val;
                diff = Math.abs(val - target);
            }
            if (val < target) {
                ++start;
            } else {
                --end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {-1, 2, 1, -4};
        int b = 1;
        ThreeSumClosest c = new ThreeSumClosest();

        System.out.println(c.threeSumClosest(a, b));
    }
}
