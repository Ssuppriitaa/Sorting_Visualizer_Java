package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);

        System.out.println("Sorting Algorithm Visualizer and Comparator");
        System.out.println("Array size must be between 1 and 100 (inclusive).");
        System.out.println("Visualization delay must be between 0 and 5000 ms (inclusive).");

        // Main option: Visualize or Compare
        System.out.println("Choose an option:");
        System.out.println("1. Visualize a sorting algorithm (step-by-step)");
        System.out.println("2. Compare all sorting algorithms");
        System.out.print("Enter choice (1 or 2): ");
        var mainChoice = scanner.nextInt();

        // Array input option
        System.out.println("How do you want to provide the array?");
        System.out.println("1. Generate randomly");
        System.out.println("2. Input manually");
        System.out.print("Enter choice (1 or 2): ");
        var inputChoice = scanner.nextInt();

        int[] array;
        if (inputChoice == 1) {
            System.out.print("Enter array size: ");
            var size = scanner.nextInt();
            if (size < 1 || size > 100) {
                System.out.println("Invalid size. Exiting.");
                return;
            }
            array = new Random().ints(size, 1, 100).toArray();
        } else {
            System.out.print("Enter array size: ");
            var size = scanner.nextInt();
            if (size < 1 || size > 100) {
                System.out.println("Invalid size. Exiting.");
                return;
            }
            array = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
        }

        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println();

        if (mainChoice == 1) {
            // Visualize
            System.out.print("Enter visualization delay (0-5000 ms): ");
            var delay = scanner.nextInt();
            if (delay < 0 || delay > 5000) {
                System.out.println("Invalid delay. Exiting.");
                return;
            }

            System.out.println("Choose algorithm to visualize:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.print("Enter choice (1-5): ");
            var choice = scanner.nextInt();

            var sorterToVisualize = switch (choice) {
                case 1 -> new BubbleSort(array);
                case 2 -> new SelectionSort(array);
                case 3 -> new InsertionSort(array);
                case 4 -> new MergeSort(array);
                case 5 -> new QuickSort(array);
                default -> {
                    System.out.println("Invalid choice. Exiting.");
                    yield null;
                }
            };

            if (sorterToVisualize == null) return;

            var algoName = switch (choice) {
                case 1 -> "Bubble Sort";
                case 2 -> "Selection Sort";
                case 3 -> "Insertion Sort";
                case 4 -> "Merge Sort";
                case 5 -> "Quick Sort";
                default -> "";
            };

            System.out.println("Visualizing " + algoName + " (step-by-step):");
            Visualizer.visualize(sorterToVisualize, delay, algoName);
        } else if (mainChoice == 2) {
            // Compare
            System.out.println("Comparing All Algorithms:");
            Comparator.compareAlgorithms(array);
        } else {
            System.out.println("Invalid main choice. Exiting.");
        }
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */