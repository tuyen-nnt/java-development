import java.util.Scanner;

public class MazeRunner {
    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro();
        myMap.printMap();

        Scanner input = new Scanner (System.in);
        System.out.println("Where would you like to move? ");
        String step = input.next();
        if (step.equals("R"))
        {
            if (myMap.canIMoveRight()) {
                m
            } else {
                System.out.println("Sorry you've hit a wall!");
            }
        } else if (step.equals("L"))
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
    }
}