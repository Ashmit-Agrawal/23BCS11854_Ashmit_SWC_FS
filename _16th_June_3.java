// "Problem Statement:
// A system generates data (producer) and processes it (consumer). Synchronization is required to avoid data inconsistency.

// Task:
// Implement producer-consumer using a shared buffer.

// Requirements:

// Use wait() and notify()
// Prevent buffer overflow/underflow
// Ensure proper synchronization
// Print produced and consumed values"

class Shared {
    int data;
    boolean hasData = false;

    synchronized void produce(int value) {
        while(hasData) {
            try {
                wait();
            } catch(InterruptedException e) {System.out.println(e);}
        }
        data = value;
        System.out.println("Produced: " + data);
        hasData = true;

        notify();
    }

    synchronized void consume() {
        while(!hasData) {
            try {
                wait();
            } catch(InterruptedException e) {System.out.println(e);}
        }
        System.out.println("Consumed: " + data);
        hasData = false;

        notify();
    }
}

class Producer extends Thread {
    Shared s;

    Producer(Shared s) {
        this.s = s;
    }
    public void run() {
        for(int i=1;i<=5;i++) {
            s.produce(i);
        }
    }
}

class Consumer extends Thread {
    Shared s;
    Consumer(Shared s) {
        this.s = s;
    }

    public void run() {
        for(int i=1;i<=5;i++) {
            s.consume();
        }
    }
}

public class _16th_June_3 {
    public static void main(String[] args) {
        Shared s = new Shared();

        Producer p = new Producer(s);
        Consumer c = new Consumer(s);

        p.start();
        c.start();
    }
}