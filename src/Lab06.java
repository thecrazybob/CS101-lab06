import java.util.Scanner;

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

        Scanner scan = new Scanner(System.in);

        // constants
        final String SEPARATOR = "----------";

        // variables
        String first_binary_string;
        String second_binary_string;
        int first_decimal_int;
        int second_decimal_int;

        String text_to_be_reversed;

        double x_for_calculating_sin;
        double minus_1_power_n;
        double x_power_2n_plus_1;
        double factorial_2n_plus_1;
        double calculated_term;
        double sum;

        System.out.println(SEPARATOR);

        System.out.println("Raw output of methods:");

        System.out.println(SEPARATOR);

        System.out.println("Result of 'power' method: " + power(2,4));
        System.out.println("Result of 'factorial' method: " + factorial(7));
        System.out.println("Result of 'reverse' method: " + reverse("abcd"));
        System.out.println("Result of 'toDecimal' method: " + toDecimal("1011"));
        System.out.println("Result of 'decimalToBinary' method: " + decimalToBinary(11));

        // 1. print a table with columns n, n-squared, n-cubed & n to the power 4, for values of n from -1 to 10 inclusive
        
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 1: ");

        System.out.println(SEPARATOR);
        
        for (int i = -1; i <= 10; i++) {
            System.out.println("n: " + i + " | " + "n-squared: " + power(i, 2) + " | " + "n-cubed: " + power(i, 3) + " | " + "n-power-four: " + power(i, 4));
        }
        
        // 2. print a table of n and n-factorial, for values of n from 1 to 15
        
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 2: ");

        System.out.println(SEPARATOR);
        
        for (int i = 1; i <= 15; i++) {
            System.out.println("n: " + i + " | " + "n-factorial: " + factorial(i));
        }
        
        // 3. read two binary (base-2) Strings from the user, convert them to decimal,
        // then add them together and print the result in binary form.
        
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 3: ");

        System.out.println(SEPARATOR);

        System.out.println("Please input the first binary string: ");
        first_binary_string = scan.nextLine();
        
        System.out.println("Please input the second binary string: ");
        second_binary_string = scan.nextLine();

        first_decimal_int = toDecimal(first_binary_string);
        System.out.println("first_decimal_int: " + first_decimal_int);
        
        second_decimal_int = toDecimal(second_binary_string);
        System.out.println("second_decimal_int: " + second_decimal_int);

        System.out.println("first_decimal_int + second_decimal_int: " + (first_decimal_int + second_decimal_int));
        System.out.println(decimalToBinary(first_decimal_int + second_decimal_int));
        
        /*
        4.
        read a line of text from the user and output it again,
        but with each word reversed.
        For instance, were the user to enter "gnimmargorP si nuf",
        your program should output "Programming is fun".
        */
        
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 4:");

        System.out.println(SEPARATOR);

        System.out.println("Please input the text to be reversed:");
        text_to_be_reversed = scan.nextLine();

        String[] words = text_to_be_reversed.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            System.out.print(reverse(words[i]) + " ");
        }

        /*
        5.
        print a table that shows the "raw" calculations for the Taylor series expansion of sin(x),
        where x is read from the user. Your table should have columns for the term number n,
        and for (-1)^n, x^(2n+1), (2n+1)!, the term itself computed from these values, and the sum
        of the preceding terms with this one, i.e. the current approximation to sin(x).
        The term number n should go from 0 up to, say, 10.
        */
        
        System.out.println();
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 5:");

        System.out.println(SEPARATOR);

        System.out.println("Please input the term 'x' for which sin(x) needs to be calculated:");
        x_for_calculating_sin = scan.nextDouble();

        sum = 0;
        for (int n = 0; n <= 10; n++){
            
            minus_1_power_n = power((-1), n);
            x_power_2n_plus_1 = power(x_for_calculating_sin, (2*n)+1);
            factorial_2n_plus_1 = factorial((2*n)+1);
            calculated_term = (minus_1_power_n/factorial_2n_plus_1) * (x_power_2n_plus_1);
            sum += calculated_term;

            System.out.println("n: " + n + " | " + "(-1)^n: " + minus_1_power_n + " | " + "x^(2n+1): " + x_power_2n_plus_1 + " | " + "(2n+1)!: " + factorial_2n_plus_1 + " | " + "term: " + calculated_term + " | " + "sum: " + sum);
        }

        System.out.println("Result of Math.sin() for the given value: " + Math.sin(x_for_calculating_sin));
        System.out.println("Deviation of sum from Math.sin() value: " + (Math.sin(1.5708) - sum));


        /*
        6.
        obviously computing sin(x) like this results in significant errors and is very inefficient!
        A better approach is to compute each term from the previous one (hint: think how can you compute x^5/5! from x^3/3! ).
        Implement sin(x) as a method using this approach and test it by comparing its answers with those from Math.sin(x).
        */

        System.out.println();
        System.out.println(SEPARATOR);

        System.out.println("Now printing out demonstration 6:");

        System.out.println(SEPARATOR);

        sum = 0;

        calculated_term = 0;

        for (int n = 0; n <= 10; n++) {

            minus_1_power_n = power((-1), n);
            x_power_2n_plus_1 = power(x_for_calculating_sin, (2*n)+1);
            factorial_2n_plus_1 = factorial((2*n)+1);

            if (n == 0) {
                sum += x_for_calculating_sin;
            }
            else if (n == 1) {
                calculated_term = (minus_1_power_n/factorial_2n_plus_1) * (x_power_2n_plus_1);
                sum += calculated_term;
            }
            else {
                calculated_term = (((minus_1_power_n) * calculated_term) / ((2*n) + 1) * (2*n));
                sum += calculated_term;
            }

            System.out.println("n : " + n + " | " + "sum: " + sum + " | " + "calculated term: " + calculated_term);

        }

        // close scanner instance
        scan.close();

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

        if (y == 0) {
            result = 1.0;
        }

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
        int binary;

        binary = Integer.parseInt(base2, 2);

        return binary;

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
