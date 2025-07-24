package LinkedList;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task current;

    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) return;
        
        if (head.taskId == taskId && head.next == head) {
            head = null;
            current = null;
            return;
        }
        
        Task temp = head;
        if (head.taskId == taskId) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            current = head;
            return;
        }
        
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next.taskId == taskId) {
            temp.next = temp.next.next;
        }
    }

    public Task getCurrentTask() {
        return current;
    }

    public void moveToNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public Task searchByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + 
                             ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addTask(1, "Code Review", 1, "2024-01-15");
        scheduler.addTask(2, "Testing", 2, "2024-01-16");
        scheduler.addTask(3, "Documentation", 3, "2024-01-17");
        
        System.out.println("All Tasks:");
        scheduler.displayAll();
        
        System.out.println("\nCurrent Task: " + scheduler.getCurrentTask().taskName);
        scheduler.moveToNext();
        System.out.println("Next Task: " + scheduler.getCurrentTask().taskName);
        
        Task highPriorityTask = scheduler.searchByPriority(1);
        if (highPriorityTask != null) {
            System.out.println("High Priority Task: " + highPriorityTask.taskName);
        }
    }
}