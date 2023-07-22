package ch06;


import java.util.concurrent.atomic.AtomicBoolean;


public class Peterson2 {
    static class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                // entry
                flag[0].set(true);
                turn = 1;
                while(flag[1].get() && turn == 1){
                }
                // critical
                count++;

                //exit
                flag[0].set(false);

                //remainder
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                // entry
                flag[1].set(true);
                turn = 0;
                while(flag[0].get() && turn == 0){
                }
                // critical
                count--;

                //exit
                flag[1].set(false);

                //remainder
            }
        }
    }
    static int count = 0;
    static int turn = 0;
    static AtomicBoolean[] flag;
    static {
        flag = new AtomicBoolean[2];
        for(int i = 0; i<flag.length;i++){
            flag[i] = new AtomicBoolean();
        }
    }


    public static void main(String[] args) throws Exception {
        Producer prod = new Producer();
        Consumer cons = new Consumer();

        Thread t1 = new Thread(prod);
        Thread t2 = new Thread(cons);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Result : " + count);
        // 실행 결과
        // Result : 0
    }
}
