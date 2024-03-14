package dp;

public class Main {

    //爬楼梯 70
    public int climbStairs(int n) {
        if(n<=2)
            return n;

        int dp[] = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return dp[2];

    }
}
