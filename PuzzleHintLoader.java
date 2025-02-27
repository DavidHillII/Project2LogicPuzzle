import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleHintLoader {
    private List<String> hints;

    public PuzzleHintLoader(String fileName) {
        hints = new ArrayList<>();
        loadHints(fileName);
    }

    public void loadHints(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    hints.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getHints() {
        return hints;
    }

}
