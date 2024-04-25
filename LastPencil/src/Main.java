import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static final String[] names = {"John", "Jack"};

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

       int numberOfPencils = getNumberOfPencils();
       String playerOne = getPlayer();
       String playerTwo = names[getBot(playerOne)];
       new Game(new Player(playerOne), new Player(playerTwo), numberOfPencils).start();
    }

    private static String getPlayer() {

        System.out.println("Who will be the first (John, Jack):");
        String name = scanner.nextLine();

        while (!isValidName(name)) {
            System.out.println("Choose between 'John' and 'Jack'");
            name = scanner.nextLine();
        }

        return name;
    }

    private static int getBot(String name) {

        for (int i = 0; i < names.length; i++) {
            if (!names[i].equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isValidName(String name) {
        return names[0].equals(name) || names[1].equals(name);
    }

    private static int getNumberOfPencils() {

        System.out.println("How many pencils would you like to use:");
        boolean isValidNumber = false;
        String input = scanner.nextLine();

        while (!isValidNumber) {

            if (isNumber(input)) {
                isValidNumber = checkInputNumber(Integer.parseInt(input));
            }

            if (!isValidNumber) {
                input = scanner.nextLine();
            }
        }

        return Integer.parseInt(input);
    }

    private static boolean checkInputNumber(int numb) {

        if (numb <= 0) {
            String output = (numb == 0) ? "The number of pencils should be positive" : "The number of pencils should be numeric";
            System.out.println(output);
            return false;
        }

        return true;
    }

    private static boolean isNumber(String input) {

        if (!input.isEmpty()) {

            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
                return false;
            }

            return true;
        }

        return false;
    }
}