//valerie

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PuzzleDataLoader {
    private ArrayList<String> correctPairs = new ArrayList<>();
    

    public void loadCSV(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
       public List<String> getCorrectPairs() {
        return correctPairs;
    }
    // print out the correct pairs in the console
    public PuzzleDataLoader(String fileName) {
        
        loadCSV(fileName);
    }
      
    }
