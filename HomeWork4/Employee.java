package HomeWork4;

/**
 1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
 2. Конструктор класса должен заполнять эти поля при создании объекта;
 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
 4. Вывести при помощи методов из пункта 3 ФИО и должность.
 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000;
 7. ** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
 **/
public class Employee {

    private String secondNameFirstNamePatronymic;
    private String post;
    private String phoneNumber;
    private int salary;
    private int age;

    private static int countClassCopy;

    public Employee(String secondNameFirstNamePatronymic, String post, String phoneNumber, int salary, int age){

        this.secondNameFirstNamePatronymic = secondNameFirstNamePatronymic;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

        countClassCopy++;
    }

    //getters
    public String getSecondNameFirstNamePatronymic() {
        return secondNameFirstNamePatronymic;
    }

    public String getPost() {
        return post;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public static int getCountClassCopy() {
        return countClassCopy;
    }

    public String getFullInformation(){
        return "FIO:" + secondNameFirstNamePatronymic + ", post: " + post + ", phone number: " + phoneNumber + ", salary: " + salary + ", age:" + age;
    }

    public void setSalary() {
        this.salary += 5000;
    }


}
