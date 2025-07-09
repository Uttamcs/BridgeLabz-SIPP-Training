package LinkedList;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process current;
    private int timeQuantum = 3;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            current = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        
        if (head.processId == processId && head.next == head) {
            head = null;
            current = null;
            return;
        }
        
        Process temp = head;
        if (head.processId == processId) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            current = head;
            return;
        }
        
        while (temp.next != head && temp.next.processId != processId) {
            temp = temp.next;
        }
        if (temp.next.processId == processId) {
            if (temp.next == current) {
                current = current.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void simulate() {
        if (head == null) return;
        
        System.out.println("Round Robin Simulation (Time Quantum: " + timeQuantum + ")");
        int time = 0;
        
        while (head != null) {
            System.out.println("Time " + time + ": Process " + current.processId + " executing");
            
            if (current.remainingTime <= timeQuantum) {
                time += current.remainingTime;
                System.out.println("Process " + current.processId + " completed at time " + time);
                removeProcess(current.processId);
            } else {
                current.remainingTime -= timeQuantum;
                time += timeQuantum;
                current = current.next;
            }
            
            if (head != null) {
                displayProcesses();
            }
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.print("Process Queue: ");
        do {
            System.out.print("P" + temp.processId + "(remaining:" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();
        
        scheduler.simulate();
    }
}