package assignment6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class assaignment6 {
   public static void main(String[] args) {
	  int x;
	  Scanner scan = new Scanner(System.in);
	  x=scan.nextInt();
	  Random rnd = new Random();
	  int satr = rnd.nextInt(x)+1;
	  ArrayList<ArrayList> array = new ArrayList<ArrayList>();
	  for(int i=0;i<satr;i++) {
		  ArrayList<Integer> arr = new ArrayList<Integer>();
		 int soton = rnd.nextInt(x)+1;
		 for(int j=0;j<soton;j++) {
			 int random = rnd.nextInt(x);
			 arr.add(random);
		 }
		 array.add(arr);
	  }
	  for(int i=0;i<array.size();i++) {
		  for(int j=0;j<array.get(i).size();j++) {
			  System.out.print(array.get(i).get(j)+" ");
		  }
		  System.out.println(" ");
	  }
   }
}
