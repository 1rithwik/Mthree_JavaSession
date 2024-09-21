package sep_20;

public class ThreadingExample {
    // volatile keyword ensures that the variable is always read from main memory
    // private volatile boolean flag = false;

    // synchronized method to demonstrate thread synchronization
    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " entered synchronized method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exiting synchronized method");
    }

    final static Object lock = new Object();

    // Runnable interface implementation
    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "completed running");

            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " entered synchronized block");
                try {
                    Thread.sleep(5000); // Simulate work inside synchronized block
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " exiting synchronized block");
            }
        }
    }

    // Thread class extension
    class MyThread extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "completed running");

            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " entered synchronized block");
                try {
                    Thread.sleep(5000); // Simulate work inside synchronized block
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " exiting synchronized block");
            }
        }
    }

    public void demonstrateThreading() {
        // Creating and starting a thread using Runnable
        Thread thread1 = new Thread(new MyRunnable(), "RunnableThread");
        thread1.start();

        // MyRunnable runnable = new MyRunnable();
        // runnable.setName("RunnableThread"); we cannot call start() on runnable
        // runnable.start();

        // Creating and starting a thread by extending Thread class
        MyThread thread2 = new MyThread();
        thread2.setName("ExtendedThread");
        thread2.start();

        // Creating a thread using lambda expression (Java 8+)
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"),
                "LambdaThread");
        thread3.start();

        // Demonstrating thread states
        System.out.println("Thread 3 state: " + thread3.getState());

        // Thread priority
        thread3.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread 3 priority: " + thread3.getPriority());

        // Joining threads
        try {
            thread1.join();// main thread will wait for thread1 to complete
            thread2.join();// main thread will wait for thread2 to complete
            thread3.join();// main thread will wait for thread3 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Demonstrating synchronized block
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " in synchronized block");
        }

        // Using wait() and notify()
        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is in synchronized block");
                    System.out.println("Waiter is waiting");
                    lock.wait();
                    System.out.println("Waiter is notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifier is notifying");
                lock.notify();
            }
        });

        waiter.start();
        try {
            System.out.println("Main thread is sleeping");
            Thread.sleep(2000);
            System.out.println("Main thread woke up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifier.start();

        // Demonstrating interrupt
        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Sleeper was interrupted");
            }
        });
        sleeper.start();
        sleeper.interrupt();

        // Using ThreadLocal
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(42);
        System.out.println("ThreadLocal value: " + threadLocal.get());

        // Demonstrating deadlock (be cautious when running this)
        // final Object resource1 = new Object();
        // final Object resource2 = new Object();
        // Thread deadlockThread1 = new Thread(() -> {
        // synchronized (resource1) {
        // System.out.println("Thread 1: Holding resource 1...");
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // }
        // System.out.println("Thread 1: Waiting for resource 2...");
        // synchronized (resource2) {
        // System.out.println("Thread 1: Holding resource 1 and resource 2");
        // }
        // }
        // });
        // Thread deadlockThread2 = new Thread(() -> {
        // synchronized (resource2) {
        // System.out.println("Thread 2: Holding resource 2...");
        // try {
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // }
        // System.out.println("Thread 2: Waiting for resource 1...");
        // synchronized (resource1) {
        // System.out.println("Thread 2: Holding resource 2 and resource 1");
        // }
        // }
        // });
        // deadlockThread1.start();
        // deadlockThread2.start();
    }

    public static void main(String[] args) {
        ThreadingExample obj = new ThreadingExample();
        obj.demonstrateThreading();
        obj.synchronizedMethod();
    }
}