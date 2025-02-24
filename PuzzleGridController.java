//David Hill very unfinished just some ideas based on what you sent me
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.*;

public class PuzzleGridController {
    @FXML private GridPane gridPane;
    protected PuzzleCategoryLoader categoryLoader;
    protected PuzzleDataLoader dataLoader;
    private List<Button> moveHistory = new ArrayList<>();
    private List<String[]> buttonPairs = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();

    public PuzzleGridController(String categoryFile, String dataFile) {
        categoryLoader = new PuzzleCategoryLoader(categoryFile);
        dataLoader = new PuzzleDataLoader(dataFile);
        initialize();
    }

    private void initialize() {
        categoryLoader.loadCategories(PuzzleCategories.csv);
        dataLoader.loadCSV("PuzzleSolutions.csv");
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
                buttonPairs.add(new String[]{rowItem, colItem});
                buttons.add(cellButton);
                cellButton.setOnAction(e -> toggleCell(cellButton, rowItem, colItem));
                gridPane.add(cellButton, col + 1, row + 1);
            }
        }
    }

    private void toggleCell(Button button, String rowItem, String colItem) {
        if (dataLoader.isCorrectPair(rowItem, colItem)) {
            button.setStyle("-fx-background-color: green;");
            button.setText("✓");
        } else {
            button.setStyle("-fx-background-color: red;");
            button.setText("X");
        }
        moveHistory.add(button);
    }

    public void undoLastMove() {
        if (!moveHistory.isEmpty()) {
            Button lastMove = moveHistory.remove(moveHistory.size() - 1);
            lastMove.setStyle("");
            lastMove.setText(" ");
        }
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

