package se.lnu.Exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

/**
 * Linked queue
 *
 * @author Noorie Esmaili
 *
 */
public class LinkedQueue implements IntQueue {

	/**
	 * initializing head and tail
	 */
	private Node head, tail;

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
        return this.head == null;
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
	public void enqueue(int element) {
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
	public int dequeue() {
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
		StringBuilder st = new StringBuilder("[ ");
		while (temp != null) {
			st.append(temp.data).append(" ");
			temp = temp.next;
		}
		st.append("]");
		return st.toString();
	}

	/**
	 * return (without removing) first element
	 */
	@Override
	public int first() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		return this.head.data;
	}

	/**
	 * return (without removing) last element
	 */
	@Override
	public int last() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
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
	 * Iterator for the LinkedQueue
	 */
	class ListIterator implements Iterator<Integer> {
		private Node node = head;

		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements");
			}
			int val = node.data;
			node = node.next;
			return val;
		}

		public boolean hasNext() {
			return node != null;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove() is not implemented");
		}
	}

}
