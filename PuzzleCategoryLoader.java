//David Hill    This file loads the first line from a csv file which contains the puzzles categories.
import java.io.*;
import java.util.*;

public class PuzzleCategoryLoader {
    private List<String> categories;
    public PuzzleCategoryLoader(String filePath) {
        categories = new ArrayList<>(); //Creates an arrayList to hold the parsed categories
        loadCategories(filePath); //Fills up the arrayList with the categories
    }
    private void loadCategories(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Reads only the first line of the CSV
                categories = Arrays.asList(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> getCategories() {
        return categories;
    }
    //added by Valerie 2/20 this gets the items for each category
    public String getItemsForCategory(String category) {
        return categories.set(0, category)  ;
    }

}
