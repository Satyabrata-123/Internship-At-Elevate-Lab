package Day8;
import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Which of the following is not a Java keyword?",
                Arrays.asList("static", "Boolean", "void", "private"), 2));

        questions.add(new Question("Which method is the entry point for any Java program?",
                Arrays.asList("start()", "main()", "run()", "init()"), 2));

        questions.add(new Question("Which of the following is used to create an object in Java?",
                Arrays.asList("class", "new", "Object", "create"), 2));

        questions.add(new Question("What is the default value of an int variable in Java?",
                Arrays.asList("0", "null", "undefined", "1"), 1));

        questions.add(new Question("Which of these is a superclass of all classes in Java?",
                Arrays.asList("Object", "Class", "Main", "Superclass"), 1));
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions.get(i).displayQuestion();

            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();

            if (questions.get(i).isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        scanner.close();
    }
}