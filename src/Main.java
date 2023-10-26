import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNum = new Random();
        int totalScore = 0;
        ArrayList<Dice> diceList = new ArrayList<>();
        
        int dieSides;
        int numOfDie;
        while (true) {
            System.out.println("Enter the number of sides your dice has");
            dieSides = scanner.nextInt();

            System.out.println("How many of these die are you rolling?");
            numOfDie = scanner.nextInt();

            for (int i = 0; i < numOfDie; i++) {
                diceList.add(new Dice(dieSides));
            }

            System.out.println("Would you like to add more die to the roll? Yes/No");
            String response = scanner.next();

            if (response.equalsIgnoreCase("No")) {
                break;
            }
        }

        for (Dice dice : diceList) {
            int dieScore = randomNum.nextInt(dice.dieSides) + 1;
            System.out.println("The " + dice.dieSides + " sided die rolled a " + dieScore);
            totalScore += dieScore;
        }

        System.out.println("Your total is: " + totalScore);

    }
}