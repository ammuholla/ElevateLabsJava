package Online_quiz;
import java.util.*;

public class QuizApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Question 1
        questions.add(new Question(
                "Which language is used for Android development?",
                Arrays.asList("Python", "Java", "C++", "Ruby"),
                1));

        // Question 2
        questions.add(new Question(
                "What is the size of int in Java?",
                Arrays.asList("2 bytes", "4 bytes", "8 bytes", "Depends on OS"),
                1));

        // Question 3
        questions.add(new Question(
                "Which collection allows dynamic size?",
                Arrays.asList("Array", "ArrayList", "int[]", "String"),
                1));

        // Question 4
        questions.add(new Question(
                "Which keyword is used for inheritance in Java?",
                Arrays.asList("implements", "extends", "inherit", "super"),
                1));

        // Question 5
        questions.add(new Question(
                "Which method is the entry point of Java program?",
                Arrays.asList("start()", "run()", "main()", "init()"),
                2));

        // Question 6
        questions.add(new Question(
                "Which exception occurs when dividing by zero?",
                Arrays.asList("NullPointerException", "ArithmeticException", "IOException", "SQLException"),
                1));

        // Question 7
        questions.add(new Question(
                "Which keyword is used to prevent inheritance?",
                Arrays.asList("static", "final", "private", "protected"),
                1));

        // Question 8
        questions.add(new Question(
                "Which interface is used for event handling in Swing?",
                Arrays.asList("Runnable", "ActionListener", "Serializable", "Cloneable"),
                1));

        // Question 9
        questions.add(new Question(
                "Which JDBC object is used to execute parameterized queries?",
                Arrays.asList("Statement", "PreparedStatement", "Connection", "DriverManager"),
                1));

        // Question 10
        questions.add(new Question(
                "Which method is used to start a thread?",
                Arrays.asList("run()", "execute()", "start()", "begin()"),
                2));

        // Shuffle Questions
        Collections.shuffle(questions);

        int score = 0;

        System.out.println("ONLINE QUIZ APP");

        for (Question q : questions) {

            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt() - 1;

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
        }

        System.out.println("QUIZ RESULT");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Score: " + (score * 100 / questions.size()) + "%");

        scanner.close();
    }
}
