class Solution {

    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {

        if (dp[i][j] != null)
            return dp[i][j];

        if (i == s.length() && j == p.length())
            return dp[i][j] = true;

        if (j == p.length())
            return dp[i][j] = false;

        if (i == s.length()) {
            int k = j;
            while (k < p.length()) {
                if (p.charAt(k) != '*')
                    return dp[i][j] = false;
                k++;
            }
            return dp[i][j] = true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = dfs(i + 1, j + 1, s, p);

        if (p.charAt(j) == '*')
            return dp[i][j] = dfs(i, j + 1, s, p) || dfs(i + 1, j, s, p);

        return dp[i][j] = false;
    }
}