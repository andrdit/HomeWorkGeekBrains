package practise5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    public boolean isRaceFinish = false;
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() { return stages; }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

}
