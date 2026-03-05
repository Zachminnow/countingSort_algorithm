import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataGenerator {

    public static int[] generateArray(int size, int maxValue) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxValue + 1);
        }

        return arr;
    }

    public static void saveToFile(int[] arr, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int num : arr) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }

            System.out.println("Dataset saved to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int size = 10_000_000;   // 10 million numbers
        int maxValue = 1000;     // Range of numbers (k)

        System.out.println("Generating dataset...");

        int[] dataset = generateArray(size, maxValue);

        System.out.println("Saving dataset...");

        saveToFile(dataset, "data/dataset_10m.txt");

        System.out.println("Done.");
    }
}