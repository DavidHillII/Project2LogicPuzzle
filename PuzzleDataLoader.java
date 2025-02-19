import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PuzzleDataLoader {
    private Map<String, String> correctPairs = new HashMap<>();

    public PuzzleDataLoader(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // read catergories of first row
            String[] categoryNames = br.readLine().split(",");
        }
    }    
}
