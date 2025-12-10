package sorting;

public class QuickSort extends SortingAlgorithm {
    public QuickSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        quickSort(0, array.length - 1);
    }

    public void visualizeSort(int low, int high, int delayMs) throws InterruptedException {
        if (low < high) {
            int pi = partition(low, high);
            System.out.println("Partitioned [" + low + ".." + high + "] with pivot " + array[pi] + " at index " + pi);
            System.out.println("  Formula used: Pivot = last element (" + array[high] + "); no complex formula, just simple selection.");
            Thread.sleep(delayMs);

            visualizeSort(low, pi - 1, delayMs);
            visualizeSort(pi + 1, high, delayMs);
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high]; // Simple pivot selection
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (!compare(array[j], pivot)) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */