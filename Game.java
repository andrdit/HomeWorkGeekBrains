package HomeWork3;

import java.util.Random;
import java.util.Scanner;

/**
 Сделал два метода проверки условия подеды:
 public static boolean checkWhoWinХ3(char symbol) - для поля 3х3
 public static boolean checkWhoWinХ5(char symbol) - для поля 5х5

 выбор условия игры не делал,

 3-ю задачу не делал

 * */

public class Game {

    public static final char CROSS = 'X';
    public static final char ZERO = 'O';
    public static final char EMPTY = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static int sizeX = 5;
    public static int sizeY = 5;

    public static char[][] field = new char[sizeX][sizeY];

    public static void fillField(){
        for(int i = 0; i < sizeY ; i++){
            for(int j = 0; j < sizeX; j++){
                field[i][j] = EMPTY;
            }
        }
    }

    public static void showField(){
        for(int i = 0; i < sizeY ; i++){
            for(int j = 0; j < sizeX; j++){
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanAttempt(){
        int column;
        int string;

        do {
            System.out.println("Введите координаты через Enter (цифры 1..3): ");
            string = scanner.nextInt() - 1;
            column = scanner.nextInt() - 1;
        }while (!isErrorEnter(column, string) || isSetToEnemyZone(column,string));
        field[column][string] = CROSS;
    }

    public static void pcAttempt(){

        int column;
        int string;
        do {
            string = random.nextInt(5);
            column = random.nextInt(5);

        }while (isSetToEnemyZone(column, string));
        field[column][string] = ZERO;
    }

    public static boolean isErrorEnter(int i, int j){
        return i >= 0 && i < sizeX && j >= 0 && j < sizeY;
    }

    public static boolean isSetToEnemyZone(int i, int j){
        return  field[i][j] != EMPTY;
    }

    public static void main(String[] Args){

        fillField();
        showField();

       while (true) {
           humanAttempt();
           if(checkWhoWinХ5(CROSS)) {
               showField();
               System.out.println("Победил человек !!!");
               break;
           }

           if(isfullGameZone()) {
               showField();
               System.out.println("Ничья");
               break;
           }

           showField();
           pcAttempt();
           if(checkWhoWinХ5(ZERO)) {
               showField();
               System.out.println("Победил компьютер !!!");
               break;
           }

           if(isfullGameZone()) {
               showField();
               System.out.println("Ничья");
               break;
           }
           showField();
       }

    }

    public static boolean checkWhoWinХ3(char symbol){

        int counterX = 0;
        int counterY = 0;

        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j <sizeY; j++){
                if(field[i][j] == symbol) counterX++;
                if(field[j][i] == symbol) counterY++;
            }

            if(counterX == sizeX || counterY == sizeY) return true;
            counterX = 0;
            counterY = 0;
        }

        counterX = 0;
        counterY = 0;

        int i, j;
        for (i = 0, j = field.length - 1; i < field.length; i++, j--) {
            if(field[i][j] == symbol) counterX++;
            if(field[i][i] == symbol) counterY++;
        }

        if(counterX == sizeX || counterY == sizeY) return true;

        return false;

    }

    public static boolean checkWhoWinХ5(char symbol){

        int counterX = 0;
        int counterY = 0;

        int counterXX = 0;
        int counterYY = 0;

        for(int i = 0; i < sizeX-1; i++){
            for(int j = 0; j <sizeY-1; j++){
                if(field[i][j] == symbol) counterX++;
                if(field[j][i] == symbol) counterY++;
            }

            if(counterX == sizeX-1 || counterY == sizeY-1) return true;
            counterX = 0;
            counterY = 0;
        }

        counterX = 0;
        counterY = 0;

        for(int i = sizeX-1; i >=1; i--){
            for(int j = sizeY-1; j >=1; j--){
                if(field[i][j] == symbol) counterX++;
                if(field[j][i] == symbol) counterY++;
            }

            if(counterX == sizeX-1 || counterY == sizeY-1) return true;
            counterX = 0;
            counterY = 0;
        }

        counterX = 0;
        counterY = 0;

        for (int i = 0, j = (sizeX - 1); i < sizeX - 1; i++, j--) {
                if (field[i][i] == symbol) counterX++;
                if (field[i][i+1] == symbol) counterY++;

                if (field[i][j] == symbol) counterXX++;
                if (field[i][j-1] == symbol) counterYY++;
        }

        if(counterX == sizeX-1 || counterY == sizeY-1 || counterXX == sizeX-1 || counterYY == sizeY-1) return true;

        counterX = 0;
        counterY = 0;

        counterXX = 0;
        counterYY = 0;

        for (int i = 1, j = (sizeX - 2); i < sizeX; i++, j--) {
            if (field[i][i] == symbol) counterX++;
            if (field[i][i-1] == symbol) counterY++;

            if (field[i][j] == symbol) counterXX++;
            if (field[i][j+1] == symbol) counterYY++;
        }

        if(counterX == sizeX-1 || counterY == sizeY-1 || counterXX == sizeX-1 || counterYY == sizeY-1) return true;

        return false;

    }

    public static boolean isfullGameZone(){
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                if(field[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


}
