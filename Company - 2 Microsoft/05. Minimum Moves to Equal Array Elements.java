// Link : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

class Solution {
    public int minMoves2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Calculate the median
        int median = nums[nums.length / 2];

        // Calculate the minimum moves
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
      
        return moves;
    }
}
