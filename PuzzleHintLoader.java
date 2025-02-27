import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;

public class PuzzleHintLoader {
    private List<String> hints;
    private int hintIndex;
    private TextArea hintDisplay;

    public PuzzleHintLoader(TextArea hintDisplay) {
        this.hintDisplay = hintDisplay;
        hints = loadHints();
        hintIndex = 0;
    }

    private List<String> loadHints() {
        List<String> loadedHints = new ArrayList<>();
        loadedHints.add("The person with $25 billion traveled to the country of another billionaire.");
        loadedHints.add("Al Acosta did not visit his own country.");
        loadedHints.add("The person who went to Norway has exactly $1 billion less than the person who went to France.");
        loadedHints.add("Sid Scott and Leonard Levy did not travel to each other’s home countries.");
        loadedHints.add("The wealthiest traveler did not go to Argentina.");
        loadedHints.add("The person worth $27 billion traveled to a country whose name starts with 'F'.");
        loadedHints.add("The person who traveled to Sweden has more wealth than the person who traveled to Argentina.");
        loadedHints.add("Hal Hickman’s destination was not in Europe.");
        loadedHints.add("The billionaire who traveled to Norway has an even-numbered wealth amount.");
        loadedHints.add("Neither Sid Scott nor Leonard Levy traveled to Sweden.");
        loadedHints.add("The person with $28 billion and the person who traveled to France are not the same.");
        loadedHints.add("One billionaire traveled to their own home country, but it wasn’t Al Acosta.");
        return loadedHints;
    }

    public void dropHint() {
        if (hintIndex < hints.size()) {
            hintDisplay.appendText(hints.get(hintIndex) + "\n");
            hintIndex++;
        } else {
            hintDisplay.appendText("No more hints available!\n");
        }
    }

    public void resetHints() {
        hintIndex = 0;
        hintDisplay.clear();
    }
}
