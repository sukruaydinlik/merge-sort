import java.util.Arrays;
import java.util.Random;

public class MergeSortDemo {
    public static void main(String[] args) {

        int[] numbers = new Random()
                .ints(10000, 0, 10000000)
                .toArray();

        System.out.println("Initial");
        System.out.println(Arrays.toString(numbers));

        mergeSort(numbers);

        System.out.println("\nSorted");
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * Sorts the given array by using recursive merge sort algorithm.
     * Time complexity is O(nlogn)
     * Space complexity is O(n), because of the sub arrays
     *
     * @param numbers: numbers to be sorted
     */
    private static void mergeSort(int[] numbers) {
        var numberLength = numbers.length;

        if (numberLength < 2) {
            return;
        }
        int halfLength = numberLength / 2;
        int[] leftArray = Arrays.copyOfRange(numbers, 0, halfLength);
        int[] rightArray = Arrays.copyOfRange(numbers, halfLength, numberLength);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(numbers, leftArray, rightArray);
    }

    /**
     * Merges already sorted two arrays into sorted one array.
     *
     * @param initialArray: Array which will have the results.
     * @param leftArray:    Sorted array to merge
     * @param rightArray:   Sorted array to merge
     */
    private static void merge(int[] initialArray, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        // Compare and assign the bigger one
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                initialArray[k] = leftArray[i];
                i++;
            } else {
                initialArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Assign remaining
        while (i < leftArray.length) {
            initialArray[k] = leftArray[i];
            i++;
            k++;
        }

        // Assign remaining
        while (j < rightArray.length) {
            initialArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
