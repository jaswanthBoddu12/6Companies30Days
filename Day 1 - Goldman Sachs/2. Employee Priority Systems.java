// Link : https://leetcode.com/problems/high-access-employees/
// Language : Java

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> hm = new HashMap<>(); // Access times map

        // Group access times by employee
        for (List<String> entry : access_times) {
            String name = entry.get(0);
            int time = convertToMinutes(entry.get(1)); // Convert to minutes
            hm.computeIfAbsent(name, k -> new ArrayList<>()).add(time);
        }

        // Identify high-access employees
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times); 

            // Check for 3 accesses within 59 minutes
            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) <= 59) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }

        return result;
    }

    private int convertToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(2));
        return hours * 60 + minutes;
    }
}
