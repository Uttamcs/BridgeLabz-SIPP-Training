package WorkShop;

import java.util.*;

public class QuizProcessor {

    private final String[] correctAns;
    private final List<Integer> userScores;

    public QuizProcessor(String[] correctAns) {
        this.correctAns = correctAns;
        this.userScores = new ArrayList<>();
    }

    public int calculateScores(String[] userAns) {
        try {
            if (userAns.length == correctAns.length) {
                int score = 0;
                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i].equals(correctAns[i])) {
                        score++;
                    }
                }
                userScores.add(score);
                return score;
            } else {
                throw new IllegalArgumentException("Question count mismatch.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static String calculateGrade(int score, int total) {
        double ans = score / total * 100;
        if (ans >= 90) {
            return "A";
        } else if (ans >= 80) {
            return "B";
        } else if (ans >= 70) {
            return "C";
        } else if (ans >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        QuizProcessor qp = new QuizProcessor(new String[]{"A", "B", "C", "D", "E"});
        String[] userAns = {"A", "B", "C", "D", "E"};
        int score = qp.calculateScores(userAns);
        System.out.println("Score: " + score);
        System.out.println("Grade: " + calculateGrade(score, userAns.length));
    }
}
