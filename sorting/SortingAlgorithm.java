package sorting;

public abstract class SortingAlgorithm {
    protected int[] array;
    protected int steps = 0; // Counter for comparisons/swaps

    public SortingAlgorithm(int[] array) {
        this.array = array.clone(); // Work on a copy
    }

    public abstract void sort();

    public int getSteps() {
        return steps;
    }

    public int[] getArray() {
        return array;
    }

    protected void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        steps++;
    }

    protected boolean compare(int a, int b) {
        steps++;
        return a > b;
    }
}
/*BY:
NAME : SUPRITA THAKUR
EMAIL: thakursuprita30@gmail.com
 */