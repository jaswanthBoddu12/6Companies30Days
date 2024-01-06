// Link : https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1

class Solution {
    public String printMinNumberForPattern(String S) {
        int n = S.length();
        int curr = 0, last = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            if (i == n || S.charAt(i) == 'I') {
                // If the current character is 'I' or it's the end of the pattern
                // Append the increasing sequence of numbers
                
                for (int j = curr; j >= last; j--) {
                    result.append(j + 1);
                }
                last = curr + 1;
            }
            curr++;
        }

        return result.toString();
    }
}
