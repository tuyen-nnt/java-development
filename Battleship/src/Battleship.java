import java.util.Scanner;
import java.util.Random;

public class Battleship {
    public static Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
    public static Random rand = new Random();

    public static char[][] map = new char[10][10];
    public static char[][] map2 = new char[10][10];

    public static int userShips = 0;
    public static int computerShips = 0;

    public static void main(String[] args) {
        System.out.println("***Welcome to the Battle ships game*** \n Righ now, the sea is empty.");
        System.out.println("done" +map[2][2] + "done");
        printMap(map);
        userLoc(map);
        computerLoc(map);
        battle();

    }

    public static void printMap(char[][] map) {
        //Print out ocean map

        System.out.println("  0123456789");

        for (int row = 0; row < map.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == '0') {
                    System.out.print(" ");
                } else {
                    System.out.print(map[row][col]);
                }
            }
            System.out.println("|" + row);
        }
        System.out.println("  0123456789");
    }
        /*
        Here is some sample code where you ask the user to enter in the coordinates for where to place a ship
        */

        public static void userLoc(char[][] map) {
          System.out.println("Deploy your ships : ");

          while (userShips < 5) {
              System.out.print("Enter X coordinate for your " + (userShips + 1) + " ship: ");
              int x = input.nextInt();
              System.out.print("Enter Y coordinate for your " + (userShips + 1) + " ship: ");
              int y = input.nextInt();

              if (x > 9 || y > 9) {
                  System.out.println("The coordinate you entered is out of range, please try again");
              } else if (map[x][y] != '0') {
                  System.out.println("The coordinate you entered is already used, please try again");
              } else {
                  map[x][y] = '@';
                  userShips++;
              }
            }
          }

          public static void computerLoc(char[][] map) {
            System.out.println("\nComputer is deploying ships: ");
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);

            while (computerShips < 5) {
                if (map[x][y] == '0' && map2[x][y] == '0') { //You cannot place at an existed ship location
                    System.out.println("Ship deployed..");
                    map2[x][y] = '@';
                    computerShips++;
                }
              }
          }

          public static void userTurn() {
            System.out.println("YOUR TURN");
            int turn = 0;

            while (turn == 0) {
                System.out.print("Enter X coordinate : ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate : ");
                int y = input.nextInt();

                if (x > 9 || y > 9) {
                    System.out.println("The coordinate you entered is out of range, please try again.");
                } else if (map[x][y] == '!' || map[x][y] == 'x' || map[x][y] == '-') {
                    System.out.println("The coordinate you entered was already in used. Please try again.");
                }
                else if (map[x][y] == '@') {
                    System.out.println("Oops it seems like you sunk your own ship!");
                    map[x][y] = 'x';
                    userShips--;
                    turn++;
                } else if (map2[x][y] == '@') {
                    System.out.println("Boom.. You sunk the computer ship!");
                    map[x][y] = '!';
                    map2[x][y] = '!';
                    computerShips--;
                    turn++;
                } else {
                    System.out.println("You missed!");
                    map[x][y] = '-';
                    turn++;
                }
            }
          }

          public static void computerTurn() {
            int turn = 0;

            while (turn == 0) {
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);

                if (map[x][y] != 'x' || map[x][y] != '-' || map[x][y] != '!') {
                    if (map2[x][y] == '@') {
                        System.out.println("The Computer sunk one of its own ships!");
                        map[x][y] = 'x';
                        map2[x][y] = 'x';
                        computerShips--;
                        turn++;
                    } else if (map[x][y] == '@') {
                        System.out.println("The Computer sunk one of your ships!");
                        map[x][y] = '!';
                        map2[x][y] = '!';
                        userShips--;
                        turn++;
                    } else {
                        System.out.println("Computer missed");
                        map2[x][y] = '-';
                        turn++;
                    }
                }
            }
          }

          public static void battle() {
            System.out.println("Your ships:" + userShips + " | " + "Computer ships: " + computerShips);

            while (userShips > 0 && computerShips > 0) {
                userTurn();
                computerTurn();
            }
            if (userShips == 0) {
                System.out.println("GAME OVER!");
                System.out.println("Your ships:" + userShips + " | " + "Computer ships: " + computerShips);
            } else if (computerShips == 0) {
                System.out.println("Hooray.. You win the game!");
                System.out.println("Your ships:" + userShips + " | " + "Computer ships: " + computerShips);
            }
        }
    }


