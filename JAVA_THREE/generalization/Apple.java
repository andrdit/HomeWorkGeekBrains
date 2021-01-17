package generalization;

public class Apple extends Fruit {

    Apple(Float w){
        super(w);
    }

    @Override
    public String toString() {
        return "Apple with weight = " + getWeight();
    }
}
