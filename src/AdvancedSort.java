/**
 * @author Siqi Wang siqiw1 on 6/29/16.
 */
public class AdvancedSort {
    /**
     * MergeSort: Time Complexity O(NlogN) for worst case and on average
     * Space Complexity
     * (1) implementation on array: O(NlogN)??
     * (2) implementation on linked list: O(1)
     */
    public int[] mergeSort(int[] unsorted) {
        // base case
        if (unsorted.length <= 1) {
            return unsorted;
        }
        int mid = unsorted.length / 2;
        //create left array
        int[] left = new int[mid];
        System.arraycopy(unsorted, 0, left, 0, mid);
        //create right array
        int[] right = new int[unsorted.length - mid];
        System.arraycopy(unsorted, mid + 1, right, 0, right.length);

        // call itself with left and right halves
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    /*
    Merge two sorted arrays into a new sorted array
     */
    private int[] merge(int[] a, int[] b) {
        // Create a new array
        int[] merged = new int[a.length + b.length];
        // initialize all of the indices
        int indexA = 0;
        int indexB = 0;
        int indexM = 0;
        // add correct values to new array
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] < b[indexB]) {
                merged[indexM] = a[indexA++];
            } else {
                merged[indexM] = b[indexB++];
            }
            indexM++;
        }
        while (indexA < a.length) {
            merged[indexM++] = a[indexA++];
        }
        while (indexB < b.length) {
            merged[indexM++] = b[indexB++];
        }
        return merged;
    }

    /**
     * QuickSort: Time Complexity O(NlogN) on average, worst case O(n^2)
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        // last value is the pivot value
        int pivot = array[right];
        int partition = partition(array, left, right, pivot);

        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    // After execute below method, the element on the position of return value is at its right position.
    private int partition(int[] array, int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (array[++leftPointer] < pivot);
            while (rightPointer > 0 && array[--rightPointer] > pivot);
            // loop may end at this point if array already sorted for this pivot.
            // shouldn't use while(leftP < rightP) as the ending condition for the whole block
            // may have arrayIndexOutOfBound error when swap.
            if (leftPointer >= rightPointer) {
                break;
            }
            swap(array, leftPointer, rightPointer);
        }
        // don't forget to put pivot in the right position.
        swap(array, leftPointer, pivot);
        return leftPointer;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
