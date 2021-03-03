package edu.miracosta.cs113.lab4;

public class DirectoryDriver {
	public static void main(String[] args) {
		Directory mine = new Directory();
		
		mine.addOrChangeEntry("Sally", "858-323-678");
		mine.addOrChangeEntry("John", "760-645-1112");
		mine.addOrChangeEntry("Phil", "626-890-3412");
		mine.addOrChangeEntry("Sarah", "619-865-3265");
		
		System.out.println("My Directory: ");
		System.out.println(mine.toString());
		
		System.out.println("\nDirectory after changing Sarah's number: ");
		mine.addOrChangeEntry("Sarah", "619-365-9060");
		System.out.println(mine.toString());
		
		System.out.println("\nDirectory after removing Sally");
		mine.removeEntry("Sally");
		System.out.println(mine.toString());
		
		System.out.println("\nDirectory after removing Phil");
		mine.removeEntry("Phil");
		System.out.println(mine.toString());
		
		System.out.println("\nDirectory after adding Henry");
		mine.addOrChangeEntry("Henry", "543-321-7859");
		System.out.println(mine.toString());
	}

}
