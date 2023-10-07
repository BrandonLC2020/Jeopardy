public class Question {
    private String question;
    private String answer;

    private String category;

    private int points;

    public Question(String question, String answer, String category, int points) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.points = points;
    }

    public String getQuestion() {
        return this.question;
    }



    public String getAnswer() {
        return this.answer;
    }

    public String getCategory() {
        return this.category;
    }

    public int getPoints() {
        return this.points;
    }
}
