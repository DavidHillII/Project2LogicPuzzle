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
        try (BufferedReader first_Line = new BufferedReader(new FileReader(filePath))) {
            String line_first = first_Line.readLine();  //This will read only the first line of the csv
            if (line_first != null) {
                categories = Arrays.asList(line_first.split(","));
            }
        }   catch (IOException e) {
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
