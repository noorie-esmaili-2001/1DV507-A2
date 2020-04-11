package ne222hz_assign2.Exercise5;

import java.util.Iterator;

class Node {
	Object data;
	Node next;

	Node(Object element) {
		data = element;
		next = null;
	}
}

/**
 * Linked queue 
 *
 * @author Noorie Esmaili
 * 
 */
public class LinkedQueue<T> implements Queue<T> {

	/**
	 * initializing head and tail
	 */
	Node head, tail;

	/**
	 * This is the class for empty queue
	 */
	public LinkedQueue() {
		this.head = this.tail = null;
	}

	/**
	 * This method checks if the queue is empty if yes it returns true else it
	 * returns false
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	/**
	 * This method would return the size of queue
	 */
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			int count = 0;
			Node temp = this.head;
			while (temp != tail) {
				count++;
				temp = temp.next;
			}
			return count + 1;
		}
	}

	/**
	 * Method adds element at end of queue
	 */
	public void enqueue(Object element) {
		Node temp = new Node(element);
		if (this.tail == null) {
			this.head = this.tail = temp;
		} else {
			this.tail.next = temp;
			this.tail = temp;
		}
	}

	/**
	 * return and remove first element.
	 */
	public Object dequeue() {
		if (isEmpty()) {
			return -1;
		}
		Node temp = this.head;
		this.head = this.head.next;
		if (this.head == null)
			this.tail = null;
		return temp.data;
	}

	/**
	 * return a string representation of the queue content
	 */
	public String toString() {
		Node temp = head;
		String st = "[ ";
		while (temp != null) {
			st = st + temp.data + " ";
			temp = temp.next;
		}
		st = st + "]";
		return st;
	}

	/**
	 * return (without removing) first element
	 */
	@Override
	public Object first() {
		return this.head.data;
	}

	/**
	 * return (without removing) last element
	 */
	@Override
	public Object last() {
		return this.tail.data;
	}

	/**
	 *
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new ListIterator();
	}

	/**
	 * @author Noorie Esmaili
	 *
	 */
	class ListIterator implements Iterator<Integer> {
		private Node node = head;

		public Integer next() {
			Object val = node.data;
			node = node.next;
			return (Integer) val;
		}

		public boolean hasNext() {
			return node != null;
		}

		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}


}
