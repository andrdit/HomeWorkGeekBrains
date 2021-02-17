package practise5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static final int ONE_COUNT_FOR_START = 1;
    public static int halfCountCars = CARS_COUNT / 2;

    public static void main(String[] args) {

        CountDownLatch cdlDoReady = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlReady = new CountDownLatch(CARS_COUNT + ONE_COUNT_FOR_START);
        CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);

        Semaphore tunnelSemaphore = new Semaphore(halfCountCars, true);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdlDoReady, cdlReady, tunnelSemaphore, cdlFinish);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        while (cdlReady.getCount() > 1) //Проверяем, собрались ли все автомобили
            try {
                Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cdlReady.countDown();

        try {
            cdlFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
