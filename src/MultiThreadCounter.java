

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadCounter extends Thread {



    static AtomicInteger atomicInteger = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {

        MultiThreadCounter multiThreadCounter = new MultiThreadCounter();
        Collection<Thread> threadCollection = new ArrayList<Thread>();


        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(multiThreadCounter);
            thread.start();
            threadCollection.add(thread);
        }

        for (Thread thread : threadCollection){
            thread.join();
        }

        System.out.println(atomicInteger);
    }


    public static void nextCounter() {
        atomicInteger.incrementAndGet();

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            nextCounter();

        }

    }
}

