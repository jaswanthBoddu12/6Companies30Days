// Link : https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/description/

class Solution {
    private Integer[][] visited;  // Memory for storing computed results
    private final int MOD = 1_000_000_007;

    // Main function to calculate the number of ways
    public int numberOfWays(int startPos, int endPos, int k) {
        visited = new Integer[k + 1][k + 1];  // Initialize memory

        // Call the recursive function and return the result
        return calWays(Math.abs(startPos - endPos), k);
    }

    // Recursive function to compute the number of ways
    private int calWays(int remDist, int remSteps) {
        // Base cases
        if (remDist > remSteps || remSteps < 0) {
            return 0;
        }

        if (remSteps == 0) {
            return remDist == 0 ? 1 : 0;
        } 
            
        // Check if the result is already computed
        if (visited[remDist][remSteps] != null) {
            return visited[remDist][remSteps];
        }

        // Calculate the number of ways using recursive calls
        int ways = calWays(remDist + 1, remSteps - 1)
                + calWays(Math.abs(remDist - 1), remSteps - 1);
        ways %= MOD;

        // Memoize the result and return
        return visited[remDist][remSteps] = ways;
    }
}
