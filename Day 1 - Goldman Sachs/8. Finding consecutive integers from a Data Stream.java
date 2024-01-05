// Link : https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/

class DataStream {
    private int count;
    private int val;
    private int reqCount;

    public DataStream(int value, int k) {
        val = value;
        reqCount = k;
    }

    public boolean consec(int num) {
        if (num == val) {
            count++;
        } else {
            // Reset the count if the current number is not equal to the val value
            count = 0;
        }

        // Check if the required consecutive count is reached
        return count >= reqCount;
    }
}
