// Link : https://leetcode.com/problems/combination-sum-iii/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(result, curr, k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int k, int remaining, int start) {
        if (k == 0 && remaining == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remaining)
                break;
                
            curr.add(i);
            backtrack(result, curr, k - 1, remaining - i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
