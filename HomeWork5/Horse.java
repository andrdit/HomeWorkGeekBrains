package HomeWork5;

public class Horse extends Animal{

    public Horse(String name){
        super(name);
        maxDistanceOfRun  = 1500;
        maxDistanceOfSwim = 100;
        maxDistanceOfJump = 3f;
    }

    protected Horse(String name, int maxDistanceOfRun, int maxDistanceOfSwim, float maxDistanceOfJump){
        super(name, maxDistanceOfRun, maxDistanceOfSwim, maxDistanceOfJump);
    }

    @Override
    protected String toRun(int lenght) {
        return "Лошадка \"" + super.toRun(lenght) + "а!";
    }

    @Override
    protected String toSwim(int lenght) {
        return "Лошадка \"" + super.toSwim(lenght) + "а!";
    }

    @Override
    protected String toJump(float height) {
        return "Лошадка \"" + super.toJump(height) + "а!";
    }
}
