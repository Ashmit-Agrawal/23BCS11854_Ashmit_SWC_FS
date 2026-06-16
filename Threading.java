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

public class Threading {
    public static void main(String[] args) {
        Shared s = new Shared();

        Producer p = new Producer(s);
        Consumer c = new Consumer(s);

        p.start();
        c.start();
    }
}