package ReloadThat;

import java.util.Scanner;

class Operator {
    Scanner sc = new Scanner(System.in);
    int num;
    public int selectOperator(){    //is this okay?
        System.out.println("1 : Addition \n2 : Subtract \n3 : Divide \n4 : Multiply \n5 : Factorial " +
                "\n6 : Binary to Decimal \n7 : Square root");
        System.out.print("Enter your number : ");
        num = sc.nextInt();
        switch (num) {
            case 1 -> System.out.println("Addition");
            case 2 -> System.out.println("Subtract");
            case 3 -> System.out.println("Divide");
            case 4 -> System.out.println("Multiply");
            case 5 -> System.out.println("Factorial");
            case 6 -> System.out.println("Binary to Decimal");
            case 7 -> System.out.println("Square root");
        }
        return num;             // I want to use this num variable to pick certain class & is it possible or should i just go with methods
    }
}

public class Calculator {
    public static void main(String[] args) {
        Operator useroperator = new Operator();
        useroperator.selectOperator();
    }
}
