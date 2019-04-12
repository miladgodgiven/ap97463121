package assignment3;

import java.util.Scanner;

public class assignment3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n;double a;
		
		
		System.out.print("Enter n for matrix n*n :");
		n=input.nextInt();
		
		int matris [][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a = Math.random();
				a = a*100;
				matris[i][j] =(int)a ;
			}
		}
		
		
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
			System.out.print(matris[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
		
	}

}
