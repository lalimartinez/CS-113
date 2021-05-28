package edu.miracosta.cs113;
import java.util.Scanner;
import java.io.*;

public class MorseCodeDriver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		MorseCodeTree morseTree = new MorseCodeTree();
		int choice;
		String fileName, line, output;
		do {
			System.out.print("\nChoose one of the following"
					+ "\n1) Show morse code table"
					+ "\n2) Decode morse code from a file"
					+ "\n3) Type in line of morse code to decode"
					+ "\n4) Exit"
					+ "\nEnter your choice: ");
			choice = keyboard.nextInt();
			while(choice < 1 || choice > 4) {
				System.out.print("Invalid choice. Enter a choice between 1-4: ");
				choice = keyboard.nextInt();
			}
			switch(choice) {
				case 1:
					String[] alphabet = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**", "*---", "-*-", "*-**",
							"--", "-*", "---", "*--*", "--*-", "*-*", "***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**"
					};
					for(int i = 0; i < alphabet.length; i++)
						System.out.println(morseTree.translateFromMorseCode(alphabet[i]) + "   " + alphabet[i]);
					break;
				case 2:
					keyboard.nextLine();
					System.out.println("\nEnter file name: ");
					fileName = keyboard.nextLine();
					System.out.println("~~~Decoded Morse Code~~~");
					try {
						Scanner file = new Scanner(new File(fileName));
						while(file.hasNextLine()) {
							line = file.nextLine();
							output = morseTree.translateFromMorseCode(line);
							System.out.println(output);
						}
						file.close();
					} catch(FileNotFoundException e) {
						System.out.println("Error opening: " + e.getMessage());
					}
					break;
				case 3:
					keyboard.nextLine();
					System.out.println("\nEnter morse code to decode: ");
					line = keyboard.nextLine();
					output = morseTree.translateFromMorseCode(line);
					System.out.println("Decoded message:\n" + output);
					break;
				case 4:
					System.out.println("Program exited.");
					break;
			}
		}while(choice != 4);
		
		keyboard.close();
		
	}

}
