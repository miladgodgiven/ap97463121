package assignment4;

import java.util.Scanner;

public class assignment4 {
   public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
		
		int a,b;double num_ran;
		
		
		System.out.println("Enter a,b for matrix a*b :");
		a=input.nextInt();
		b=input.nextInt();
		int matris [][] = new int[a][b];
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				num_ran = Math.random();
				num_ran = num_ran*100;
				matris[i][j] =(int)num_ran ;
			}
		}
		
		
		for (int i = 0; i < a ; i++) {
			for (int j = 0; j < b; j++) {
			System.out.print(matris[i][j] + "\t");
			}
			System.out.println();
		}
		
	while (true) {
    	 char[] sort_cmd = input.next().toCharArray();
    	 
    	 if (sort_cmd[0]=='r') {
    		 sortrows(matris,Character.getNumericValue(sort_cmd[1]));
    		 print_matris(matris);
    	 }else if(sort_cmd[0]=='c') {
    		 sortcolumn(matris, Character.getNumericValue(sort_cmd[1]));
    		 print_matris(matris);
    	 }
    	 else {
    		 System.out.println("unknow command!");
    	 }
	}
		
   }
   public static void sortrows(int matris[][],int r_matris) {
       if (r_matris > matris.length - 1) {
           System.out.println(">> Out of length <<");
       } else {
           for (int n = 0; n < matris.length; n++) {
               for (int i = 0; i < matris.length; i++) {
                   for (int i2 = i+1; i2 < matris.length; i2++) {
                       if (matris[r_matris][i] > matris[r_matris][i2]) {
                           int temp = matris[r_matris][i];
                           matris[r_matris][i] = matris[r_matris][i2];
                           matris[r_matris][i2] = temp;
   }}}}}
   }
   
   public static void sortcolumn(int matris[][],int c_matris) {
       if (c_matris > matris[0].length - 1) {
           System.out.println(">> out of length <<");
       } else {
           for (int n = 0; n < matris[0].length; n++) {
               for (int j = 0; j < matris[0].length; j++) {
                   for (int j2 = j+1; j2 < matris.length; j2++) {
                       if (matris[j][c_matris] > matris[j2][c_matris]) {
                           int temp = matris[j2][c_matris];
                           matris[j2][c_matris] = matris[j][c_matris];
                           matris[j][c_matris] = temp;
   }}}}}
   }
   
   public static void print_matris(int matris[][]) {

	   for (int i = 0; i < matris.length ; i++) {
			for (int j = 0; j < matris.length; j++) {
			System.out.print(matris[i][j] + "\t");
			}
			System.out.println();
		}
   }
   
}

