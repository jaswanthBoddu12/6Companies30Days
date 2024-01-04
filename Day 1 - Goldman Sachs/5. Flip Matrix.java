// Link: https://leetcode.com/problems/random-flip-matrix/

class Solution {
    private int rows, cols, total;
    private Map<Integer, Integer> hm;
    private Random random;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
        hm = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        int r = random.nextInt(total--);
        int temp = hm.getOrDefault(r, r);

        // Update the mapping for the next random pick
        hm.put(r, hm.getOrDefault(total, total));
        
        int row = temp / cols;
        int col = temp % cols;

        return new int[]{row, col};
    }

    public void reset() {
        hm.clear();
        total = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
