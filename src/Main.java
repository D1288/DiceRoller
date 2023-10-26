import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNum = new Random();
        int totalScore = 0;

        System.out.println("Enter the number of sides your dice has");
        int dieSides = scanner.nextInt();

        System.out.println("How many of these die are you rolling?");
        int numOfDie = scanner.nextInt();

        for(int i = 0; i<= numOfDie -1; i++){
            int dieScore = randomNum.nextInt(dieSides) + 1;
            System.out.println(dieScore);
            totalScore += dieScore;
        }

        System.out.println(totalScore);

    }
}