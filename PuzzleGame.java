//David
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// fixed by Valerie 2/24 added ioexpection and fixed start with tests
public class PuzzleGame extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Puzzle_Game.fxml")); // Load FXML
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args); //starts the window
        
                // tests CsvSolutions.txt into console
        PuzzleDataLoader dataLoader = new PuzzleDataLoader("C:\\Users\\valer\\Desktop\\CS225\\Project2\\CSVSolutions.txt");
        for (String pair : dataLoader.getCorrectPairs()) {
            System.out.println(pair);
        }
        // tests CSVCategories.txt into console
        PuzzleCategoryLoader categoryLoader = new PuzzleCategoryLoader("C:\\Users\\valer\\Desktop\\CS225\\Project2\\CSVCategories.txt");
        for (String category : categoryLoader.getCategories()) {
            System.out.println(category);
        }
            // tests CSVHints.txt to be added by Anthony

        
    }
        public PuzzleGame() {
     
    }
}
