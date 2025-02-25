// David Hill - Loads the first line as headers and the following rows into separate lists.
import java.io.*;
import java.util.*;

public class PuzzleCategoryLoader {
    private List<String> headers;
    private List<String> categories_1;
    private List<String> categories_2;
    private List<String> categories_3;
    private List<String> categories_4;

    public PuzzleCategoryLoader(String filePath) {
        headers = new ArrayList<>();
        categories_1 = new ArrayList<>();
        categories_2 = new ArrayList<>();
        categories_3 = new ArrayList<>();
        categories_4 = new ArrayList<>();
        loadCategories(filePath);
    }

    public void loadCategories(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
                // Load the first row as headers
                headers = Arrays.asList(scanner.nextLine().split(","));
            }

            // Load each of the next rows into separate ArrayLists
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(",");
                if (items.length >= 4) { // Ensure we have enough columns
                    categories_1.add(items[0]);
                    categories_2.add(items[1]);
                    categories_3.add(items[2]);
                    categories_4.add(items[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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