package at.ac.fhcampuswien;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);


    //todo Task 1
    public void largestNumber(){
        System.out.print("Number 1: ");
        double number = scanner.nextDouble();
        double largestNumber;
        largestNumber = number;
        double secondNumber = number;

        DecimalFormat f1 = new DecimalFormat("0.00");


        if (number <= 0) {
            System.out.println("No number entered.");
            return;
        }
        for (int i = 2; i > 0 && secondNumber > 0; i++) {
            System.out.print("Number " + i + ": ");
            secondNumber = scanner.nextDouble();
            if (secondNumber > number) {
                largestNumber = secondNumber;
            }
        }

        System.out.println("The largest number is " + f1.format(largestNumber));
    }

    //todo Task 2
    public void stairs(){
        System.out.print("n: ");
        int number = scanner.nextInt();
        int count = 0;
        if (number <= 0) {
            System.out.println("Invalid number!");
        }
        for (int i = 1; i <= number; i++) //outer loop
        {
            for (int j = 1; j <= i; j++) { //inner loop for drawing the stairs
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid(){
        int i, j, row = 6; //Constant
        for (i=0; i<row; i++) //outer loop
        {
            for (j=row-i-1; j>0; j--) //drawing the spaces
            {
                System.out.print(" ");
            }
            for (j=0; j<i*2+1; j++ ) //drawing the symbols
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
//Didn't understand the excercise completely

        char a;
        int height;

        System.out.print("h: ");
        height = scanner.nextInt();
        System.out.print("c: ");
        a = scanner.next().charAt(0);
        if (height % 2 == 0)
        {
            System.out.println("Invalid number!");
        }
    }

    //todo Task 5
    public void marks(){
        int count = 0;
        int add = 0;
        int negativeMark = 0;
        DecimalFormat df = new DecimalFormat("0.00");                   // preparing the output format

        System.out.print("Mark 1: ");
        int markInput = scanner.nextInt();
        if (markInput < 0 || markInput > 5) {
            System.out.println("Invalid mark!");
            System.out.print("Mark 1: ");
            markInput = scanner.nextInt();

        } else if (markInput == 0) {                                    // if the first given mark is 0, the program closes itself

            double average = 0.00;
            System.out.println("Average: " + df.format(average));
            System.out.println("Negative marks: " + negativeMark);
        } else if (markInput == 5) {                                        // increment the negative mark counter
            negativeMark = negativeMark + 1;
            add = add + markInput;
            count = count + 1;
        } else if ((markInput > 0) && (markInput < 6)) {                //adding the grade to the calculation variable
            add = add + markInput;
            count = count + 1;
        }

        for (int i = 2; markInput != 0; i++) {                                  //automate the mark process
            System.out.print("Mark " + i + ": ");
            markInput = scanner.nextInt();

            if ((markInput > 0) && (markInput < 6) && (markInput != 5)) {
                add = add + markInput;
                count = count + 1;

            } else if (markInput < 0 || markInput > 5) {                        // proofing if the mark is a negative value or higher than allowed
                System.out.println("Invalid mark!");
                System.out.print("Mark " + i + ": ");
                markInput = scanner.nextInt();
                count = count + 1;
                add = add + markInput;

            } else if (markInput == 0) {                                                //if the given mark is 0, the program closes itself
                double average = (double) add / count;
                System.out.println("Average: " + df.format(average));
                System.out.println("Negative marks: " + negativeMark);
            } else if (markInput == 5) {
                negativeMark = negativeMark + 1;
                count = count + 1;
                add = add + markInput;

            }
        }
    }

    //todo Task 6
    public void happyNumbers(){
        System.out.print("n: ");
        int number = scanner.nextInt();
        int remaining = 0;
        int sum = 0;

        while(number != 1 || number == 4)
        {
            remaining = number % 10;
            sum = sum + (remaining * remaining);
            number = number / 10;

            if (number == 0)
            {
                number = sum;
                sum = 0;
            }
            else if (sum == 4)
            {
                System.out.println("Sad number!");
                break;
            }
        }
        if (number == 1 )
        {
            System.out.println("Happy number!");
        }
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}