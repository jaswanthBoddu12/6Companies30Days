// Link : https://leetcode.com/problems/query-kth-smallest-trimmed-number/

class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        vector<int> res;
        for (const auto& query : queries) {
            priority_queue<pair<string, int>> pq;
            for (int i = 0; i < nums.size(); ++i) {
                int trimLength = nums[i].length() - query[1];
                string trimmedString = nums[i].substr(trimLength, query[1]);
                if (pq.size() < query[0]) {
                    pq.push({trimmedString, i});
                } else {
                    if (pq.top().first > trimmedString) {
                        pq.pop();
                        pq.push({trimmedString, i});
                    }
                }
            }
            int selectedIdx = pq.top().second;
            res.push_back(selectedIdx);
        }
        return res;
    }
};
