//Valerie David
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
        // tests CsvSolutions.txt
        PuzzleDataLoader dataLoader = new PuzzleDataLoader("C:\\Users\\valer\\Desktop\\CS225\\Project2\\CSVSolutions.txt");
        for (String pair : dataLoader.getCorrectPairs()) {
            System.out.println(pair);
        }
        // tests CSVCategories.txt
        PuzzleCategoryLoader categoryLoader = new PuzzleCategoryLoader("C:\\Users\\valer\\Desktop\\CS225\\Project2\\CSVCategories.txt");
        for (String category : categoryLoader.getCategory1()) {
            System.out.println(category);
            for (String category2 : categoryLoader.getCategory2()) {
                System.out.println(category2);
                for (String category3 : categoryLoader.getCategory3()) {
                    System.out.println(category3);
                    for (String category4 : categoryLoader.getCategory4()) {
                        System.out.println(category4);
                    }
                }
            }
        }
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