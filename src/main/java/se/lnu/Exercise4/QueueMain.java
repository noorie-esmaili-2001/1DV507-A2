package se.lnu.Exercise4;

public class QueueMain {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue);
		System.out.println(queue.dequeue() + " is removed.");
		System.out.println(queue.first() + " is the first element.");
		queue.enqueue(4);
		System.out.println(queue.last() + " is the last element.");
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

	}

}
