import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args) {
        //Intro
        System.out.println("Let’s play a game called \"Odds and Evens\"\n");
        System.out.print("What is your name? ");
        Scanner input = new Scanner (System.in);
        String name = input.nextLine();

        //Choose Odds or Evens
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String chosen = input.next();
        while (!chosen.equals("O") && !chosen.equals("E")) {
            System.out.print("Enter ONLY \"O\" or \"E\": ");
            chosen = input.next();
        }

        if (chosen.equals("O")) {
            System.out.println(name + " has picked odds. The computer will be evens.  \n------------------------\n");
        } else {
            System.out.println(name + " has picked evens. The computer will be evens. \n------------------------\n");
        }

        //Choose number of fingers
        System.out.print("How many \"fingers\" do you put out? ");
        int user = input.nextInt();
        while (user > 5 || user <0){
            System.out.print("Wrong. Enter a number between 0 and 5: ");
            user = input.nextInt();
        }

        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " fingers. \n-----------------------\n");

        //Result
        int sum = user + computer;
        boolean oddOrEven = sum%2 == 0;
        boolean userResult = user%2 == 0;
        System.out.println(user + " + " + computer + " = " + sum);
        if (oddOrEven)
        {
            System.out.println(sum + " is" + " ...evens.");
            if (userResult) {
                System.out.print("That means " + name + " wins! :)");
            }
            else {
                System.out.print("That means computer wins! :)");
            }
        }
        else {
            System.out.println(sum + " is" + " ...odds.");
            if (!userResult) {
                System.out.print("That means " + name + " wins! :)");
            }
            else {
                System.out.print("That means computer wins! :)");
            }
        }
    }
}