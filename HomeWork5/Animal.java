package HomeWork5;

/**
1.Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
2.Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
3.У каждого животного есть ограничения на действия
 (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
 плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
4.При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
 (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
5.* Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/
public abstract class Animal {

    protected String name;
    protected int maxDistanceOfRun;
    protected float maxDistanceOfJump;
    protected int maxDistanceOfSwim;

    protected String toRun(int lenght) {
        if(lenght > maxDistanceOfRun){
            return name + "\" не пробежал";
        }else{
            return name + "\" пробежал";
        }
    }
    protected String toSwim(int lenght){
        if(lenght > maxDistanceOfSwim){
            return name + "\" не проплыл";
        }else{
            return name + "\" проплыл";
        }
    }
    protected String toJump(float height){
        if(height > maxDistanceOfJump){
            return name + "\" не прыгнул";
        }else{
            return name + "\" прыгнул";
        }
    }

    protected Animal(String name){
        this.name = name;
    }

    protected Animal(String name, int maxDistanceOfRun, int maxDistanceOfSwim, float maxDistanceOfJump){
        this.name = name;
        this.maxDistanceOfRun  = maxDistanceOfRun;
        this.maxDistanceOfSwim = maxDistanceOfSwim;
        this.maxDistanceOfJump = maxDistanceOfJump;
    }
}
