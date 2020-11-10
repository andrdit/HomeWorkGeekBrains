/**
  1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
  2.Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
  3.*Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
  4.** Написать метод, проверяющий, есть ли указанное слово в папке, внутри есть файлы,
       в которых может содержатся это слово (данная тема преднамеренно не рассказывалась,
       поэтому надо погуглить (Гуглить - тоже надо уметь правильно).
       При чем не просто найти решение и списать, а именно сформулировать проблему. Пока вы будете формулировать проблему - вы найдете 50% решения)
 */



package HomeWork6;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StringBuilder wayToDirectory = new StringBuilder();
    static File directory;
    static final String FILENAME1 = "file1.txt";
    static final String FILENAME2 = "file2.txt";


    public static void main(String[] args){
 /** 1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);*/
    createFiles(FILENAME1, TextForFiles.TEXT1);
    createFiles(FILENAME2, TextForFiles.TEXT2);

        File[] arrayFiles = {new File(FILENAME1), new File(FILENAME2)};


 /**2.Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.*/
   //     toGlueFiles(arrayFiles);

 /** 3.*Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.*/
   //  checkWordInFile(arrayFiles);

 /** 4.** Написать метод, проверяющий, есть ли указанное слово в папке*/
   //     checkWordInFileInDirectory();
    }

    public static void createFiles(String nameOfFile, String textOfFile){
        try {
            FileOutputStream fos = new FileOutputStream(nameOfFile);
            PrintStream ps = new PrintStream(fos);
            byte[] b = textOfFile.getBytes();
            fos.write(b);
            ps.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void toGlueFiles(File[] files){

        StringBuilder commonText = new StringBuilder();

        for (int i = 0; i < files.length; i++) {
            if(!isFileTxt(files[i]))
               continue;
            commonText.append(readTextFromFile(files[i]));
            commonText.append("\n\n");
        }

        System.out.println(commonText.toString());
    }

    public static String readTextFromFile(File files) {

        StringBuilder readText = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(files);
            InputStreamReader is = new InputStreamReader(fis, "UTF-8");

            int singleCharFile;

            while ((singleCharFile = is.read()) != -1) {
                readText.append((char) singleCharFile);
            }
            is.close();
            fis.close();

        } catch (IOException exception) {
            System.out.println("Error read file: " + exception.getMessage());
        }

        return readText.toString();
    }

    public static Boolean isFileTxt(File file){
        return file.getName().endsWith(".txt");
    }

    public static void checkWordInFile(File[] files) {

        StringBuilder enteredWord = new StringBuilder();
        StringBuilder textFromFile = new StringBuilder();
        StringBuilder answerUser = new StringBuilder();

        int num;

        System.out.println("Доступные файлы:");
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + "." + files[i].getName());
        }
        System.out.println();

        System.out.println("Выберите файл для проверки. Введите число от 0 до " + (files.length - 1));
        num = scanner.nextInt();

        textFromFile.append(readTextFromFile(files[num]));
        System.out.println(textFromFile.toString());


        System.out.print("Введите слово для поиска: ");
        enteredWord.append(scanner.next());

        if (textFromFile.toString().contains(enteredWord)) {
            System.out.println("Слово \"" + enteredWord.toString() + "\" содержится в файле \"" + files[num].getName() + "\"");
        } else {
            System.out.println("Слово \"" + enteredWord.toString() + "\" не найдено в файле \"" + files[num].getName() + "\"");
        }

    }

    public static void checkWordInFileInDirectory() {

        StringBuilder enteredWord = new StringBuilder();
        StringBuilder textFromFile = new StringBuilder();

        directory = new File(System.getProperty("user.dir"));

        System.out.print("Введите слово для поиска: ");
        enteredWord.append(scanner.next());

        for (int i = 0; i < directory.listFiles().length; i++) {
            if(!isFileTxt(directory.listFiles()[i]))
                continue;

            textFromFile.append(readTextFromFile(directory.listFiles()[i]));

            if (textFromFile.toString().contains(enteredWord)) {
                System.out.println("Слово \"" + enteredWord.toString() + "\" содержится в файле \"" + directory.listFiles()[i].getName() + "\"");
            } else {
                System.out.println("Слово \"" + enteredWord.toString() + "\" не найдено в файле \"" + directory.listFiles()[i].getName() + "\"");
            }

            textFromFile.setLength(0);
        }

    }

}
