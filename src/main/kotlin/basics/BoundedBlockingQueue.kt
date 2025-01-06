package basics

import java.util.*
import java.util.concurrent.locks.ReentrantLock

class BoundedBlockingQueue<T>(private val capacity: Int) {

    private val queue: LinkedList<T> = LinkedList()
    private val lock = ReentrantLock()
    private val notFull = lock.newCondition() // To block when the queue is full
    private val notEmpty = lock.newCondition() // To block when the queue is empty


    // Adds an item to the queue.
    // If the queue is full, the thread should block until space becomes available.
    fun enqueue(item: T) {
        lock.lock()
        try {
            while (capacity == size()) {
                notFull.await()
            }
            queue.offer(item)
            notEmpty.signal()
        } finally {
            lock.unlock()
        }
    }

    // Removes and returns an item from the queue.
    // If the queue is empty, the thread should block until an item is available.
    fun dequeue(): T {
        lock.lock()
        try {
            while (queue.isEmpty()) {
                notEmpty.await()
            }
            val item = queue.poll()
            notFull.signal()
            return item ?: throw NoSuchElementException("Queue is empty")
        } finally {
            lock.unlock()
        }
    }

    // Returns the current number of items in the queue.
    fun size(): Int {
        lock.lock()
        try {
            return queue.size
        } finally {
            lock.unlock()
        }

    }
}
