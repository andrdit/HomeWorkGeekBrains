package generalization;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        //useCommonMethods();

        //workWithFruits();


    }

    private static void workWithFruits() {
        Apple apple1 = new Apple(1.1f);
        Apple apple2 = new Apple(1.2f);
        Apple apple3 = new Apple(1.3f);
        Apple apple4 = new Apple(1.4f);
        Apple apple5 = new Apple(1.5f);

        Orange orange1 = new Orange(1.1f);
        Orange orange2 = new Orange(1.2f);
        Orange orange3 = new Orange(1.3f);
        Orange orange4 = new Orange(1.4f);
        Orange orange5 = new Orange(1.5f);

//        Orange orange1 = new Orange(2.1f);
//        Orange orange2 = new Orange(2.2f);
//        Orange orange3 = new Orange(2.3f);
//        Orange orange4 = new Orange(2.4f);
//        Orange orange5 = new Orange(2.5f);

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox1.addArrayFruit(apple1, apple2,apple3,apple4,apple5);
        appleBox2.addFruit(apple1);

        orangeBox1.addArrayFruit(orange1, orange2,orange3,orange4,orange5);

        System.out.println(appleBox1.getStorage());
        System.out.println(orangeBox1.getStorage());

        System.out.println("apple box 1 has weight = " + appleBox1.getWeight());
        System.out.println("apple box 2 has weight = " + appleBox2.getWeight());
        System.out.println("orange box 1 has weight = " + orangeBox1.getWeight());
        System.out.println("orange box 2 has weight = " + orangeBox2.getWeight());

        System.out.println("-----------------------");

        appleBox2.pourToAnotherBox(appleBox1);
        System.out.println("apple box 1 has weight = " + appleBox1.getWeight());
        System.out.println("apple box 2 has weight = " + appleBox2.getWeight());

        appleBox1.pourToAnotherBox(appleBox2);
        orangeBox1.pourToAnotherBox(orangeBox2);
        orangeBox2.addFruit(orange1);

        System.out.println("-----------------------");
        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(orangeBox2.compare(appleBox2));

        //work with control max weight of box
        Box<Apple> appleBoxWithMaxWeigt1 = new Box<>(5f);
        Box<Apple> appleBoxWithMaxWeigt2 = new Box<>(4f);

        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));
        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));
        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));
        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));
        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));
//        appleBoxWithMaxWeigt1.addFruit(new Apple(1f));

        appleBoxWithMaxWeigt1.pourToAnotherBoxWithControlMaxWeight(appleBoxWithMaxWeigt2);


    }

    private static void useCommonMethods() {

        Integer[] iArr = new Integer[]{1, 2};
        String[] sArr = new String[]{"1", "2"};
        Boolean[] bArr = new Boolean[]{true, false};

        show(iArr);
        changePlace(iArr);
        show(iArr);
        System.out.println();

        show(sArr);
        changePlace(sArr);
        show(sArr);
        System.out.println();

        show(bArr);
        changePlace(bArr);
        show(bArr);
        System.out.println("------------------");

        ArrayList iarrayList = getArrayList(iArr);
        System.out.println(iarrayList);

        ArrayList sarrayList = getArrayList(sArr);
        System.out.println(sarrayList);

        ArrayList barrayList = getArrayList(bArr);
        System.out.println(barrayList);
    }

    private static <T> void show(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static <T> void changePlace(T[] arr){
        T tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    /**
     * Преобразование массива в ArrayList.
     *
     * @param <T>> Исходный массив любого типа данных.
     * @return ArrayList, возвращает коллекцию ArrayList.
     */
    private static <T> ArrayList getArrayList(T[] arr){
        return new ArrayList(Arrays.asList(arr));
    }
}
