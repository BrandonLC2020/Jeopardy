import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Grid extends JPanel {

    public Map<String, Map<Integer, Question>> allQuestionsMap;

    public Grid(ArrayList<Category> categories) {
        super();
        allQuestionsMap = new HashMap<String, Map<Integer, Question>>();
        loadQuestions(categories);
        fillGrid();
    }

    public void loadQuestions(ArrayList<Category> categories) {
        for (Category category : categories) {
            Map<Integer, Question> categoryQuestionsMap = new HashMap<Integer, Question>();
            Question[] questionsFromCategory = category.getQuestions();
            for (Question question : questionsFromCategory) {
                categoryQuestionsMap.put(question.getPoints(), question);
            }
            allQuestionsMap.put(category.getName(), categoryQuestionsMap);
        }
    }

    public JPanel fillCategory(String categoryName) {
        JPanel categoryCol = new JPanel();
        categoryCol.setBorder(new EmptyBorder(10, 10, 10, 10));
        categoryCol.setLayout(new BoxLayout(categoryCol, BoxLayout.Y_AXIS));
        Map<Integer, Question> category = allQuestionsMap.get(categoryName);
        JLabel categoryLabel = new JLabel(categoryName);
        categoryCol.add(categoryLabel);
        for (int i = 1; i <= 5; i++) {
            Question question = category.get(100 * i);
            GridSpace toAdd = new GridSpace(question);
            categoryCol.add(toAdd);
        }
        return categoryCol;
    }

    public void fillGrid() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (String categoryName : allQuestionsMap.keySet()) {
            this.add(fillCategory(categoryName));
        }
        this.setVisible(true);
    }
}
