package HomeWork5;

public class Bird extends Animal{

    public Bird(String name){
        super(name);
        maxDistanceOfRun  = 5;
        maxDistanceOfSwim = 0;
        maxDistanceOfJump = 0.2f;
    }

    protected Bird(String name, int maxDistanceOfRun, float maxDistanceOfJump){
        super(name, maxDistanceOfRun, 0, maxDistanceOfJump);
    }

    @Override
    protected String toRun(int lenght) {
        return "Птичка \"" + super.toRun(lenght) + "а!";
    }

    @Override
    protected String toJump(float height) {
        return "Птичка \"" + super.toJump(height) + "а!";
    }
}
