/**
 * @author Siqi Wang siqiw1 on 6/13/16.
 */
public class SimpleSort {
    // For each round, BUBBLES up the biggest value to the right.
    // Bubble sort makes N^2/2 comparisons, N^2/4 swaps
    public void bubbleSort(int[] data) {
        // values after out are sorted after each iteration.
        for (int out = data.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (data[in] > data[in + 1]) {
                    swap(in, in + 1, data);
                }
            }
        }
    }

    // FOr each round, SELECT the smallest value and swap it with the leftmost value of the array.
    public void selectionSort(int[] data) {
        for (int out = 0; out < data.length - 1; out++) {
            int min = out; // set initial min value's index
            // select a new min value index
            for (int in = out + 1; in < data.length - 1; in++) {
                if (data[in] < data[out]) { // if new min value
                    min = in; // reset the new min index
                }
            }
            swap(min, out, data); // put the new min value at the front.
        }
    }

    // Use an imaginary division line, INSERT the first value of the right-hand side of the line into the proper
    // position in the left-hand side of the line.
    public void insertionSort(int[] data) {
        // set up an imaginary dividing line.
        for (int out = 1; out < data.length - 1; out++) {
            // the first element of the right hand side of the line should be inserted into the left hand side in a
            // proper position.
            int temp = data[out];
            int in = out;
            while (in > 0 && data[in-1] >= temp) {
                // shift the items of the left hand side to the right so that there can be a space for the value that
                // is sotred in the temp place.
                data[in] = data[in-1];
                in--;
            }
            // the right position is found, INSERT the value into that position.
            data[in] = temp;
        }
    }

    private void swap(int num1, int num2, int[] data) {
        int temp = data[num1];
        data[num1] = data[num2];
        data[num2] = temp;
    }
}
