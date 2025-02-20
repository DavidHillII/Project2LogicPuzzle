import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class PuzzleGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        String filePath = "PuzzleCategories.csv";
        new PuzzleGridController(primaryStage, filePath);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
