class Solution {

    int[] dp;

    public int minJumps(int[] nums, int position) {

        if (position >= nums.length - 1)
            return 0;

        if (nums[position] == 0)
            return Integer.MAX_VALUE;

        if (dp[position] != -1)
            return dp[position];

        int minStep = Integer.MAX_VALUE;

        for (int jump = 1; jump <= nums[position]; jump++) {

            int subResult = minJumps(nums, position + jump);

            if (subResult != Integer.MAX_VALUE) {
                minStep = Math.min(minStep, 1 + subResult);
            }
        }

        dp[position] = minStep;
        return dp[position];
    }

    public int jump(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return minJumps(nums, 0);
    }
}