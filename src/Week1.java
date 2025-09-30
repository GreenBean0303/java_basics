 /*import java.util.Scanner;

public class Week1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //Exercise 1
        System.out.println("Jane Doe");

        //Exercise 5
        int days = 365;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;
        int totalSeconds = days * hours * minutes * seconds;
        System.out.println("There are " + totalSeconds + " seconds in a year");

        //Exercise 9
        System.out.println("Type a number: ");
        int firstNumber = Integer.parseInt(reader.nextLine());
        System.out.println("Type another number: ");
        int anotherNumber = Integer.parseInt(reader.nextLine());
        double division = (double) firstNumber / anotherNumber;
        System.out.println("The division is " + firstNumber + " / " + anotherNumber + " = " + division);

        //Exercise 10
        System.out.println("Type a radius: ");
        double radius = Double.parseDouble(reader.nextLine());
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference of the circle:  " + circumference);

        //Exercise 14
        System.out.println("Type a number: ");
        int number = Integer.parseInt(reader.nextLine());
        if (number > 0) {
            System.out.println("This number is positive");
        } else {
            System.out.println("This number is negative");
        }

        //Exercise 16
        System.out.println("Type a number: ");
        int evenOddNumber = Integer.parseInt(reader.nextLine());
        if (evenOddNumber % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }

        //Exercise 18
        System.out.println("Type the points [0-60]: ");
        int points = Integer.parseInt(reader.nextLine());
        if (points < 30) {
            System.out.println("Grade: Failed");
        } else if (points >= 30 && points <= 34) {
            System.out.println("Grade: 1");
        } else if (points >= 35 && points <= 39) {
            System.out.println("Grade: 2");
        } else if (points >= 40 && points <= 44) {
            System.out.println("Grade: 3");
        } else if (points >= 45 && points <= 49) {
            System.out.println("Grade: 4");
        } else if (points >= 50 && points <= 60) {
            System.out.println("Grade: 5");
        }

        //Exercise 19
        System.out.print("How old are you? ");
        int age = Integer.parseInt(reader.nextLine());
        if (age >= 0 && age <= 120) {
            System.out.println("ok");
        } else {
            System.out.println("Impossible!");
        }


        //Exercise 21
        System.out.print("Type a year : ");
        int year = Integer.parseInt(reader.nextLine());
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("The year is a leap year");
        }else {
            System.out.println("The year is not a leap year");
        }


        //Exercise 22
        String password = "carrot";
        while (true) {
            System.out.print("Type the password: ");
            String enterPassword = reader.nextLine();
            if (enterPassword.equals(password)) {
                System.out.println("Right!");
                System.out.println("\nThe secret is: jryy qbar!");
                break;
            } else {
                System.out.println("Wrong!");
            }
        }
    }

}

*/