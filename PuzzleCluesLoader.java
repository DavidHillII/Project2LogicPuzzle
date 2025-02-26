//David Hill This loader retrieves a list of clues from a csv file and stores them into an arrayList to later be displayed.
import java.io.*;
import java.util.*;

public class PuzzleCluesLoader { //class for loading the list of clues from a csv file
    private List<String> clues_List; //Created the list for the clues

    public PuzzleCluesLoader(String filePath) {
        clues_List = new ArrayList<>(); //Creates an arrayList
        loadClues(filePath); //load the clues from the file
    }

    private void loadClues(String filePath) { //function for loading clues
        try (Scanner scanner = new Scanner(new File(filePath))) { //Creates a scanner and implements a try catch in order to successfully read through a csv file.
            while (scanner.hasNextLine()) { //Reads the file line of the csv file
                String line = scanner.nextLine().trim(); //Stores the text in a string.
                if (!line.isEmpty()) { //So long as there is another clue in the csv file add the string into the arrayList.
                    clues_List.add(line);
                }
            }
        } catch (IOException e) { //Catches any possible I/O errors to avoid a warning
            e.printStackTrace(); //prints stacktrace
        }
    }

    public List<String> get_List_Of_Clues() { //function to retrieve the list of clues
        return clues_List; //returns the list of clues
    }


    public void print_List_Of_Clues() { //function to print the clues
        for (String clue : clues_List) { //for loop to look at each string in the arrayList
            System.out.println(clue); //print each clue
        }
    }
}
