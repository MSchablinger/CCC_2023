package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.*;

public class Level2 extends Level {
    public Level2(boolean debug) {
        super(debug);
        this.subLevels = 5;
    }

    @Override
    protected Object solve(List<String> input, int subLevel) {

        int n = Integer.parseInt(input.get(0));

        input = input.subList(1, input.size());

        Set<String> uniqueLines = new HashSet<>();
        Map<String, Integer> lineCount = new HashMap<>();

        for (String line : input) {
            Set<String> rotations = new HashSet<>();
            String[] chars = line.split(",");

            // Erzeugen von Rotationsvarianten der Zeile
            for (int i = 0; i < chars.length; i++) {
                StringBuilder rotation = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (j != chars.length -1) {
                        rotation.append(chars[(i + j) % chars.length]).append(",");
                    } else {
                        rotation.append(chars[(i + j) % chars.length]);
                    }
                }
                rotations.add(rotation.toString());
            }

            // Überprüfen, ob eine der Rotationen bereits in den einzigartigen Zeilen ist
            boolean isNew = true;
            String uniqueLine = "";

            for (String rotation : rotations) {
                if (uniqueLines.contains(rotation)) {
                    isNew = false;
                    uniqueLine = rotation;
                    break;
                }
            }

            // Wenn es eine neue Zeile ist, füge sie zu den einzigartigen Zeilen hinzu
            if (isNew) {
                for (String rotation : rotations) {
                    uniqueLines.add(rotation);
                }
            } else {
                lineCount.put(uniqueLine, lineCount.getOrDefault(uniqueLine, 1) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : lineCount.entrySet()) {
            result.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
        }

        // Ausgabe der Zeilen mit Anzahl
        System.out.println(result.toString());
        return result.toString();
    }
}
