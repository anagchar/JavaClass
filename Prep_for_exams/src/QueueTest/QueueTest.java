package QueueTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Queue.Queue;
import Queue.RingBuffer;
import Queue.SimpleQueue;

class QueueTest {

	void testQueue(Queue queue) {
		assertEquals(0, queue.getSize());
		
		queue.enqueue("hello");
		assertEquals(1, queue.getSize());
		assertArrayEquals(new Object[] {"hello"}, queue.toArray());
		
		queue.enqueue(42);
		assertEquals(2, queue.getSize());
		assertArrayEquals(new Object[] {"hello", 42}, queue.toArray());

		queue.enqueue(false);
		assertEquals(3, queue.getSize());
		assertArrayEquals(new Object[] {"hello", 42, false}, queue.toArray());
		
		assertEquals("hello", queue.dequeue());
		assertEquals(2, queue.getSize());
		assertArrayEquals(new Object[] {42, false}, queue.toArray());
		
		queue.enqueue("foo");
		assertEquals(3, queue.getSize());
		assertArrayEquals(new Object[] {42, false, "foo"}, queue.toArray());
		
		assertEquals(42, queue.dequeue());
		assertArrayEquals(new Object[] {false, "foo"}, queue.toArray());
		
		SimpleQueue queue2 = new SimpleQueue();
		queue2.enqueue(false);
		queue2.enqueue("foo");
		assertEquals(queue2, queue);
		assertEquals(queue, queue2);
		
		queue.enqueue(11);
		queue.enqueue(22);
		assertEquals(4, queue.getSize());
		assertArrayEquals(new Object[] {false, "foo", 11, 22}, queue.toArray());
	
		assertNotEquals(queue2, queue);
		assertNotEquals(queue, queue2);
	}

	@Test
	void test() {
		SimpleQueue queue = new SimpleQueue();
		testQueue(queue);
		
		RingBuffer ringBuffer = new RingBuffer();
		testQueue(ringBuffer);
	}


}
