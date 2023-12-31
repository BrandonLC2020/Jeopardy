import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jeopardy {
    public static JFrame game;
    public static Grid board;

    public enum Action {
        Restart, Quit, Select
    }

    public static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof GridSpace) {
                ((GridSpace) e.getSource()).setBackground(Color.gray);
                GridSpace gridButton = (GridSpace) e.getSource();
                Action gridButtonAction = gridButton.getActionType();
                if (gridButtonAction == Action.Select) {
                    String gridButtonCategory = gridButton.getQuestion().getCategory();
                    int gridButtonPoints = gridButton.getQuestion().getPoints();
                    Question selectedQuestion = board.allQuestionsMap.get(gridButtonCategory).get(gridButtonPoints);



                    //show menu
                }
            }
        }
    };

    public static ArrayList<Category> loadSampleData() throws Exception {
        Question[] category1Questions = new Question[]{
                new Question("c1q1", "c1a1", "Category 1",100),
                new Question("c1q2", "c1a2", "Category 1",200),
                new Question("c1q3", "c1a3", "Category 1", 300),
                new Question("c1q4", "c1a4", "Category 1", 400),
                new Question("c1q5", "c1a5", "Category 1", 500),
        };
        Question[] category2Questions = new Question[]{
                new Question("c2q1", "c2a1", "Category 2", 100),
                new Question("c2q2", "c2a2", "Category 2", 200),
                new Question("c2q3", "c2a3", "Category 2", 300),
                new Question("c2q4", "c2a4", "Category 2", 400),
                new Question("c2q5", "c2a5", "Category 2", 500),
        };
        Question[] category3Questions = new Question[]{
                new Question("c3q1", "c3a1", "Category 3", 100),
                new Question("c3q2", "c3a2", "Category 3",200),
                new Question("c3q3", "c3a3", "Category 3",300),
                new Question("c3q4", "c3a4", "Category 3",400),
                new Question("c3q5", "c3a5", "Category 3",500),
        };
        Question[] category4Questions = new Question[]{
                new Question("c4q1", "c4a1", "Category 4",100),
                new Question("c4q2", "c4a2", "Category 4",200),
                new Question("c4q3", "c4a3", "Category 4",300),
                new Question("c4q4", "c4a4", "Category 4",400),
                new Question("c4q5", "c4a5", "Category 4",500),
        };
        Question[] category5Questions = new Question[]{
                new Question("c5q1", "c5a1", "Category 5",100),
                new Question("c5q2", "c5a2", "Category 5",200),
                new Question("c5q3", "c5a3", "Category 5",300),
                new Question("c5q4", "c5a4", "Category 5",400),
                new Question("c5q5", "c5a5", "Category 5",500),
        };
        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Category 1",category1Questions));
        categories.add(new Category("Category 2",category2Questions));
        categories.add(new Category("Category 3",category3Questions));
        categories.add(new Category("Category 4",category4Questions));
        categories.add(new Category("Category 5",category5Questions));
        return categories;
    }

    public static void startGame() throws Exception {
        //config the game here
        //load the categories and questions
        ArrayList<Category> sampleData = loadSampleData();
        runGame(sampleData);
    }

    public static void runGame(ArrayList<Category> categories) {
        game = new JFrame();
        Container content = game.getContentPane();
        content.setLayout(new BorderLayout());

        board = new Grid(categories);
        content.add(board, BorderLayout.CENTER);

        game.setTitle("Jeopardy");
        game.setSize(900, 700);
        game.setResizable(true);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.update(game.getGraphics());
    }

    public static void main(String[] args) throws Exception {
        startGame();
    }

}
