/*	Author: Phillip Pham
 * 	Date: 03/23/17
 * 	Course: CSC230	Section: 18043
 * 	
 * 	Program Title: Hardware Multiply
 * 	Program Description: This program is meant to simulate how a machine actually multiplies efficiently without
 * 				just using a single loop that calculates the sum over and over again. It simulates having
 * 				two 32-bit numbers being multiplied and stored as a 64-bit number.
 */

import java.util.Scanner;

public class HWMult
{
	public static void main(String[] args)
	{
		int multiplicand;
		int multiplier;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Hardware Multiply - Phillip Pham\n");
		System.out.print("Multiplier? ");
		multiplier = kb.nextInt();
		System.out.print("Multiplicand? ");
		multiplicand = kb.nextInt();
		
		Multiply m1 = new Multiply(multiplicand, multiplier);
		System.out.println(multiplicand + " x " + multiplier + " = " + m1.getProduct() + "\n");
		
		System.out.println("Java: " + Math.multiplyExact((long)(multiplicand), (long)(multiplier)));
		
		System.exit(0);
	}
}