import javax.swing.*;
public class JAButton extends JButton {
    private Jeopardy.Action actionType;

    public JAButton(String text, Jeopardy.Action action) {
        super(text);
        this.actionType = action;
        this.addActionListener(Jeopardy.actionListener);
    }

    public Jeopardy.Action getActionType() {
        return this.actionType;
    }
}
