/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so03convertnumbertoword;

/**
 *
 * S03-Program to convert number to word
 *
 * @author CE182093 - Thai Ba Sinl
 *
 * The ConvertNumberToWord class provides methods for converting a numeric value
 * to its word representation and handling user input.
 */
public class ConvertNumberToWord {

    // Instance variable to store the entered number
    private long number;

    /**
     * Default constructor for the ConvertNumberToWord class.
     */
    public ConvertNumberToWord() {
    }

    /**
     * Constructor with an argument to set the initial value of 'number'.
     *
     * @param number The initial value of the 'number' instance variable.
     */
    public ConvertNumberToWord(long number) {
        this.number = number;
    }

    /**
     * Getter method to retrieve the value of the 'number' instance variable.
     *
     * @return The current value of the 'number' instance variable.
     */
    public long getNumber() {
        return number;
    }

    /**
     * Setter method to set the value of the 'number' instance variable.
     *
     * @param number The new value to set for the 'number' instance variable.
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * Method to prompt the user to enter a number within a specified range.
     */
    public void enterNumber() {
        // Prompt the user to enter a number using the MyLib class
        this.number = mylib.MyLib.getLong("Please enter string in numeric format: ", "Must be a valid long within the range of -999999999999999999L to 99999999999999999L!", -999999999999999999L, 99999999999999999L);
    }

    /**
     * Method to display the converted string representation of the entered
     * number.
     */
    public void displayConvertedString() {
        // Display the converted string
        System.out.print("The converted string: ");
        System.out.print(convertNumberToWord(this.number) + "\n");
    }

    /**
     * Method to convert a number to its word representation.
     *
     * @param number The number to be converted.
     * @return The word representation of the number.
     */
    public String convertNumberToWord(long number) {
        // Base case: if the number is zero
        if (number == 0) {
            return "Zero";
        }

        // If the number is negative, add "Minus" and convert the absolute value
        if (number < 0) {
            return "Minus " + convertNumberToWord(Math.abs(number));
        }

        // StringBuilder to store the words
        StringBuilder words = new StringBuilder();

        // Convert billions
        if (Math.floorDiv(number, 1000000000) > 0) {
            words.append(convertNumberToWord(Math.floorDiv(number, 1000000000))).append(" Billion ");
            number %= 1000000000;
        }

        // Convert millions
        if (Math.floorDiv(number, 1000000) > 0) {
            words.append(convertNumberToWord(Math.floorDiv(number, 1000000))).append(" Million ");
            number %= 1000000;
        }

        // Convert thousands
        if (Math.floorDiv(number, 1000) > 0) {
            words.append(convertNumberToWord(Math.floorDiv(number, 1000))).append(" Thousand ");
            number %= 1000;
        }

        // Convert hundreds
        if (Math.floorDiv(number, 100) > 0) {
            words.append(convertNumberToWord(Math.floorDiv(number, 100))).append(" Hundred ");
            number %= 100;
        }

        // Check if there are more digits remaining
        if (number > 0) {
            // Add "and" if there are already some words in the StringBuilder
            if (words.length() > 0) {
                words.append("and ");
            }

            // Arrays to map units and tens
            String[] unitsMap = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            String[] tensMap = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            // Check if the number is less than 20
            if (number < 20) {
                words.append(unitsMap[(int) number]);
            } else {
                // Add the tens part
                words.append(tensMap[Math.floorDiv((int) number, 10)]);

                // Add the units part if it's greater than 0
                if ((number % 10) > 0) {
                    words.append("-").append(unitsMap[(int) (number % 10)]);
                }
            }
        }

        // Return the final string representation
        return words.toString().trim();
    }
}
