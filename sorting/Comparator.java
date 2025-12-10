package sorting;

import java.util.Arrays;

public class Comparator {
    public static void compareAlgorithms(int[] originalArray) {
        var algorithms = new SortingAlgorithm[]{
            new BubbleSort(originalArray),
            new SelectionSort(originalArray),
            new InsertionSort(originalArray),
            new MergeSort(originalArray),
            new QuickSort(originalArray)
        };

        var names = new String[]{"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort"};
        var spaceComplexities = new String[]{"O(1)", "O(1)", "O(1)", "O(n)", "O(log n)"};
        var bestCases = new String[]{"O(n)", "O(n²)", "O(n)", "O(n log n)", "O(n log n)"};
        var averageCases = new String[]{"O(n²)", "O(n²)", "O(n²)", "O(n log n)", "O(n log n)"};
        var worstCases = new String[]{"O(n²)", "O(n²)", "O(n²)", "O(n log n)", "O(n²)"};

        for (int i = 0; i < algorithms.length; i++) {
            var copy = Arrays.copyOf(originalArray, originalArray.length);
            var sorter = createSorter(names[i], copy);

            var startTime = System.nanoTime();
            sorter.sort();
            var endTime = System.nanoTime();

            var duration = endTime - startTime;
            var steps = sorter.getSteps();

            System.out.println(names[i] + ":");
            System.out.println("  Time: " + duration + " ns");
            System.out.println("  Steps: " + steps);
            System.out.println("  Space Complexity: " + spaceComplexities[i]);
            System.out.println("  Best Case Time: " + bestCases[i]);
            System.out.println("  Average Case Time: " + averageCases[i]);
            System.out.println("  Worst Case Time: " + worstCases[i]);
            System.out.println("  Sorted: " + Arrays.toString(sorter.getArray()));
            System.out.println();
        }
    }

    private static SortingAlgorithm createSorter(String name, int[] array) {
        return switch (name) {
            case "Bubble Sort" -> new BubbleSort(array);
            case "Selection Sort" -> new SelectionSort(array);
            case "Insertion Sort" -> new InsertionSort(array);
            case "Merge Sort" -> new MergeSort(array);
            case "Quick Sort" -> new QuickSort(array);
            default -> null;
        };
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */