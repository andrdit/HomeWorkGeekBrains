package HomeWork4;

public class Main {

    public static void main(String[] args) {

        Employee ivanov = new Employee("Ivanov Ivan Ivanovich",
                "Director", "8-812-356-65-00", 100_000, 56);

        Employee petrov = new Employee("Petrov Petr Petrovich",
                "Accountant", "8-812-356-65-01", 70_000, 55);

        Employee vasilyev = new Employee("Vasilyev Vasily Vasilyevich",
                "Designer", "8-812-356-65-02", 50_000, 25);

        Employee kazakov = new Employee("Kazakov Ale[andr Victorovich",
                "Java Programmer", "8-812-356-65-03", 120_000, 41);

        Employee ditkovskii = new Employee("Ditkovskii Andrew Nickolavich",
                "1C Programmer", "8-909-588-66-17", 40_000, 36);

        //Задание 4
        System.out.println(printSecondNameFirstNamePatronymicAndPost(ivanov));
        System.out.println(printSecondNameFirstNamePatronymicAndPost(petrov));
        System.out.println(printSecondNameFirstNamePatronymicAndPost(vasilyev));
        System.out.println(printSecondNameFirstNamePatronymicAndPost(kazakov));
        System.out.println(printSecondNameFirstNamePatronymicAndPost(ditkovskii));

        System.out.println();

        //Задание 5
        Employee[] employeeArray = new Employee[]{ivanov,petrov,vasilyev,kazakov,ditkovskii};
        for(int i = 0; i < employeeArray.length; i++){
            if(employeeArray[i].getAge() > 40) System.out.println(employeeArray[i].getFullInformation());
        }

        System.out.println();

        //Задание 6
        upSalry(employeeArray);
        for(int i = 0; i < employeeArray.length; i++){
            if(employeeArray[i].getAge() > 40) System.out.println(employeeArray[i].getFullInformation());
        }

        System.out.println();

        //Задание 7
        System.out.println(Employee.getCountClassCopy());


    }

    public static String printSecondNameFirstNamePatronymicAndPost(Employee employee){
        return "FIO: " +employee.getSecondNameFirstNamePatronymic() +", Post:"+ employee.getPost();
    }

    public static void upSalry(Employee[] eemployees){
        for(int i = 0; i < eemployees.length; i++){
            if(eemployees[i].getAge() > 45) eemployees[i].setSalary();
        }
    }
}
