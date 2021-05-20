package edu.miracosta.cs113;
import java.util.HashSet;

import java.util.Set;
import java.io.*;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {
	private static final Set<String> combos = new HashSet<String>();
	private final static int coins[] = {25, 10, 5, 1};
    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
    	combos.clear();
        makeChange(cents, 0, 0, 0, cents);
        return combos.size();
    }
    
    private static void makeChange(int total, int q, int d, int n, int p) {
    	final int quarter = coins[0], dime = coins[1], nickel = coins[2], penny = coins[3];
    	
    	if(q * quarter + d * dime + n * nickel + p * penny > total)
    		return;
    	
    	String s = "[" + q + ", " + d + ", " + n + ", " + p + "]";
    	if(!combos.contains(s))
    		combos.add(s);
    	
    	if(p >= 5)
    		makeChange(total, q, d, n + 1, p - 5);
    	if(p >= 10)
    		makeChange(total, q, d + 1, n, p - 10);
    	if(p >= 25)
    		makeChange(total, q + 1, d, n, p - 25);
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.
    	calculateChange(cents);
    	String fileName = "CoinCombinations.txt";
    	try {
    		//File file = new File(fileName);
    		FileWriter fileWrite = new FileWriter(fileName);
    		for(String s : combos) 
    			fileWrite.write(s + "\n");
    		fileWrite.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }

} // End of class ChangeCalculator