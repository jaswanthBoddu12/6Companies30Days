// Link : https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] > 0) {
                arr[index] = -arr[index]; // Mark the element as visited
            } 
            else {
                result[0] = index + 1; // Element repeated twice
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1; // Missing element
                break;
            }
        }

        return result;
    }
}
