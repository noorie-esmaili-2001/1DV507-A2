package se.lnu.Exercise4;

public interface IntQueue extends Iterable<Integer> {
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
    void enqueue(int element); // add element at end of queue

	/**
	 * @return first element
	 */
    int dequeue(); // return and remove first element.

	/**
	 * @return first element
	 */
    int first(); // return (without removing) first element

	/**
	 * @return last element
	 */
    int last(); // return (without removing) last element

	/**
	 * @return [ 1 2 ...]
	 */
    String toString(); // return a string representation of the queue content

}