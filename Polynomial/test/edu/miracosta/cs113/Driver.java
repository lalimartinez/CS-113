package edu.miracosta.cs113;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int choice, choice2;
		Polynomial poly1 = new Polynomial(), poly2 = new Polynomial();
		String polyToAdd, yesNo;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.println("\nChoose one of the following: ");
			System.out.println("1. Edit first polynomial "
					+ "\n2. Edit second polynomial "
					+ "\n3. Add the polynomials "
					+ "\n4. Exit");
			System.out.print("Enter your choice: ");
			choice = keyboard.nextInt();
			while(choice < 1 || choice > 4) {
				System.out.print("Invalid choice. Please enter a choice 1-4: ");
				choice = keyboard.nextInt();
			}
			
			switch(choice) {
			case 1:
				System.out.println("\nPick one of the following:");
				System.out.println("1. Create a new polynomial"
						+ "\n2. Add to polynomial"
						+ "\n3. Clear polynimial");
				System.out.print("Enter your choice: ");
				choice2 = keyboard.nextInt();
				while(choice < 1 || choice > 3) {
					System.out.print("Invalid choice. Please enter a choice 1-3: ");
					choice2 = keyboard.nextInt();
				}
				switch(choice2) {
				case 1:
					poly1 = new Polynomial();
					System.out.println("\nNew polynomial created");
					break;
				case 2:
					do {
					keyboard.nextLine();
					System.out.println("Enter term(s) to add with spaces in between each term:");
					System.out.println("Example: 4x^2 -5x -6x^3 +7");
					polyToAdd = keyboard.nextLine();
					String [] terms = polyToAdd.split(" ");
					Term t[] =  new Term[terms.length];
					for(int i = 0; i < terms.length; i++) 
						t[i] = new Term(terms[i]);
					for(int i = 0; i < t.length; i++)
						poly1.addTerm(t[i]);
					System.out.print("Would you like to enter another term or polynomail (yes/no)? ");
					yesNo = keyboard.nextLine();
					} while(yesNo.equalsIgnoreCase("yes"));
					System.out.println("\nHere is your second polynomial: \n"
							+ poly1.toString());
					break;
				case 3:
					poly1.clear();
					System.out.println("\nPolynomial cleared.");
					break;
				}
				break;
			
			case 2:
				System.out.println("\nPick one of the following:");
				System.out.println("1. Create a new polynomial"
						+ "\n2. Add to polynomial"
						+ "\n3. Clear polynimial");
				System.out.print("Enter your choice: ");
				choice2 = keyboard.nextInt();
				while(choice < 1 || choice > 3) {
					System.out.print("Invalid choice. Please enter a choice 1-3: ");
					choice2 = keyboard.nextInt();
				}
				switch(choice2) {
				case 1:
					poly2 = new Polynomial();
					System.out.println("\nNew polynomial created");
					break;
				case 2:
					do {
					keyboard.nextLine();
					System.out.println("Enter term(s) to add with spaces in bewteen each term:");
					System.out.println("Example: 4x^2 -5x -6x^3 +7");
					polyToAdd = keyboard.nextLine();
					String [] terms = polyToAdd.split(" ");
					Term t[] =  new Term[terms.length];
					for(int i = 0; i < terms.length; i++) 
						t[i] = new Term(terms[i]);
					for(int i = 0; i < t.length; i++)
						poly2.addTerm(t[i]);
					System.out.print("Would you like to enter another term or polynomail (yes/no)? ");
					yesNo = keyboard.nextLine();
					} while(yesNo.equalsIgnoreCase("yes"));
					System.out.println("\nHere is your first polynomial: \n"
							+ poly2.toString());
					break;
				case 3:
					poly2.clear();
					System.out.println("\nPolynomial cleared.");
					break;
				}
				break;
				
			case 3:
				Polynomial addedPoly = new Polynomial();
				addedPoly.add(poly1);
				addedPoly.add(poly2);
				System.out.println("\nYour two polynomials added together:\n" + addedPoly.toString());
				break;
				
			case 4:
				System.out.println("\nProgram exited.");
				break;
			}
			
		}while(choice != 4);
		
		keyboard.close();
	}

}
