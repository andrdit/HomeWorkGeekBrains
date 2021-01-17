package generalization;

public class Orange extends Fruit {

    Orange(Float w){
        super(w);
    }

    @Override
    public String toString() {
        return "Orange with weight = " + getWeight();
    }
}
