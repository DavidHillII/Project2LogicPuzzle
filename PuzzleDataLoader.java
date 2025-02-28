// Valerie, the PuzzleDataLoader class is used to load the data from the CSV file. The class has a method called isCorrectPair that checks if two items are a correct pair. The class also has a method called getCorrectPairs that returns a list of correct pairs. The class has a constructor that takes a file name as an argument and loads the data from the CSV file. The class has a method called loadCSV that reads the data from the CSV file and stores it in a list. The class has a field

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleDataLoader {
    private List<String> correctPairs = new ArrayList<>();//List to store correct pairs

    //PuzzleDataLoader constructor takes a file name as an argument and loads the data from the CSV file
    public PuzzleDataLoader(String fileName) {
        loadCSV(fileName);
    }
    //loadCSV method reads the data from the CSV file and stores it in a list
    public void loadCSV(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) { // Open file
            while (scanner.hasNextLine()) { // Read line by line
                String line = scanner.nextLine().trim(); // Trim whitespace
                String[] pair = line.split(","); // Split by comma

                if (pair.length == 2) {
                    String item1 = pair[0].trim();// Trim whitespace
                    String item2 = pair[1].trim();
                    correctPairs.add(item1 + "," + item2);// Add to list
                    correctPairs.add(item2 + "," + item1); // Ensure reverse order lookup
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //isCorrectPair method checks if two items are a correct pair
    public boolean isCorrectPair(String item1, String item2) {
        if (item1 == null || item2 == null) return false; // Check for null values
        String pair1 = item1.trim() + "," + item2.trim(); // Trim whitespace
        String pair2 = item2.trim() + "," + item1.trim(); // Ensure reverse order lookup
        return correctPairs.contains(pair1) || correctPairs.contains(pair2); // Check if pair exists
    }
    //getCorrectPairs method returns a list of correct pairs
    public List<String> getCorrectPairs() {
        return correctPairs;
    }
}
