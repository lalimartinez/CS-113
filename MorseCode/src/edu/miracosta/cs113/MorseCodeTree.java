package edu.miracosta.cs113;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {
    
    public MorseCodeTree() {
    	mRoot = new Node<Character>(' ');
    	readMorseCodeTree();
    }
	// TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.

    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public void readMorseCodeTree() {
    	try {
    		Scanner file = new Scanner(new File("MorseCode.txt"));
    		while(file.hasNextLine()) {
    			String line = file.nextLine();
    			Node<Character> temp = new Node<Character>(line.charAt(0));
    			String morse = line.substring(2);
    			Node<Character> current = mRoot;
    			for(int i = 0; i < (morse.length() - 1); i++) {
    				if(morse.charAt(i) == '*')
    					current = current.mLeft;
    				else
    					current = current.mRight;
    			}
    			if(morse.charAt(morse.length() - 1) == '*')
    				current.mLeft = temp;
    			else
    				current.mRight = temp;
    		}
    		file.close();
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("Error opening: " + e.getMessage());
    	}
    }
	
	public String translateFromMorseCode(String morseCode) {
        String[] morseArray = morseCode.split(" ");
        Node<Character> current = mRoot;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < morseArray.length; i++) {
        	for(int j = 0; j < morseArray[i].length(); j++) {
        		if(morseArray[i].charAt(j) == '*')
        			current = current.mLeft;
        		else if(morseArray[i].charAt(j) == '-')
        			current = current.mRight;
        		else
        			throw new InputMismatchException();
        	}
        	sb.append(current.mData);
        }
		return sb.toString();
    }

} // End of class MorseCodeTree