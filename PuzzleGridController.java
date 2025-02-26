//David Hill Valerie Game Controller class for the UI Grid
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PuzzleGridController {
    @FXML
    private GridPane gridPane;
    @FXML
    private ResourceBundle resources;

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
        gridPane.getChildren().clear();
        List<String> rowLabels = categoryLoader.getItemsForCategory("Rows");
        List<String> colLabels = categoryLoader.getItemsForCategory("Columns");
        for (int col = 0; col < colLabels.size(); col++) {
            Button label = new Button(colLabels.get(col));
            label.setDisable(true);
            gridPane.add(label, col + 1, 0);
        }

        for (int row = 0; row < rowLabels.size(); row++) {
            Button label = new Button(rowLabels.get(row));
            label.setDisable(true);
            gridPane.add(label, 0, row + 1);
            for (int col = 0; col < colLabels.size(); col++) {
                Button cellButton = new Button(" ");
                final String rowItem = rowLabels.get(row);
                final String colItem = colLabels.get(col);
                buttonPairs.add(new String[] { rowItem, colItem });
                buttons.add(cellButton);
                cellButton.setOnAction(e -> toggleCell(cellButton, rowItem, colItem));
                gridPane.add(cellButton, col + 1, row + 1);
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
