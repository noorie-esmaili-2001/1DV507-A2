package ne222hz_assign2.Exercise5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void test() {
		LinkedQueue<String> queue = new LinkedQueue<>();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.dequeue();
		queue.enqueue("D");
		String output = queue.toString();
		assertEquals("[ B C D ]", output);
		
		
		LinkedQueue<String> queue1 = new LinkedQueue<>();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.dequeue();
		queue1.enqueue(4);
		String output1 = queue1.toString();
		assertEquals("[ 2 3 4 ]", output1);

	}

}
