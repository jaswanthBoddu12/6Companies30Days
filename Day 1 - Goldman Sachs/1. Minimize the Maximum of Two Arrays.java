// Link : https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/

class Solution {

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        // Calculate lcm of the divisors
        long divisor = lcm(divisor1, divisor2);
        
        // Set up binary search range
        long left = 1, right = 10000000000L;

        // Binary search loop
        while (left < right) {
            long mid = (left + right) >> 1; // midpoint

            // Calculate counts of numbers not divisible by each divisor up to mid
            long count1 = mid / divisor1 * (divisor1 - 1) + mid % divisor1;
            long count2 = mid / divisor2 * (divisor2 - 1) + mid % divisor2;
            long count = mid / divisor * (divisor - 1) + mid % divisor;

            // Check if counts satisfy the conditions
            if (count1 >= uniqueCnt1 && count2 >= uniqueCnt2 && count >= uniqueCnt1 + uniqueCnt2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Return the minimum possible maximum integer
        return (int) left;
    }

    // Function to calculate the lcm of two numbers
    private long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    // Function to calculate the gcd of two numbers
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
