package mypack;

import java.util.Scanner;

public class HelperMethods {
    public static void intro() {
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.\n Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("-------------------------");
    }

    //Method control operator input of user
    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (+,-,/,*,=) or \"Q\" to quit: ");
        String operation;

        while (!input.hasNext("[-+*/=qQ]")) {
            System.out.println("Invalid input. (+, -, *, /, = or Q to quit).");
            input.next();
        }
        operation = input.next().toLowerCase();
        if (input.next() == "q") {
            System.out.println("The program ended.");
            System.exit(0);
        }
        return operation;
    }

    public static boolean validFraction(String frac) {

        if (frac.startsWith("-")) {
            frac = frac.substring(1,frac.length()-1);
        }

        if (frac.contains(" ") || frac.contains("-") || frac.charAt(frac.indexOf("/")) == '0') {
            return false;
        } else if (frac.contains("/")) {
            frac = frac.replace("/","");
        }

        return isNumber(frac);
    }

    public static Fraction getFraction () {
    System.out.print("Please enter a Fraction (a/b) or integer (a): ");
    Scanner input = new Scanner(System.in);
    String frac = input.next();

    while (!validFraction(frac)) {
        System.out.print("Invalid input. Please enter a Fraction (a/b) or integer (a) again: ");
        frac = input.next();
    } ;

    int num = 0;
    int den = 0;
    String sub1 = frac.substring(0,frac.indexOf("/"));

    if (frac.contains("/")) {
        num = Integer.parseInt(sub1);
        den = Integer.parseInt(frac.substring(frac.indexOf("/")+1,frac.length()-sub1.length()));
    } else {
        num = Integer.parseInt(frac);
        den = 1;
    }

        return new Fraction(num,den);
    }

    public static boolean isNumber(String text) {
        if (text.equals("")) {
            System.out.println("Empty String");
            return false;
        }
        if (!text.matches("[0-9]")) {
            throw new IllegalArgumentException("Not a Fraction!");
        }
        return true;
    }

}
