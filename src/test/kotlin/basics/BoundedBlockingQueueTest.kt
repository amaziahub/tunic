package basics

import kotlin.test.Test
import kotlin.test.assertEquals

class BoundedBlockingQueueTest {

    @Test
    fun testEnqueueAndDequeue() {
        val queue = BoundedBlockingQueue<Int>(2)

        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(2, queue.size())

        val item1 = queue.dequeue()
        val item2 = queue.dequeue()

        assertEquals(1, item1)
        assertEquals(2, item2)
        assertEquals(0, queue.size())
    }

    @Test
    fun testBlockingOnFullQueue() {
        val queue = BoundedBlockingQueue<Int>(2)

        // Enqueue 2 items
        queue.enqueue(1)
        queue.enqueue(2)

        // Create a thread to enqueue an item (should block until there's space)
        val thread = Thread {
            queue.enqueue(3)
        }

        thread.start()

        // Dequeue 1 item and allow the thread to continue
        queue.dequeue()

        // After the dequeue, the third item should be added
        thread.join()
        assertEquals(2, queue.size())
    }

    @Test
    fun testBlockingOnEmptyQueue() {
        val queue = BoundedBlockingQueue<Int>(2)

        // Start a thread to dequeue an item (should block until there's an item)
        val thread = Thread {
            queue.dequeue()
        }

        thread.start()

        // Enqueue an item to unblock the dequeue thread
        queue.enqueue(1)

        // Ensure the dequeue thread completes
        thread.join()

        assertEquals(0, queue.size())
    }
}
