package assignment2;

import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		
		int a ;
		Scanner input=new Scanner(System.in);
		
		System.out.println("choose diagonal of rhombus (3 | 5 | 7)");
		a = input.nextInt();
		
		if (a==3) {
			System.out.println(" * ");
			System.out.println("***");
			System.out.println(" * ");
		}
		if (a==5) {
			System.out.println("  *  ");
			System.out.println(" *** ");
			System.out.println("*****");
			System.out.println(" *** ");
			System.out.println("  *  ");

		}
		if (a==7) {
			System.out.println("   *   ");
			System.out.println("  ***  ");
			System.out.println(" ***** ");
			System.out.println("*******");
			System.out.println(" ***** ");
			System.out.println("  ***  ");
			System.out.println("   *   ");

		}
		
		
	
	}

}
