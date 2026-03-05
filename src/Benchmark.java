import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Benchmark {

    public static int[] loadDataset(String filename, int size) {
        int[] arr = new int[size];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < size) {
                arr[index++] = Integer.parseInt(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static void main(String[] args) {

        int size = 10_000_000;
        String datasetPath = "data/dataset_10m.txt";

        System.out.println("Loading dataset...");

        int[] arr = loadDataset(datasetPath, size);

        System.out.println("Finding max value...");
        int max = CountingSort.findMaxValue(arr);

        System.out.println("Starting sort...");

        long startTime = System.nanoTime();

        int[] sorted = CountingSort.sort(arr, max);

        long endTime = System.nanoTime();

        double timeSeconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Sorting completed.");
        System.out.println("Sorted correctly: " + isSorted(sorted));
        System.out.println("Execution time: " + timeSeconds + " seconds");
    }

    // Helper method that checks if an arr is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}