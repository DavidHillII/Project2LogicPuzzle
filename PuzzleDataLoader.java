import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleDataLoader {
    private List<String> correctPairs = new ArrayList<>();

    public PuzzleDataLoader(String fileName) {
        loadCSV(fileName);
    }

    public void loadCSV(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Trim whitespace
                String[] pair = line.split(",");

                if (pair.length == 2) {
                    String item1 = pair[0].trim();
                    String item2 = pair[1].trim();
                    correctPairs.add(item1 + "," + item2);
                    correctPairs.add(item2 + "," + item1); // Ensure reverse order lookup
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCorrectPair(String item1, String item2) {
        if (item1 == null || item2 == null) return false;
        String pair1 = item1.trim() + "," + item2.trim();
        String pair2 = item2.trim() + "," + item1.trim();
        return correctPairs.contains(pair1) || correctPairs.contains(pair2);
    }

    public List<String> getCorrectPairs() {
        return correctPairs;
    }
}