// Link : https://leetcode.com/problems/k-divisible-elements-subarrays/description/

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> hs = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            int count = 0; // Count of nums divisible by p

            for (int j = i; j < n; ++j) {
                if (nums[j] % p == 0) {
                    ++count;
                }

                if (count > k) {
                    break;
                }

                if (count <= k) { // Only add the subarray if count is less than or equal to k
                    StringBuilder subarr = new StringBuilder(); // Unique subarrays

                    for (int m = i; m <= j; ++m) {
                        subarr.append(nums[m]);
                        if (m < j) {
                            subarr.append(",");
                        }
                    }

                    hs.add(subarr.toString());
                }
            }
        }

        return hs.size();
    }
}
