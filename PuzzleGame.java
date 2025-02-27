//Valerie David Launch file for the game and the main class
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//now working with fxml

public class PuzzleGame extends Application {
    public static void main(String[] args) {
        launch(args);

        // tests CSVHints.txt
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Puzzle_Game.fxml")); // Load FXML
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}