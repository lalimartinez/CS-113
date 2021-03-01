package edu.miracosta.cs113.lab3;

public class program1 {
	public static void main(String[] args) {
		int y1, y2;
		System.out.printf("%s%10s%10s%n", "n", "y1", "y2");
		System.out.println("----------------------");
		for(int i=0; i <= 100; i+=10) {
			y1 = 100 * i +10;
			y2 = 5 * i * i + 2;
			System.out.printf("%s%10s%10s%n", i, y1, y2);
		}
	}
}
