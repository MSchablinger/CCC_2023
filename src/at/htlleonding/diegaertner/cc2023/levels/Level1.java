package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level1 extends Level {
    public Level1(boolean debug) {
        super(debug);
        this.subLevels = 5;
    }

    @Override
    protected Object solve(List<String> input, int subLevel) {
        input.remove(0);
        Map<String, Integer> lineCount = new HashMap<>();
        for (String line : input) {
            lineCount.put(line, lineCount.getOrDefault(line, 0) + 1);
        }
        String result = "";
        for (Map.Entry<String, Integer> entry : lineCount.entrySet()) {

            System.out.println(entry.getValue() + " " + entry.getKey());
            result += entry.getValue() + " " + entry.getKey() + "\n";
        }
        return result;
    }
}
