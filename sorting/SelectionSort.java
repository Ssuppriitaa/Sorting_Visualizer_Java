package sorting;

public class SelectionSort extends SortingAlgorithm {
    public SelectionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIdx])) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(i, minIdx);
            }
        }
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */