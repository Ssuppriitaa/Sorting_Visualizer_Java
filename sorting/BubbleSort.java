package sorting;

public class BubbleSort extends SortingAlgorithm {
    public BubbleSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(array[j], array[j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */