//David Hill Valerie Game Controller class for the UI Grid
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PuzzleGridController {
    @FXML
    private GridPane puzzle_grid;
    @FXML
    private ResourceBundle resources;
    @FXML private Label header_1, header_2, header_3, header_4;
    @FXML private Label label_1,label_2,label_3,label_4,label_5,label_6,label_7;
    @FXML private Label label_8,label_9,label_10,label_11,label_12,label_13,label_14,label_15,label_16;
    @FXML private List <Button> button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,
    button_9,button_10,button_11,button_12,button_13,button_14,button_15,button_16,
    button_17,button_18,button_19,button_20,button_21,button_22,button_23,button_24,
    button_25,button_26,button_27,button_28,button_29,button_30,button_31,button_32,
    button_33,button_34,button_35,button_36,button_37,button_38,button_39,button_40,
    button_41,button_42,button_43,button_44,button_45,button_46,button_47,button_48;
    @FXML private Button hints, undo, clear_errors, clues, start_over ;
    @FXML private TextArea hints_text,clues_text;

    @FXML
    private URL location;
    protected PuzzleCategoryLoader categoryLoader; //makes a category loader
    protected PuzzleDataLoader dataLoader; //makes a data loader
    protected PuzzleCluesLoader clueLoader; //makes a clue loader
    protected PuzzleHintLoader hintLoader; //makes a hint loader
    private List<Button> moveHistory = new ArrayList<>(); //makes a list of buttons that hold move history of the player
    private List<String[]> buttonPairs = new ArrayList<>(); //makes a list of the correct button pairs
    private List<Button> buttons = new ArrayList<>(); //makes a list of all the buttons

    public PuzzleGridController(String categoryFile, String dataFile, String clueFile, String hintFile) {
        categoryLoader = new PuzzleCategoryLoader(categoryFile);
        dataLoader = new PuzzleDataLoader(dataFile);
        clueLoader = new PuzzleCluesLoader(clueFile);
        initialize();
    }

    private void initialize() {
        categoryLoader.loadCategories("PuzzleCategories.csv");
        dataLoader.loadCSV("PuzzleSolutions.csv");
        clueLoader.loadClues("PuzzleClues.csv");
        // this is
        // hint =loader.loadHints("CSVHints.txt");
        setupGrid();
    }

    private void setupGrid() {
        puzzle_grid.getChildren().clear();
        List<String> rowLabels = categoryLoader.getItemsForCategory("Rows");
        List<String> colLabels = categoryLoader.getItemsForCategory("Columns");
        for (int col = 0; col < colLabels.size(); col++) {
            Button label = new Button(colLabels.get(col));
            label.setDisable(true);
            puzzle_grid.add(label, col + 1, 0);
        }

        for (int row = 0; row < rowLabels.size(); row++) {
            Button label = new Button(rowLabels.get(row));
            label.setDisable(true);
            puzzle_grid.add(label, 0, row + 1);
            for (int col = 0; col < colLabels.size(); col++) {
                Button cellButton = new Button(" ");
                final String rowItem = rowLabels.get(row);
                final String colItem = colLabels.get(col);
                buttonPairs.add(new String[] { rowItem, colItem });
                buttons.add(cellButton);
                cellButton.setOnAction(e -> toggleCell(cellButton, rowItem, colItem));
                puzzle_grid.add(cellButton, col + 1, row + 1);
            }
        }
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
