import java.util.*;

// "Problem Statement:
// A shared counter is accessed by multiple threads simultaneously, leading to incorrect results due to race conditions.

// Task:  Implement a thread-safe counter.

// Requirements:
// Use synchronized or atomic class
// Create multiple threads incrementing counter
// Ensure final result is accurate
// Compare unsafe vs safe implementation"

public class _16th_June_2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<10; i++) {
            Thread t = new Thread(() -> {
                for(int j=0; j<1000; j++) {
                    counter.increment();
                }
            });
            threads.add(t);
            t.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Final count: " + counter.getCount());

    }
}

class Counter extends Thread{
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
