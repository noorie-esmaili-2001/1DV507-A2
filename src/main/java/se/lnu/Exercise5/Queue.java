package se.lnu.Exercise5;

/**
 * @author noori
 *
 */

public interface Queue<T> extends Iterable<Integer> {
	/**
	 * @return size of queue
	 */
    int size(); // current queue size

	/**
	 * @return true if queue is empty
	 */
    boolean isEmpty(); // true if queue is empty

	/**
	 * @param element element.
	 */
    void enqueue(T element); // add element at end of queue

	/**
	 * @return first element
	 */
    Object dequeue(); // return and remove first element.

	/**
	 * @return first element
	 */
    Object first(); // return (without removing) first element

	/**
	 * @return last element
	 */
    Object last(); // return (without removing) last element

	/**
	 * @return [ 1 2 ...]
	 */
    String toString(); // return a string representation of the queue content

}