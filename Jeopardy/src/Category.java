import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Category {
    private Map<Integer, Question> pointsToQuestions;
    private Question[] questions;

    public final int numQuestions = 5;

    //public Integer[] pointValues = new Integer[]{100, 200, 300, 400, 500};

    public Category(Question[] questions) throws Exception {
        this.questions = questions;
        if (questions.length != numQuestions) throw new Exception();
        this.pointsToQuestions = new HashMap<Integer, Question>();
        for (Question question : questions) {
            pointsToQuestions.put(question.getPoints(), question);
        }
    }



}
