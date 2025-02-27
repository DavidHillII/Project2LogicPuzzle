//David and Anthony A loader the hints from the csv file
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleHintLoader {
    private List<String> hints; // prepares an ArrayList for the hints
    private int currentHintIndex; //index for current hint

    public PuzzleHintLoader(String fileName) {
        hints = new ArrayList<>(); // creates an ArrayList for the hints
        loadHints(fileName); //loads the csv file into the function
        currentHintIndex = 0; //sets index to 0
    }

    public void loadHints(String fileName) { // Main function for the hint loader
        try (Scanner scanner = new Scanner(new File(fileName))) { //trys a scanner to read the csv file
            while (scanner.hasNextLine()) { // While the scanner has the next line loop and store that line in a string
                String line = scanner.nextLine().trim(); // Store and trim the string
                if (!line.isEmpty()) { // If there is content in the string store it in the arrayList
                    hints.add(line);
                }
            }
        } catch (IOException e) { //Catches any possible I/O errors to avoid a warning
            e.printStackTrace();
        }
    }

    public List<String> getHints() { //getter for the hints arrayList
        return hints;
    }

    public String getNextHint() {
        if (currentHintIndex < hints.size()) { // find if there is more hints
            return hints.get(currentHintIndex++); //if there is return the next hint
        } else {
            return "No more hints available!";
        }
    }

}
