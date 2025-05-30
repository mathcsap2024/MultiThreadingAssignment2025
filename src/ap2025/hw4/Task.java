package ap2025.hw4;

public class Task {
    private final int id;
    private final String description;
    private final Priority priority;

    public Task(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ap2025.hw4.Task{id=" + id + ", description='" + description + "', priority=" + priority + "}";
    }
}
