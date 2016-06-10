/**
 * @author Siqi Wang siqiw1 on 5/6/16.
 */
public interface HeapInterface {
    /**
     * Insert a new value into a heap
     * @param value value to be inserted
     * @return boolean to check whether it was added or not
     */
    boolean insert(double value);

    /**
     * remove the highest priority value
     * @return removed value
     */
    double removeMax();
}
