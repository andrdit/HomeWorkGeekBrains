package HomeWork5;

public class Main {

    public static void main(String[] args){

        Animal[] animal = {
                new Dog("dog1"),
                new Dog("dog2", 250, 50, 2),
                new Dog("dog3", 400, 150, 2.8f),
                new Horse("horse1"),
                new Horse("horse2",2000,200,2),
                new Horse("horse3", 1000, 3000,5),
                new Cat("cat1"),
                new Cat("cat2", 150, 1.5f),
                new Cat("cat3", 300, 2.6f),
                new Bird("Bird1"),
                new Bird("Bird2",50,3.5f),
                new Bird("Bird3", 110, 1.4f),
        };

        for (int i = 0; i < animal.length; i++) {

            System.out.println(animal[i].toRun(60));
            System.out.println(animal[i].toJump(2.5f));

            if(animal[i] instanceof Dog || animal[i] instanceof Horse){
                System.out.println(animal[i].toSwim(100));
            }

        }


    }
}
