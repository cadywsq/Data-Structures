/**
 * @author Siqi Wang siqiw1 on 5/6/16.
 */
public class Heap implements HeapInterface {
    private Node[] heapArray;
    private int currentSize;

    private class Node {
        private double value;

        public Node(double value) {
            this.value = value;
        }
    }

    public Heap(int initialCapacity) {
        heapArray = new Node[initialCapacity];
        currentSize = 0;
    }

    public boolean insert(double value) {
        if (currentSize == heapArray.length) {
            return false;
        }
        Node newNode = new Node(value);
        heapArray[currentSize] = newNode;
        percolateUp(currentSize++);
        return true;
    }

    private void percolateUp(int index) {
        // Save newly added bottom node
        Node bottom = heapArray[index];

        // Find the parent index
        int parent = (index - 1) / 2;

        // parent's value is smaller than the new value
        while (index > 0 && heapArray[parent].value < bottom.value) {
            heapArray[index] = heapArray[parent];
            index = parent; // move up
            parent = (parent - 1) / 2; // new parent
        }
        heapArray[index] = bottom; // insert into the proper location
    }

    private void percolateUpRecursive(int index) {
        Node bottom = heapArray[index];
        int parent = (index - 1) / 2;

        if (index == 0 || bottom.value <= heapArray[parent].value) {
            return;
        }
        heapArray[index] = heapArray[parent];
        heapArray[parent] = bottom;
        percolateUpRecursive(parent);
    }

    public double removeMax() {
        if (currentSize == 0) {
            throw new AssertionError();
        }
        Node root = heapArray[currentSize--];
        heapArray[0] = heapArray[currentSize];
        heapArray[currentSize] = null;
        percolateDown(0);
        return root.value;
    }

    private void percolateDown(int index) {
        Node top = heapArray[index];
        int largerChild;
        // loop till the index has no child
        while (index < currentSize / 2) {
            int leftChild = index * 2 + 1;
            int rightChild = leftChild + 1;
            // find the larger child;
            if (rightChild < currentSize && heapArray[leftChild].value < heapArray[rightChild].value) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            // if top is larger, then stop
            if (top.value >= heapArray[largerChild].value) {
                break;
            }
            // move the values up
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        }
        // put top value into proper location to restore the heap
        heapArray[index] = top;
    }

    private void percolateDownRecursive(int index) {
        Node top = heapArray[index];
        int largerChild;

        if (index >= currentSize / 2 ) {
            return;
        }
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;
        if (rightChild < currentSize && heapArray[leftChild].value < heapArray[rightChild].value) {
            largerChild = rightChild;
        } else {
            largerChild = leftChild;
        }

        if (top.value >= heapArray[largerChild].value) {
            return;
        }
        heapArray[index] = heapArray[largerChild];
        heapArray[largerChild] = top;
        percolateDownRecursive(largerChild);
    }
}
