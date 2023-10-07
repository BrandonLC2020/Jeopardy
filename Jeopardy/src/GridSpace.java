import java.awt.*;

public class GridSpace extends JAButton{
    private boolean selected;

    private Question question;
    private static final Font buttonFont = new Font("Arial", Font.BOLD, 45);

    public GridSpace(String text) {
        super(text, Jeopardy.Action.Select);
        this.selected = false;
        this.question = null;
        this.setFont(buttonFont);
        this.revalidate();
    }
    public GridSpace(String text, Question question) {
        super("" + question.getPoints(), Jeopardy.Action.Select);
        this.selected = false;
        this.question = question;
        this.setFont(buttonFont);
        this.revalidate();
    }
    public boolean hasBeenSelected() {
        return this.selected;
    }

    public Jeopardy.Action getActionType() {
        return super.getActionType();
    }

}
