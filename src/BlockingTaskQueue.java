import java.util.LinkedList;
import java.util.List;

public class BlockingTaskQueue {
    private final List<Task> queue;
    private final int capacity;

    public BlockingTaskQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive for the queue.");
        }
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void put(Task task) throws InterruptedException {
        // TODO: BlockingTaskQueue put method
    }

    public Task take() throws InterruptedException {
        Task task = null;
        // TODO: BlockingTaskQueue take method (blocking)


        return task;
    }

    public synchronized Task poll() {

        // TODO: BlockingTaskQueue poll method (non-blocking)
        //  should return a Task instead of null

        return null;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized int size() {
        return queue.size();
    }
}
