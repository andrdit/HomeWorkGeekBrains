
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 5, 2, 3, 4, 1, 7};

        System.out.println(Arrays.toString(getArray(array)));




    }

    /*2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
    Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.

    Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].*/

    public static int[] getArray(int[] arr){

        int lastIndexFour = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4){
                lastIndexFour = i;
            }
        }

        if(lastIndexFour == -1) {
            throw  new RuntimeException("Array doesn't contain number 4");
        }

        return  Arrays.copyOfRange(arr,lastIndexFour + 1, arr.length);


    }

    /*3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).*/

    public static boolean checkContains(int[] array){
        boolean isOne = false;
        boolean isFour = false;

        for (int i = 0; i < array.length; i++) {   //  123456 1114444
            if(array[i] == 1)
                isOne = true;
            else if(array[i] == 4)
                isFour = true;
            else return false;
        }

        return  isOne && isFour;
    }
}
