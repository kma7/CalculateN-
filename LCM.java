package ds.basic;

import java.util.Scanner;

public class LCM {
	private static Scanner scanner;

	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		int rem = a % b;
		return gcd(b, rem);
	}
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();
	    int greatestCD = gcd(a, b);
	    long lcm = (long) (a/greatestCD * b/greatestCD);
	    System.out.println(lcm);
	}

}
