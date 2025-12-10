package sorting;

public class Visualizer {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";   // For unsorted elements
    private static final String GREEN = "\u001B[32m"; // For sorted elements

    public static void visualize(SortingAlgorithm sorter, int delayMs, String algoName) throws InterruptedException {
        var arr = sorter.getArray();
        var n = arr.length;
        System.out.println("Initial Array: " + arrayToString(arr, -1, -1));
        Thread.sleep(delayMs);

        // Step-by-step visualization based on algorithm
        switch (algoName) {
            case "Bubble Sort" -> visualizeBubbleSort((BubbleSort) sorter, delayMs);
            case "Selection Sort" -> visualizeSelectionSort((SelectionSort) sorter, delayMs);
            case "Insertion Sort" -> visualizeInsertionSort((InsertionSort) sorter, delayMs);
            case "Merge Sort" -> visualizeMergeSort((MergeSort) sorter, delayMs);
            case "Quick Sort" -> visualizeQuickSort((QuickSort) sorter, delayMs);
        }

        System.out.println("Final Sorted Array: " + arrayToString(arr, 0, n - 1));
    }

    private static void visualizeBubbleSort(BubbleSort sorter, int delayMs) throws InterruptedException {
        var arr = sorter.getArray();
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1) + ": (No special formula used; just adjacent comparisons and swaps)");
            for (int j = 0; j < n - i - 1; j++) {
                if (sorter.compare(arr[j], arr[j + 1])) {
                    sorter.swap(j, j + 1);
                    System.out.println("  Swapped " + arr[j] + " and " + arr[j + 1] + ": " + arrayToString(arr, -1, -1));
                    Thread.sleep(delayMs);
                }
            }
        }
    }

    private static void visualizeSelectionSort(SelectionSort sorter, int delayMs) throws InterruptedException {
        var arr = sorter.getArray();
        var n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1) + ": (No special formula used; just finding min index)");
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (sorter.compare(arr[j], arr[minIdx])) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                sorter.swap(i, minIdx);
                System.out.println("  Swapped " + arr[i] + " with min " + arr[minIdx] + ": " + arrayToString(arr, -1, -1));
                Thread.sleep(delayMs);
            }
        }
    }

    private static void visualizeInsertionSort(InsertionSort sorter, int delayMs) throws InterruptedException {
        var arr = sorter.getArray();
        var n = arr.length;
        for (int i = 1; i < n; i++) {
            System.out.println("Inserting at position " + i + ": (No special formula used; just shifting elements)");
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && sorter.compare(arr[j], key)) {
                arr[j + 1] = arr[j];
                j--;
                sorter.steps++;
                System.out.println("  Shifted " + arr[j + 1] + ": " + arrayToString(arr, -1, -1));
                Thread.sleep(delayMs);
            }
            arr[j + 1] = key;
            System.out.println("  Placed " + key + ": " + arrayToString(arr, -1, -1));
            Thread.sleep(delayMs);
        }
    }

    private static void visualizeMergeSort(MergeSort sorter, int delayMs) throws InterruptedException {
        System.out.println("Starting Merge Sort (Divide-and-Conquer):");
        sorter.visualizeSort(0, sorter.getArray().length - 1, delayMs);
    }

    private static void visualizeQuickSort(QuickSort sorter, int delayMs) throws InterruptedException {
        System.out.println("Starting Quick Sort (Divide-and-Conquer with partitioning):");
        sorter.visualizeSort(0, sorter.getArray().length - 1, delayMs);
    }

    private static String arrayToString(int[] arr, int startGreen, int endGreen) {
        var sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i >= startGreen && i <= endGreen) {
                sb.append(GREEN).append(arr[i]).append(RESET);
            } else {
                sb.append(RED).append(arr[i]).append(RESET);
            }
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */