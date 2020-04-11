import java.util.Scanner;
import java.io.PrintStream;

public class TripPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What's your name? ");
        String name = input.nextLine();

        System.out.print("Nice to meet you " + name + ", where are you travelling to? " );
        String place = input.nextLine();
        System.out.print("Great! " + place + " sounds like a great trip. \n*******\n");

        System.out.print("How many days are you going to spend travelling? ");
        int day =  input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        double rate = input.nextDouble();
        System.out.println("If you are travelling for " + day + " days that is the same as " + day*24 + " hours or " + (day*24)*60 + " minutes.");
        System.out.println("If you are going to spend " + money + " USD that means per day you can spend up to " + (int)(((double)money/day)*100)/100.0 + " USD.");
        PrintStream out = new PrintStream(System.out);
        System.out.print("Your total budget in " + currency + " is ");
        out.format("%.2f", money*rate);
        System.out.println(" " + currency + ", which per day is " + (int)((money*rate)/day*100)/100.0 + " " + currency + ".\n******");


        System.out.print("What is the time different, in hour, between your home and your destination? ");
        int hour = input.nextInt();
        int noon = 12 + hour;
        System.out.println("That means that when it is midnight at home it will be " + hour%24 +":00 in your travel destination and when it is noon at home it will be " + noon%24 + ":00.\n******");

        System.out.print("What is the square area of your destination country in km2? ");
        int km2 = input.nextInt();
        System.out.println("In miles2 that is " + (int)((km2*0.38610)*100)/100.0);

    }
}