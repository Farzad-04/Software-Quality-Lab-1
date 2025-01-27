package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Main program: The entry point of the program. The local time will be printed first,
 * Then it will create two binary variables, perform operations, and print the results.
 */
public class App {
    /**
     * Main program entry point
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // Print the current local time
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Input the first binary number
        System.out.println("Enter the first binary number:");
        String input1 = scanner.nextLine();
        Binary binary1 = new Binary(input1);
        System.out.println("First binary number is: " + binary1.getValue());

        // Input the second binary number
        System.out.println("Enter the second binary number:");
        String input2 = scanner.nextLine();
        Binary binary2 = new Binary(input2);
        System.out.println("Second binary number is: " + binary2.getValue());

        // Perform addition
        Binary sum = Binary.add(binary1, binary2);
        System.out.println("Their summation is: " + sum.getValue());

        // Perform OR operation
        Binary orResult = Binary.or(binary1, binary2);
        System.out.println("The result of OR operation is: " + orResult.getValue());

        // Perform AND operation
        Binary andResult = Binary.and(binary1, binary2);
        System.out.println("The result of AND operation is: " + andResult.getValue());

        // Perform Multiply operation
        Binary multiplyResult = Binary.multiply(binary1, binary2);
        System.out.println("The result of Multiplication is: " + multiplyResult.getValue());

        scanner.close();
    }
}