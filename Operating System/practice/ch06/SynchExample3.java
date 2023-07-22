package ch06;

public class SynchExample3 {


    static class Counter {
        public static int count = 0;
        private static Object object = new Object();


        public static void increment() {
            synchronized (object) {
                count++;

            }

        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                Counter.increment();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyRunnable());
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