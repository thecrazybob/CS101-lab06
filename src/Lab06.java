/**
 * Lab06 
 * Instructions for Lab06 are in INSTRUCTIONS.md file located in the root directory of Lab06
 * Revisions can be seen on the following GitHub URL: https://github.com/thecrazybob/CS101-lab06
 * Style Guidelines: http://www.cs.bilkent.edu.tr/~david/cs101/practicalwork/2010/styleguidelines.htm
 * Lab Page: http://www.cs.bilkent.edu.tr/~david/cs101/assignments/lab06/
 * 
 * @author Mohammed Sohail
 * @version 29/11/2020
 */ 

public class Lab06 {
    public static void main(String[] args) throws Exception {

        System.out.println("Raw output of methods:");
        System.out.println("-----");
        System.out.println("Result of 'power' method: " + power(2,4));
        System.out.println("Result of 'factorial' method: " + factorial(7));
        System.out.println("Result of 'reverse' method: " + reverse("abcd"));
        System.out.println("Result of 'toDecimal' method: " + toDecimal("1011"));
        System.out.println("Result of 'decimalToBinary' method: " + decimalToBinary(1011));

        // 1. print a table with columns n, n-squared, n-cubed & n to the power 4, for values of n from -1 to 10 inclusive
        for (int i = -1; i == 10; i++) {
            System.out.println("n: " + i);
        }
        
    }

    /**
     * Computes and returns x to the power y
     * @param x a real value
     * @param y positive integer
     * @return x to the power of y
     */
    public static double power(double x, int y)
    {

        // variables
        double result;

        // initializing variables
        result = x;

        // looping and multiplying the number "y" times
        for (int i = 1; i < y; i++) {
            
            result = result * x;    

        }

        // return result
        return result;

    }

    /**
     * Computes n factorial, where n is a positive integer
     * @param n a positive integer
     * @return factorial of n
     */
    public static int factorial(int n)
    {

        // variables
        int factorial;

        // initializing variables
        factorial = n;

        // looping and multiplying lower number than the factorial
        for (int i = (n - 1); i != 0; i--) {
            factorial = factorial * i;
        }

        // return result
        return factorial;

    }

    /**
     * Returns a String that is the reverse of the input String s
     * @param s a String parameter
     * @return a String that is the reverse of s
     */
    public static String reverse(String s)
    {

        // variables
        int length_of_string;
        String result;

        // initializing variables
        length_of_string = s.length();
        result = "";

        // loop and reverse string s
        for (int i = (length_of_string - 1); i >= 0; i--) {
            result = result + s.charAt(i);
        }

        // return result
        return result;

    }

    /**
     * Converts the given base2 String to its decimal --base10-- equivalent, as an int
     * @param base2 a String parameter
     * @return decimal base10 equivalent
     */
    public static int toDecimal(String base2)
    {

        // variables
        int i;
        int decimal;

        // initializing variables
        i = 0;
        decimal = 0;

        // compute the decimal value from base2 String
        for (i = base2.length() - 1 ; i >= 0 ; i--)
        {

            if (base2.charAt(i) == '1') {

                decimal += power(2, base2.length() - 1 - i);

            }

        }

        return decimal;

    }

    /**
     * Converts a positive decimal int value into the corresponding binary String
     * @param decimal a positive decimal int value
     * @return corresponding binary String of input decimal
     */
    public static String decimalToBinary(int decimal)
    {
        String s = "";

        while (decimal > 0)
        {
            s =  ( (decimal % 2 ) == 0 ? "0" : "1") + s;
            decimal = decimal / 2;
        }

        return s;

    }

}
