package ne222hz_assign2.Exercise4;

/**
 * @author noori
 *
 */

public interface IntQueue extends Iterable<Integer> {
	/**
	 * @return size of queue
	 */
	public int size(); // current queue size

	/**
	 * @return true if queue is empty
	 */
	public boolean isEmpty(); // true if queue is empty

	/**
	 * @param element
	 */
	public void enqueue(int element); // add element at end of queue

	/**
	 * @return first element
	 */
	public int dequeue(); // return and remove first element.

	/**
	 * @return first element
	 */
	public int first(); // return (without removing) first element

	/**
	 * @return last element
	 */
	public int last(); // return (without removing) last element

	/**
	 * @return [ 1 2 ...]
	 */
	public String toString(); // return a string representation of the queue content

}