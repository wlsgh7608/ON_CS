package ch06;

public class SynchExample5 {


    static class Counter {
        public static int count = 0;


        public void increment() {
            synchronized (this) {
                Counter.count++;

            }

        }
    }

    static class MyRunnable2 implements Runnable {
        Counter counter;

        public MyRunnable2(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[5];
        Counter counter = new Counter();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunnable2(counter));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }


        System.out.println("Result : " + Counter.count);
        // 실행 결과
        // Expected : 50000
        // Result : 50000
    }
}