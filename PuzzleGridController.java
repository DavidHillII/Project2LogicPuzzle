// David Hill, Valerie - Game Controller class for the UI Grid
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.*;

public class PuzzleGridController { //controller class for bindings and displaying items onto gui
    @FXML
    private GridPane puzzle_grid; //gridpan for gui

    @FXML private Label header_1, header_2, header_3, header_4; // Header labels for gui
    @FXML private Label label_1, label_2, label_3, label_4; // Category labels for gui
    @FXML private Label label_5, label_6, label_7, label_8;
    @FXML private Label label_9, label_10, label_11, label_12;
    @FXML private Label label_13, label_14, label_15, label_16;

    @FXML private Button hints, clear_errors, clues, start_over; // Buttons for grid interaction in gui
    @FXML private Button button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,
    button_9,button_10,button_11,button_12,button_13,button_14,button_15,button_16,
    button_17,button_18,button_19,button_20,button_21,button_22,button_23,button_24,
    button_25,button_26,button_27,button_28,button_29,button_30,button_31,button_32,
    button_33,button_34,button_35,button_36,button_37,button_38,button_39,button_40,
    button_41,button_42,button_43,button_44,button_45,button_46,button_47,button_48;

    @FXML private TextArea hints_text, clues_text; // Text areas for displaying hints and clues in gui


    protected PuzzleCategoryLoader categoryLoader; // Loader for category data components
    protected PuzzleDataLoader dataLoader; // Loader for solution data components
    protected PuzzleCluesLoader clueLoader; // Loader for clue data components
    protected PuzzleHintLoader hintLoader; // Loader for hint data components

    private List<Button> moveHistory = new ArrayList<>(); // Stores move history
    private List<String[]> buttonPairs = new ArrayList<>(); // Stores correct button pairs
    private List<Button> buttons = new ArrayList<>(); // Stores all buttons

    public PuzzleGridController() {
        // JavaFX will call @FXML initialize()
    }

    @FXML
    private void initialize() {
        categoryLoader = new PuzzleCategoryLoader("PuzzleCategories.csv"); // creates a PuzzleCategoryLoader
        dataLoader = new PuzzleDataLoader("PuzzleSolutions.csv"); // creates a PuzzleDataLoader
        clueLoader = new PuzzleCluesLoader("PuzzleClues.csv"); // creates a PuzzleClueLoader
        hintLoader = new PuzzleHintLoader("PuzzleHints.csv"); // creates a PuzzleHintLoader

        categoryLoader.loadCategories("PuzzleCategories.csv"); // loads the PuzzleCategoryLoader with a csv
        dataLoader.loadCSV("PuzzleSolutions.csv"); // loads the PuzzleDataLoader with a csv
        clueLoader.loadClues("PuzzleClues.csv"); // loads the PuzzleClueLoader with a csv
        loadClues(); //loads the clues
        buttons.addAll(Arrays.asList( button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8, // adds all the buttons into an ArrayList
        button_9,button_10,button_11,button_12,button_13,button_14,button_15,button_16,
        button_17,button_18,button_19,button_20,button_21,button_22,button_23,button_24,
        button_25,button_26,button_27,button_28,button_29,button_30,button_31,button_32,
        button_33,button_34,button_35,button_36,button_37,button_38,button_39,button_40,
        button_41,button_42,button_43,button_44,button_45,button_46,button_47,button_48));

        for (Button button : buttons) { // for each button in the ArrayList set a binding for the toggle cell function
            button.setOnAction(event -> toggleCell(button, null, null));
        }

        hints.setOnAction(event -> displayHint()); // sets a binding for when the hint button is clicked to display a hint

        List<String> headers = categoryLoader.getHeaders(); // retrieves the headers from the category loader

        if (headers.size() >= 4) { // sets each of the header text spaces with the header that coincides with it
            header_1.setText(headers.get(0));
            header_2.setText(headers.get(1));
            header_3.setText(headers.get(2));
            header_4.setText(headers.get(3));
        } else { // if not enough headers in the csv respond with an appropriate response
            System.out.println("Not enough headers!");
        }

        List<String> category1 = categoryLoader.getCategory1(); // Loads category 1 into labels
        List<String> category2 = categoryLoader.getCategory2(); // Loads category 2 into labels
        List<String> category3 = categoryLoader.getCategory3(); // Loads category 3 into labels
        List<String> category4 = categoryLoader.getCategory4(); // Loads category 4 into labels

        List<Label> categoryLabels = Arrays.asList(label_1, label_2, label_3, label_4, // Stores the labels as an ArrayList
                label_5, label_6, label_7, label_8,
                label_9, label_10, label_11, label_12,
                label_13, label_14, label_15, label_16);

        int index = 0;
        for (int i = 0; i < category1.size() && index < categoryLabels.size(); i++) { //Loop through the category ArrayList and store each under the correct label
            categoryLabels.get(index++).setText(category1.get(i));
            categoryLabels.get(index++).setText(category2.get(i));
            categoryLabels.get(index++).setText(category3.get(i));
            categoryLabels.get(index++).setText(category4.get(i));
        }


    }

/*
ToggleCell is a function that permits the buttons within the grid to switch between a " ", "O", and "X".
It makes the button display a green color when the "O' is toggled, and red when the "X" is toggled.
 */
    private void toggleCell(Button button, String rowItem, String colItem) {
        String currentText = button.getText(); // Stores the text of the button in a string
        if (currentText.equals(" ")) { // If the text is " " set the text to "O"
            button.setText("O");
            button.setStyle("-fx-background-color: green;"); // Sets the color green
        } else if (currentText.equals("O")) { // If the text is "O" set the text to "X"
            button.setText("X");
            button.setStyle("-fx-background-color: red;"); //Sets the color red
        } else { // Otherwise if the text is "X" or anything else set it to " "
            button.setText(" ");
            button.setStyle(""); // Resets the color to default
        }

        moveHistory.add(button); // Add the button to move history
    }

    private void loadClues() { // Loads all the clues into the clues_text with newlines
        clues_text.setText(String.join("\n", clueLoader.get_List_Of_Clues()));
    }

    @FXML
    private void displayHint() { // Loads a hint with a newline after it into the hints_text
        hints_text.appendText(hintLoader.getNextHint() + "\n");
    }
/*
The clearErrors function was supposed to implemented by another group member who did not work on it,
 so for the sake of the rest of the program working we left it as this.
 */
    public void clearErrors() {
        for (Button button : buttons) {
            if (button.getText().equals("X")) {
                button.setStyle("");
                button.setText(" ");
            }
        }
    }

    /*
    The clearGrid function starts the game over, providing functionality for the start over button
     */
    public void clearGrid() {
        for (Button button : buttons) { // for each button in the list of buttons set the text to blanks along with the style
            button.setStyle("");
            button.setText(" ");
        }
        moveHistory.clear(); // clear move history
    }
}
