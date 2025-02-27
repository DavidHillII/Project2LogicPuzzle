// David Hill, Valerie - Game Controller class for the UI Grid
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.*;

public class PuzzleGridController {
    @FXML
    private GridPane puzzle_grid;

    // Header labels
    @FXML private Label header_1, header_2, header_3, header_4;

    // Category labels
    @FXML private Label label_1, label_2, label_3, label_4;
    @FXML private Label label_5, label_6, label_7, label_8;
    @FXML private Label label_9, label_10, label_11, label_12;
    @FXML private Label label_13, label_14, label_15, label_16;

    // Buttons for grid interaction
    @FXML private Button hints, clear_errors, clues, start_over;

    // Text areas for displaying hints and clues
    @FXML private TextArea hints_text, clues_text;

    // Loaders for different data components
    protected PuzzleCategoryLoader categoryLoader;
    protected PuzzleDataLoader dataLoader;
    protected PuzzleCluesLoader clueLoader;

    private List<Button> moveHistory = new ArrayList<>(); // Stores move history
    //private List<String[]> buttonPairs = new ArrayList<>(); // Stores correct button pairs
    private List<Button> buttons = new ArrayList<>(); // Stores all buttons

    public PuzzleGridController() {
        // Empty constructor - JavaFX will call @FXML initialize()
    }

    @FXML
    private void initialize() {
        categoryLoader = new PuzzleCategoryLoader("PuzzleCategories.csv");
        dataLoader = new PuzzleDataLoader("PuzzleSolutions.csv");
        clueLoader = new PuzzleCluesLoader("PuzzleClues.csv");

        categoryLoader.loadCategories("PuzzleCategories.csv");
        dataLoader.loadCSV("PuzzleSolutions.csv");
        clueLoader.loadClues("PuzzleClues.csv");

        // Debug: Check if headers are loaded
        List<String> headers = categoryLoader.getHeaders();
        System.out.println("Headers: " + headers); // Print headers to console

        if (headers.size() >= 4) {
            header_1.setText(headers.get(0));
            header_2.setText(headers.get(1));
            header_3.setText(headers.get(2));
            header_4.setText(headers.get(3));
        } else {
            System.out.println("Not enough headers found!");
        }

        // Debug: Check if categories are loaded correctly
        List<String> category1 = categoryLoader.getCategory1();
        List<String> category2 = categoryLoader.getCategory2();
        List<String> category3 = categoryLoader.getCategory3();
        List<String> category4 = categoryLoader.getCategory4();

        System.out.println("Category 1: " + category1);
        System.out.println("Category 2: " + category2);
        System.out.println("Category 3: " + category3);
        System.out.println("Category 4: " + category4);

        List<Label> categoryLabels = Arrays.asList(label_1, label_2, label_3, label_4,
                label_5, label_6, label_7, label_8,
                label_9, label_10, label_11, label_12,
                label_13, label_14, label_15, label_16);

        int index = 0;
        for (int i = 0; i < category1.size() && index < categoryLabels.size(); i++) {
            categoryLabels.get(index++).setText(category1.get(i));
            categoryLabels.get(index++).setText(category2.get(i));
            categoryLabels.get(index++).setText(category3.get(i));
            categoryLabels.get(index++).setText(category4.get(i));
        }

        System.out.println("Headers and categories successfully loaded.");
        
        // Example call to toggleCell method
        // Assuming you have a button and row/column items to pass
        Button exampleButton = new Button();
        buttons.add(exampleButton); // Add to buttons list for clearGrid and clearErrors methods
        toggleCell(exampleButton, "exampleRowItem", "exampleColItem");
    }




    private void toggleCell(Button button, String rowItem, String colItem) {
        if (dataLoader.isCorrectPair(rowItem, colItem)) {
            button.setStyle("-fx-background-color: green;");
            button.setText("O");
        } else {
            button.setStyle("-fx-background-color: red;");
            button.setText("X");
        }
        moveHistory.add(button);
    }

    public void clearErrors() {
        for (Button button : buttons) {
            if (button.getText().equals("X")) {
                button.setStyle("");
                button.setText(" ");
            }
        }
    }

    public void clearGrid() {
        for (Button button : buttons) {
            button.setStyle("");
            button.setText(" ");
        }
        moveHistory.clear();
    }
}
