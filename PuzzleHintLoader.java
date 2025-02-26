import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.TextArea;

public class PuzzleHintLoader {
    private List<String> hints;
    private int hintIndex;
    private TextArea hintDisplay;

    public PuzzleHintLoader(TextArea hintDisplay) {
        this.hintDisplay = hintDisplay;
        loadHints();
        hintIndex = 0;
    }

    private void loadHints() {
        hints = new ArrayList<>();
        
        hints.add("Think about connections between countries and billionaires.");
        hints.add("Some billionaires have the same wealth but are from different countries.");
        hints.add("Look for patterns in the amounts—do you see a trend?");
        hints.add("One billionaire and one country always match.");
        hints.add("Some values repeat with different names.");
        hints.add("Try grouping similar values together.");
        hints.add("Every person and every country appears at least once.");
        hints.add("Finding one correct pair might help uncover others.");
        hints.add("Cross out incorrect guesses to narrow your choices.");
        hints.add("If two answers contradict, one must be wrong.");
        
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
        Collections.shuffle(hints);
    }
}
