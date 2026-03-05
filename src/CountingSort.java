public class CountingSort {

    public static int[] sort(int[] arr, int maxValue) {
        int n = arr.length;

        // Count array
        int[] count = new int[maxValue + 1];

        // Output array
        int[] output = new int[n];

        // Step 1: Count occurrences
        for (int j : arr) {
            count[j]++;
        }

        // Step 2: Cumulative sum
        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i -1];
        }

        //Step 3: Build output array (stable)
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }

    // A helper method that gets max value in a given array
    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}