// Link : https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum;

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if (left[3] == 1 && right[3] == 1 && left[1] < node.val && node.val < right[0]) {
            int currSum = left[2] + right[2] + node.val;
            int currMin = Math.min(left[0], node.val);
            int currMax = Math.max(right[1], node.val);
            maxSum = Math.max(maxSum, currSum);
            return new int[]{currMin, currMax, currSum, 1};
        }

        return new int[]{0, 0, Math.max(left[2], right[2]), 0};
    }
}
