import java.io.*;
import java.util.*;

public class PuzzleCategoryLoader {
    private Map<String, List<String>> categories;
    public PuzzleCategoryLoader(String filePath) {
        categories = new HashMap<>();
        loadCategories(filePath);
    }


}
