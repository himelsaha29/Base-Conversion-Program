
import acm.program.ConsoleProgram;

/**
 * This program converts numbers from one base to another
 *
 * @author HimelSaha
 *
 */
public class BaseConv extends ConsoleProgram {

    public void run() {
        println("Base conversion program");                                           // Prints the function of the program

        while (true) {
            String inputNum = (readLine("Enter a number (Base 2-16): ")).trim();      // Prompting user for input. Trimmed to avoid
            if (inputNum.equals("")) {                                                // white spaces around the string if there are any.
                println("Program terminated.");                                       // Indicates end of program
                break;
            }
            int inputBase = readInt("Enter the corresponding base as an integer: ");  // The corresponding base of input string

            int numBase10 = String2Integer(inputNum, inputBase);
            println("The decimal equivalent of your input is: " + numBase10);         // Prints the integer(base 10) equivalent
                                                                                      // to the input number

            int targetBase = readInt("Enter the target base for conversion (2-16): ");
            String output = Dec2Base(numBase10, targetBase);
            println(inputNum + " Base-" + inputBase + " ---> " + output + " Base-" + targetBase);
            println();

        }
    }

    /**
     * String2Integer method converts the string representation of the value passed by user to integer.
     * @param input, the string representation of the number to be converted
     * @param inBase, the corresponding base of the input number
     * @return the corresponding integer value converted from string representation
     */
    
    
    private int String2Integer(String input, int inBase) {
        int power = 1;
        int sum = 0;
        int digit;

        for (int i = input.length() - 1; i >= 0; i--) {                         // Iterating through the characters of the string
            digit = Char2Integer(input.charAt(i));                              // Passing each character to Char2Int method to 
            sum += (digit * power);                                             // to convert to int primitive type.
            power *= inBase;
        }
        return sum;
    }

    /**
     * Char2Integer method converts each character of the string representation to corresponding integer value.
     * @param ch, the character to be converted to corresponding integer value
     * @return the integer equivalent of the character
     */
    
    
    private int Char2Integer(char ch) {

        if (ch == 'a' || ch == 'A') {                                           // Specific return values for 'a'/'A' to 'f'/'F' inclusive
            return 10;
        } else if (ch == 'b' || ch == 'B') {
            return 11;
        } else if (ch == 'c' || ch == 'C') {
            return 12;
        } else if (ch == 'd' || ch == 'D') {
            return 13;
        } else if (ch == 'e' || ch == 'E') {
            return 14;
        } else if (ch == 'f' || ch == 'F') {
            return 15;
        } else {                                                                // Else returns the following evaluated value
            int characterInInt = ch - '0';                                      // Converting from character to integer equivalent
            return characterInInt;
        }
    }
    
    /**
     * Dec2Base method generates a string corresponding to an integer value in specified base
     * @param numBase10, the decimal (base 10) value to be converted
     * @param targetBase, the base to which the decimal value is to be converted, i.e. target base for conversion
     * @return a list of integers in target base formatted as string
     */

    private String Dec2Base(int numBase10, int targetBase) {
        String finalNum = "";
        while (numBase10 > 0) {
            int currentBit = numBase10 % targetBase;                            // Getting the remainder
            numBase10 /= targetBase;                                            // Shifting towards most significant digit
            char charDigit = Int2Char(currentBit);
            finalNum = charDigit + finalNum;
        }
        return finalNum;
    }
    
    /**
     * Int2Char method converts an integer to corresponding character code
     * @param digit, a single integer to be converted in the range [0, 15]
     * @return single character corresponding to input digit
     */

    char Int2Char(int digit) {                                                  
        if (digit >= 0 && digit <= 9) {
            char charOfInt = (char) ('0' + digit);                              // Type casting to avoid lossy conversion
            return charOfInt;                                                   // from int to char

        } else if (digit >= 10 && digit <= 15) {                                
            char charOfInt = (char) ('a' + digit - 10);                         // Type casting to avoid lossy conversion
            return charOfInt;                                                   // from int to char
        } else {
            return '0';
        }
    }

}
