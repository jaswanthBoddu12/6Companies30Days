// Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> hm = new HashMap<>(); // Digits To Letters Map
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        backtrack(result, digits, 0, new StringBuilder(), hm);
        return result;
    }

    private void backtrack(List<String> result, String digits, int id, StringBuilder curr, Map<Character, String> hm) {
        if (id == digits.length()) {
            result.add(curr.toString());
            return;
        }

        char digit = digits.charAt(id);
        String letters = hm.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));
            backtrack(result, digits, id + 1, curr, hm);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
