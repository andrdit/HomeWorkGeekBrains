package HomeWork5;

public class Dog extends Animal {

    public Dog(String name){
        super(name);
        maxDistanceOfRun  = 500;
        maxDistanceOfSwim = 10;
        maxDistanceOfJump = 0.5f;
    }

    protected Dog(String name, int maxDistanceOfRun, int maxDistanceOfSwim, float maxDistanceOfJump){
        super(name, maxDistanceOfRun, maxDistanceOfSwim, maxDistanceOfJump);
    }

    @Override
    protected String toRun(int lenght) {
        return "Песик \"" + super.toRun(lenght) + "!";
    }

    @Override
    protected String toSwim(int lenght) {
        return "Песик \"" + super.toSwim(lenght) + "!";
    }

    @Override
    protected String toJump(float height) {
        return "Песик \"" + super.toJump(height) + "!";
    }
}
