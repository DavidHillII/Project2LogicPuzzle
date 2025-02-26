// David Hill - Loads the first line as headers and the following rows into separate lists.
import java.io.*;
import java.util.*;

public class PuzzleCategoryLoader {
    private List<String> headers; //Storage for the main categories of your logic puzzle
    private List<String> categories_1; //Storage for the subjects of your first header
    private List<String> categories_2; //Storage for the subjects of your second header
    private List<String> categories_3; //Storage for the subjects of your third header
    private List<String> categories_4; //Storage for the subjects of your fourth header

    public PuzzleCategoryLoader(String filePath) {
        headers = new ArrayList<>();
        categories_1 = new ArrayList<>(); //ArrayList for the subjects of your first header
        categories_2 = new ArrayList<>(); //ArrayList for the subjects of your second header
        categories_3 = new ArrayList<>(); //ArrayList for the subjects of your third header
        categories_4 = new ArrayList<>(); //ArrayList for the subjects of your fourth header
        loadCategories(filePath); //Loads the file
    }

    public void loadCategories(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) { //Creates a scanner for your file and in a try catch attempt to read the file.
            if (scanner.hasNextLine()) { //if there is a next line have the scanner interpret it
                headers = Arrays.asList(scanner.nextLine().split(",")); // Load the first row as headers
            }

            while (scanner.hasNextLine()) { // Load each of the next rows into separate ArrayLists
                String[] different_Categories = scanner.nextLine().split(","); //Grabs the next line full the first item in each category and splits it at the comma, while storing it in a list of strings.
                if (different_Categories.length >= 4) {
                    categories_1.add(different_Categories[0]); //Grabs the first index and stores it in the arraylist
                    categories_2.add(different_Categories[1]); //Grabs the second index and stores it in the arraylist
                    categories_3.add(different_Categories[2]); //Grabs the third index and stores it in the arraylist
                    categories_4.add(different_Categories[3]); //Grabs the fourth index and stores it in the arraylist
                }
            }
        } catch (IOException e) { //Catches any possible I/O errors to avoid a warning
            e.printStackTrace(); //print stack trace
        }
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<String> getCategory1() {
        return categories_1;
    }

    public List<String> getCategory2() {
        return categories_2;
    }

    public List<String> getCategory3() {
        return categories_3;
    }

    public List<String> getCategory4() {
        return categories_4;
    }
    // Returns the list of items for the given category
    public List<String> getItemsForCategory(String category) {
        int index = headers.indexOf(category);
        switch (index) {
            case 0:
                return categories_1;
            case 1:
                return categories_2;
            case 2:
                return categories_3;
            case 3:
                return categories_4;
            default:
                return new ArrayList<>();
        }
    }
}