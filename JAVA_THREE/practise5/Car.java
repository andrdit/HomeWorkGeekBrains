package practise5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private CountDownLatch cdl;
    private CountDownLatch cdl1;
    private CountDownLatch cdlFinish;
    private Semaphore tunnelSemaphore;

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdl, CountDownLatch cdl1, Semaphore tunnelSemaphore, CountDownLatch cdlFinish) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
        this.cdl1 = cdl1;
        this.tunnelSemaphore = tunnelSemaphore;
        this.cdlFinish = cdlFinish;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            cdl.countDown();
            cdl.await();
            System.out.println(this.name + " готов");
            cdl1.countDown();
            cdl1.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            
            race.getStages().get(i).go(this);

            if(i == race.getStages().size() -1 && !race.isRaceFinish){
                race.isRaceFinish = true;
                System.out.println(name + " win !!!");
            }

            if(i == race.getStages().size() -1){
                cdlFinish.countDown();
            }
        }
    }

    public Semaphore getTunnelSemaphore() {
        return tunnelSemaphore;
    }

}
