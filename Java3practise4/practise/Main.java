package practise4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static volatile char letter;

    static ExecutorService executorService;

    public static void main(String[] args) {

        Object key = new Object();
        letter = 'A';

        executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> {

            synchronized (key) {
                for (int i = 0; i < 3; i++) {

                    try {
                        while (letter != 'A') {
                            key.wait();
                        }

                        System.out.print(letter + " ");
                        letter = 'B';
                        key.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        executorService.execute(() -> {

            synchronized (key) {
                for (int i = 0; i < 3; i++) {
                    try {
                        while (letter != 'B') {
                            key.wait();
                        }

                        System.out.print(letter + " ");
                        letter = 'C';
                        key.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.execute(() -> {

            synchronized (key) {
                for (int i = 0; i < 3; i++) {
                    try {
                        while (letter != 'C') {
                            key.wait();
                        }

                        System.out.println(letter);
                        letter = 'A';
                        key.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.shutdown();

    }
}


