package generalization;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> storage;
    private float maxWeight;
    private float commonWeight;

    Box(){
        storage = new ArrayList<>();
    }

    Box(float maxWeight){
        storage = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addFruit(T fruit){

        float temp = 0;
        float currentWeight = commonWeight + fruit.getWeight();

        if(maxWeight < currentWeight){
            System.out.println(String.format("Can't add to box. Common weight: %f, max weigt: %f", currentWeight, maxWeight));
            return;
        }

        storage.add(fruit);
        commonWeight = currentWeight;
    }

    public void addArrayFruit(T... fruits){
        storage.addAll(new ArrayList<>(Arrays.asList(fruits)));
    }

    public <T> ArrayList getStorage(){
        return storage;
    }

    public float getWeight(){
        float weight = 0.0f;

        for (int i = 0; i < storage.size(); i++) {
            weight = weight + storage.get(i).getWeight();
        }

        return weight;
    }

    public void pourToAnotherBox(Box<T> anotherBox){
        anotherBox.storage.addAll(this.storage);
        this.storage.clear();
    }

    public void pourToAnotherBoxWithControlMaxWeight(Box<T> anotherBox){

        if(anotherBox.maxWeight < this.commonWeight){
            System.out.println(String.format("Can't pour to another box. Current weight: %f, max weigt anotrher box: %f", commonWeight, anotherBox.maxWeight));
            return;
        }
        anotherBox.storage.addAll(this.storage);
        this.storage.clear();
    }

    public Boolean compare(Box anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }
}
