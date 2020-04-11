package ne222hz_assign2.Exercise4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {

	@Test
	void test() {
		LinkedQueue queue = new LinkedQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		String output = queue.toString();
		assertEquals("[ 2 3 ]", output);

	}

}
