public class Main {
    public static void main(String[] args) {

        QuestionService questions = new QuestionService();
        questions.playQuiz();
        questions.printScore();
    }
}