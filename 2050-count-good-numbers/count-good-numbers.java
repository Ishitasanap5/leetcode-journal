class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        
        long even = (n + 1) / 2;
        long odd = n / 2;

        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0)
        return 1;

        long half = power(base, exp / 2);

        long result = (half * half) % MOD;

        if (exp % 2 == 1)
            result = (result * base) % MOD;

        return result;
     
    }
}