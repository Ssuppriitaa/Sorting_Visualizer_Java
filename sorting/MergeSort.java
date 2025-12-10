package sorting;

public class MergeSort extends SortingAlgorithm {
    public MergeSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        mergeSort(0, array.length - 1);
    }

    public void visualizeSort(int left, int right, int delayMs) throws InterruptedException {
        if (left < right) {
            // Calculate mid using the formula
            int mid = left + (right - left) / 2;
            System.out.println("Dividing array[" + left + ".." + right + "] into [" + left + ".." + mid + "] and [" + (mid + 1) + ".." + right + "]");
            System.out.println("  Formula used: mid = " + left + " + (" + right + " - " + left + ") / 2 = " + mid);
            Thread.sleep(delayMs);

            // Recurse on left half
            visualizeSort(left, mid, delayMs);
            // Recurse on right half
            visualizeSort(mid + 1, right, delayMs);
            // Merge
            merge(left, mid, right);
            System.out.println("Merged [" + left + ".." + right + "]: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(array, left, right + 1)));
            Thread.sleep(delayMs);
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (compare(R[j], L[i])) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }
        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */