import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskProducer implements Runnable {
    private final Map<Priority, BlockingTaskQueue> priorityQueues;
    private final int producerId;
    private final int numberOfTasksToProduce;
    private static AtomicInteger taskCounter = new AtomicInteger(0);
    private volatile boolean shutdownRequested = false;

    public TaskProducer(Map<Priority, BlockingTaskQueue> priorityQueues, int producerId, int numberOfTasksToProduce) {
        this.priorityQueues = priorityQueues;
        this.producerId = producerId;
        this.numberOfTasksToProduce = numberOfTasksToProduce;
    }

    @Override
    public void run() {
        System.out.println("Producer " + producerId + " (Thread: " + Thread.currentThread().getName() + ") started.");
        Random random = new Random();
        for (int i = 0; i < numberOfTasksToProduce && !shutdownRequested; i++) {
            try {
                int taskId = taskCounter.getAndIncrement();
                // TODO: Create Task with taskId and Assign a random priority (HIGH, MEDIUM, or LOW) to the task.
                //  Get the correct CustomBlockingTaskQueue instance from the 'priorityQueues' map
                //  based on the task's 'priority'. implement the rest based on the document.

                // start of your implementation


                // end of your implementation

                Thread.sleep(random.nextInt(151) + 50);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer " + producerId + " was interrupted. Stopping production.");
                break;
            }
        }
        if (shutdownRequested) {
            System.out.println("Producer " + producerId + " received shutdown request and is stopping early.");
        }
        System.out.println("Producer " + producerId + " finished producing tasks.");
    }

    public void requestShutdown() {
        this.shutdownRequested = true;
    }
}