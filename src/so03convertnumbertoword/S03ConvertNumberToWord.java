/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so03convertnumbertoword;

/**
 * S03-Program to convert number to word
 *
 * @author CE182093 - Thai Ba Sinl
 *
 * This Java program takes user input for a number and converts it into its word
 * representation. It utilizes the ConvertNumberToWord class for handling the
 * conversion process.
 *
 */
public class S03ConvertNumberToWord {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creation of an instance of the ConvertNumberToWord class

        ConvertNumberToWord numberToWord = new ConvertNumberToWord();

        // String variable to store user input for continuation
        String op;

        // Do-while loop to repeatedly execute the following block of code
        do {
            // Prompt the user to enter a number and store it in the ConvertNumberToWord instance
            numberToWord.enterNumber();

            // Display the converted string representation of the entered number
            numberToWord.displayConvertedString();

            // Prompt the user to continue and store the response in the 'op' variable
            op = mylib.MyLib.getString("Do you want to continue? (Y/N) ", "Invalid choice. Please enter only y/Y or n/N");

            // Continue looping while the user's response is not 'N' (case-insensitive)
        } while (!op.equalsIgnoreCase("N"));
    }
}
