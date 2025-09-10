import java.util.Scanner;

public class Week2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Exercise 26
        int sum = 0;
        while (true){
            int read = Integer.parseInt(reader.nextLine());
            if (read == 0){ break; }
            sum += read;
            System.out.println("The sum now: " + sum);
        }
        System.out.println("The sum in the end " + sum);



        // Exercise 29
        int number = 2;
        while (number <= 100){
            System.out.println(number);
            number += 2;
        }


        // Exercise 30
        System.out.print("Up to what number?");
        int limit = Integer.parseInt(reader.nextLine());
        int counter = 1;
        while (counter <= limit){
            System.out.println(counter);
            counter ++;
        }


        // Exercise 32
        System.out.print("Until what? ");
        int number = Integer.parseInt(reader.nextLine());
        int sumTotal = 0;
        int interval = 1;
        while (interval <= number) {
            sumTotal += interval;
            interval++;
        }
        System.out.println("Sum is " + sumTotal);



        // Exercise 36
        System.out.println("Type numbers:");
        int totalSum = 0;
        int count = 0;
        int evenCount = 0;
        int oddCount = 0;

        while (true) {
            int inputNumber = Integer.parseInt(reader.nextLine());
            if (inputNumber == -1)
            {
                break;
            }

            totalSum += inputNumber;
            count++;

            if (inputNumber % 2 == 0) {
                evenCount++;
            }else {
                oddCount++;
            }
        }
        System.out.println("Thank you and see you later!");
        System.out.println("The sum is " + totalSum);
        System.out.println("How many numbers: " + count);
        System.out.println("Average: " + (double)totalSum / count);
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);




        // Exercise 37 and 39
        printText();
        printStars(5);         // Exercise 39.1
        printSquare(4);        // Exercise 39.2
        printRectangle(17, 3); // Exercise 39.3
        printTriangle(4);      // Exercise 39.4

        // Exercise 41
        guessingGame();
    }

    public static void printText() {
        System.out.println("In the beginning there were the swamp, the hoe and Java.");
    }

    public static void printStars(int amount) {
        int interval = 0;
        while (interval < amount) {
            System.out.print("*");
            interval++;
        }
        System.out.println("");
    }

    public static void printSquare(int sideSize) {
        int interval = 0;
        while (interval < sideSize) {
            printStars(sideSize);
            interval++;
        }
    }

    public static void printRectangle(int width, int height) {
        int interval = 0;
        while (interval < height) {
            printStars(width);
            interval++;
        }
    }

    public static void printTriangle(int size) {
        int interval = 1;
        while (interval <= size) {
            printStars(interval);
            interval++;
        }
    }

    public static void guessingGame() {
        Scanner reader = new Scanner(System.in);
        int secretNumber = 42;
        int guesses = 0;

        while (true) {
            System.out.print("Guess a number: ");
            int guess = Integer.parseInt(reader.nextLine());
            guesses++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! Your guess is correct!");
                break;
            } else if (guess < secretNumber) {
                System.out.println("The number is greater, guesses made: " + guesses);
            } else {
                System.out.println("The number is lesser, guesses made: " + guesses);
            }
        }
    }
}