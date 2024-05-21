package reloadThat;

import java.util.InputMismatchException;
import java.util.Scanner;

class Operator {
    private Scanner scanner = new Scanner(System.in);

    public int selectOperator() {
        System.out.println("1: Addition\n2: Subtraction\n3: Division\n4: Multiplication\n5: Factorial\n" +
                "6: Binary to Decimal\n7: Square Root");
        System.out.print("Enter your number: ");
        int num = 0;

        try {
            num = scanner.nextInt();
            if (num < 1 || num > 7) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
            scanner.next();  // clear the invalid input
            return selectOperator();  // recursively ask for input again
        }
        return num;
    }

    public void closeScanner() {
        scanner.close();
    }
}

public class Calculator {
    public static void main(String[] args) {
        Operator userOperator = new Operator();
        int operation = userOperator.selectOperator();
        performOperation(operation);
        userOperator.closeScanner();
    }

    private static void performOperation(int operation) {
        switch (operation) {
            case 1 -> System.out.println("Performing Addition...");
            case 2 -> System.out.println("Performing Subtraction...");
            case 3 -> System.out.println("Performing Division...");
            case 4 -> System.out.println("Performing Multiplication...");
            case 5 -> System.out.println("Performing Factorial...");
            case 6 -> System.out.println("Performing Binary to Decimal...");
            case 7 -> System.out.println("Performing Square Root...");
            default -> System.out.println("Invalid operation.");
        }
        // Here you would call the corresponding method to perform the actual operation
    }
}

/*
Here are the problems in your original code:
Resource Management: The Scanner object should be closed to prevent resource leaks.(You will learn this later i guess)
Design Consideration: Using the selectOperator method to only print the selected operation might not be very useful. It should return the selected operation and then you can perform the operation accordingly in the Calculator class.
Error Handling: No error handling is present for invalid inputs. This can cause the program to crash if the user inputs something other than an integer.
Switch-Case Usability: The switch-case structure inside selectOperator is used only to print statements. This can be done directly when performing the respective operations.
Code Separation: It's better to separate the logic for operations into different methods or classes for better readability and maintainability.
*/


/*
Here are the changes made:
1)Naming convention changes:
Package Name: Changed ReloadThat to reloadThat to follow Java's convention of using lowercase for package names.
Class Names: Operator and Calculator are correctly capitalized.
Field Names: Changed sc to scanner to be more descriptive.
Method Names: Changed selectOperator and closeScanner to camelCase.

2)Other changes:(some concepts here you may notnhave learned yet but go look it up on your own!Its very useful)
Error Handling: Added a try-catch block to handle invalid input and recursively prompt the user until a valid input is received.
Resource Management: Added a closeScanner method to close the Scanner object.
Operation Execution: Moved the actual operation printing to a separate method (performOperation) to keep selectOperator focused on selecting the operation.
Input Validation: Ensured that the selected number is within the valid range (1-7).
*/
