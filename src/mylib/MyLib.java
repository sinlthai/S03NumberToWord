/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.util.Scanner;

/**
 * S03-Program to convert number to word
 *
 * @author CE182093 - Thai Ba Sinl
 *
 * The MyLib class provides input/output utility methods for handling user input
 * in the console.
 */
public class MyLib {

    /**
     * Scanner object to read input from the console.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Function is used to enter a string with specified length constraints.
     *
     * @param iMg input message displayed to the user
     * @param eMg error message displayed when invalid input is provided
     * @return a validated string from the user
     */
    public static String getString(String iMg, String eMg) {
        // Declare a string variable to store user input
        String x;

        // Infinite loop to keep asking for input until valid input is provided
        while (true) {
            try {
                // Display input message
                System.out.print(iMg);

                // Read a line of input and attempt to trim leading and trailing whitespaces (result not assigned back)
                x = sc.nextLine();

                // Check if the entered string is empty or if it is equal to "Y" or "N" (case-insensitive)
                if (x.isEmpty()
                        || (!x.equalsIgnoreCase("Y") && !x.equalsIgnoreCase("y")
                        && !x.equalsIgnoreCase("N") && !x.equalsIgnoreCase("n"))) {
                    // If not valid, throw an exception
                    throw new Exception();
                }

                // If valid input, return the entered string
                return x;

            } catch (Exception e) {
                // Catch any exceptions thrown and print the error message
                System.out.println(eMg);
            }
        }
    }

    /**
     * Function is used to enter a long integer number within a specified range.
     *
     * @param iMg input message displayed to the user
     * @param eMg error message displayed when invalid input is provided
     * @param from lower limit of the allowed range
     * @param to upper limit of the allowed range
     * @return a validated long integer from the user within the specified range
     */
    public static long getLong(String iMg, String eMg, long from, long to) {
        // Declare a long variable to store user input
        long x;

        // Infinite loop to keep asking for input until valid input is provided
        while (true) {
            try {
                // Swap 'from' and 'to' if 'from' is greater than 'to' to ensure 'from' is the lower limit
                if (from > to) {
                    long temp = from;
                    from = to;
                    to = temp;
                }

                // Display input message
                System.out.print(iMg);

                // Read a long integer input from the user
                x = Long.parseLong(sc.nextLine());

                // Check if the entered long integer is within the specified range
                if (x < from || x > to) {
                    // If not valid, throw an exception
                    throw new Exception();
                }

                // If valid input, return the entered long integer
                return x;

            } catch (Exception e) {
                // Catch any exceptions thrown and print the error message
                System.out.println(eMg);
            }
        }
    }

}
