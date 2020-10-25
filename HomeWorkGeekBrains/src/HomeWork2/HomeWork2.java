/**
 * 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
 * 2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
 * 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
 * 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
 * 5 ^ Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
 * 6 ^^ Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
 * checkBalance([1, 1, 1, || 2, 1]) → true,
 * checkBalance ([2, 1, 1, 2, 1]) → false,
 * checkBalance ([10, || 1, 2, 3, 4]) → true.
 * Абстрактная граница показана символами ||, эти символы в массив не входят.
 * 7 ^^^ Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
 * [1,2,3,4,5], -2 => [3,4,5,1,2]
 * [1,2,3,4,5], 2 => [4,5,1,2,3]
 * 8 ^^^^ Не пользоваться вспомогательным массивом при решении задачи 7.
 * Задание по хардкору. Нужен метод, который получает в параметры 2 массива (разной длины) int-чисел. Он (метод) должен вернуть массив значений, которые есть в 1 массиве, но их нет во втором
 * Задание комбо-хардкор: необходимо проверить, что первый двухмерный массив является подмассивом второго двухмерного массива, которые подаются в метод
 */

package HomeWork2;

import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {

    public static void main(String[] args){

        Random random = new Random();

/**        * 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;*/
//        int[] array = new int[10];
//         //заполнить массив числами 0 и 1 в случайном порядке
//        for (int i = 0; i < 10;i++){
//            array[i] = (int)(random.nextDouble() * 2);
//        }
//        reverse(array);

/**        * 2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;*/
//        int[] array = new int[8];
//        fillArr(array);

//        * 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
//        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        multSomeElementArray(array);

/**        * 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;*/
//        int[] array = {5,-15,100,-55,20,-5,-80,45,25,-10};
//        showArray(array);
//        System.out.println("Минимальное значение в массиве: " + getMinValue(array));
//        System.out.println("Максимальное значение в массиве: " + getMaxValue(array));
//        showArray(array);

/**        * 5 ^ Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);*/
//        int[][] array = new int[10][10];
//
//        int stringNum = 0;
//        int columnNum = 0;
//        int columnNum1 = array.length -1;
//
//        while (stringNum < array.length){
//
//            array[stringNum][columnNum] = 1;
//            array[stringNum][columnNum1] = 1;
//
//            stringNum++;
//            columnNum++;
//            columnNum1--;
//        }
//
//        showSquareArray(array);

 /**       * 6 ^^ Написать метод, в который передается не пустой одномерный целочисленный массив,
  метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
  checkBalance([1, 1, 1, || 2, 1]) → true,
  checkBalance ([2, 1, 1, 2, 1]) → false,
  checkBalance ([10, || 1, 2, 3, 4]) → true.
  Абстрактная граница показана символами ||, эти символы в массив не входят.*/
//        int[] array = {1, 1, 1, (int)('|'+'|'), 2, 1};
//       // int[] array = {2, 1, 1, 2, 1};
//       // int[] array = {10, (int)('|'+'|'), 1, 2, 3, 4};
//        System.out.println(checkBalance(array));

 /**       7 ^^^ Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
  * при этом метод должен циклически сместить все элементы массива на n позиций.
  [1,2,3,4,5], -2 => [3,4,5,1,2]
  [1,2,3,4,5], 2 => [4,5,1,2,3]*/
//        int[] array = {1,2,3,4,5,6,7,8,9,10};
//        int n = -0;
//        displacementElements(array, n);


    }

    public static void reverse(int[] arr){

        showArray(arr);

        System.out.println();

        //поменять значение с 0 на 1, с 1 на 0
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                arr[i] = 0;
            }else {
                arr[i] = 1;
            }
        }

        showArray(arr);
    }

    public static void fillArr(int[] arr){

        int y = 1;

        for (int i = 0; i < arr.length; i++){
            arr[i] = y;
            y+=3;
        }

        showArray(arr);
    }

    public static void multSomeElementArray(int[] arr){

        showArray(arr);

        for(int i = 0; i < arr.length; i++){

            if(arr[i] < 6)
                arr[i] *= 2;
        }

        showArray(arr);

    }

    public static void showArray(int[] arr){
        //вывести полученный массив
        for (int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void showSquareArray(int[][] arr){
        //вывести полученный массив
        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int getMinValue(int[] arr){
        qSort(arr, 0, arr.length -1);
        return arr[0];
    }

    public static int getMaxValue(int[] arr){
        qSort(arr, 0, arr.length -1);
        return arr[arr.length - 1];
    }

    public static void qSort (int[] array, int b, int e){
        //использовал алгоритм быстрой сортировки
        int tmp = 0;

        int l = b;
        int r = e;

        int piv = array[(l + r) / 2]; // Опорным элементом для примера возьмём средний
        while (l <= r)
        {
            while (array[l] < piv)
                l++;
            while (array[r] > piv)
                r--;
            if (l <= r) {
                tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
                l++;
                r--;
            }
        }
        if (b < r)
            qSort(array, b, r);
        if (e > l)
            qSort (array, l, e);
    }

    public static Boolean checkBalance(int[] array){

        showArray(array); //показать массив

        int lengthLeft  = 0; //длинна левой части
        int lengthRight = 0; //длинна правой части
        int sumthLeft  = 0;  //сумма элементов левой части
        int sumRight = 0;    //сумма элементов правой части

        //определим длинну левой части
        for(int i =0; i < array.length; i++){
            if(array[i] != (int)('|'+'|')) {
                lengthLeft++;
            }else {
                break;
            }
        }
        //определим длинну правой части
        lengthRight = array.length - lengthLeft -1;

        //если одна из частей равна всему массиву, тогда вернуть false
        if(lengthLeft == -1 || lengthRight == -1){
            return false;
        }

        //задать левую и правую часть
        int[] arrLeft = new int[lengthLeft];
        int[] arrRight = new int[lengthRight];

        //заполнить левую часть, посчитать сумму элементов
        for(int j = 0; j < lengthLeft; j++) {

            arrLeft[j] = array[j];
            sumthLeft +=  arrLeft[j];
        }

        //заполнить правую часть, посчитать сумму элементов
        for(int j = 0; j < lengthRight; j++) {

            arrRight[j] = array[lengthLeft + 1 + j];
            sumRight += arrRight[j];
        }

        //сравнить суммы элемнтов левой и правой частей
        if(sumthLeft == sumRight){
            return true;
        }
        return false;
    }

    public static void displacementElements(int[] array, int n){

        if(n > array.length || n * (-1) > array.length){
            System.out.println("n or -n is more than a length of Array");
            return;
        }

        int[] arr = n > 0 ? new int[n]:new int[n*(-1)];

        if(n > 0){

            int j = 0;
            for (int i = array.length - n; i < array.length; i++){
                arr[j] = array[i];
                j++;
            }

            for (int i = array.length -1 - n; i >=0; i--){
                array[i + n] = array[i];
            }

            for (int i = 0; i < n; i++){
                array[i] = arr[i];
            }
        }else if(n == 0){
            System.out.println("n = 0, nothing to do");
            return;
        }else{

            n *= -1;
            int j = 0;
            for (int i = 0; i < n; i++){
                arr[j] = array[i];
                j++;
            }

            for (int i = 0; i < array.length - n; i++){
                array[i] = array[i + n];
            }

            int k = 0;
            for (int i = array.length - n; i < array.length; i++){
                array[i] = arr[k];
                k++;
            }
        }

        showArray(arr);
        showArray(array);
    }


}
