
import java.util.LinkedList;

/**
 * The RequestQueue class represents a queue of elevator requests. It extends
 * the LinkedList class to utilize its functionality. It provides
 * methods to enqueue and dequeue requests, check if the queue is empty, and
 * get the size of the queue.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 */
class RequestQueue extends LinkedList<Request> {

    /**
     * Constructs an empty RequestQueue object.
     */
    public RequestQueue() {
    }

    /**
     * Checks if the request queue is empty.
     * 
     * @return true if the request queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Enqueues a request at the end of the request queue.
     * 
     * @param request The request to be enqueued
     */
    public void enqueue(Request request) {
        super.addLast(request);
    }

    /**
     * Dequeues a request from the front of the request queue.
     * 
     * @return The dequeued request, or null if the queue is empty
     */
    public Request dequeue() {
        if (isEmpty()) {
            return null;
        }
        return super.removeFirst();
    }

    /**
     * Gets the size of the request queue.
     * 
     * @return The size of the request queue
     */
    public int size() {
        return super.size();
    }

}
