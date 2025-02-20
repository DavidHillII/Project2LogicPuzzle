//Valerie
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PuzzleDataLoader {
    private ArrayList<String> correctPairs = new ArrayList<>();
    

    public void loadCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] pair = line.split(",");
                if (pair.length == 2) {
                    correctPairs.add(pair[0] + "," + pair[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
    }
    public boolean isCorrectPair(String item1, String item2) {
        return correctPairs.contains(item1 + "-" + item2) || correctPairs.contains(item2 + "-" + item1);
    }
      
    }
