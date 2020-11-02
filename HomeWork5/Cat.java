package HomeWork5;

public class Cat extends Animal {

    public Cat(String name){
        super(name);
        maxDistanceOfRun  = 200;
        maxDistanceOfSwim = 0;
        maxDistanceOfJump = 2f;
    }

    protected Cat(String name, int maxDistanceOfRun, float maxDistanceOfJump){
        super(name, maxDistanceOfRun, 0, maxDistanceOfJump);
    }

    @Override
    protected String toRun(int lenght) {
        return "Кот \"" + super.toRun(lenght) + "!";
    }

    @Override
    protected String toJump(float height) {
        return "Кот \"" + super.toJump(height) + "!";
    }
}
