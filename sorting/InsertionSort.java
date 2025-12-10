package sorting;

public class InsertionSort extends SortingAlgorithm {
    public InsertionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && compare(array[j], key)) {
                array[j + 1] = array[j];
                j--;
                steps++; // Count shifts
            }
            array[j + 1] = key;
        }
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */