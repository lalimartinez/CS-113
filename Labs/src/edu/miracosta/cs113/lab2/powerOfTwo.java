package edu.miracosta.cs113.lab2;

public class powerOfTwo {
	static boolean isPowerOfTwo(int num) {
		if(num == 0)
			return false;
		return (int) (Math.ceil((Math.log(num)/Math.log(2)))) == 
				(int) (Math.floor((Math.log(num)/Math.log(2))));
	}
}

