// Link : https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int N = nums.length, left = 0;

        // Find the leftmost increasing subsequence
        while (left + 1 < N && nums[left] < nums[left + 1]) {
            left++;
        }

        // If the entire array is increasing, return the total count
        if (left >= N - 1) {
            return N * (N + 1) / 2;
        }

        int right = N - 1;

        // Find the rightmost increasing subsequence
        while (right >= 1 && nums[right] > nums[right - 1]) {
            right--;
        }

        int ans = N - right;

        // Calculate the count of incremovable subarrays
        for (int i = 0; i <= left; i++) {
            while (right < N && nums[right] <= nums[i]) {
                right++;
            }
            ans += N - right + 1;
        }

        return ++ans;
    }
}
