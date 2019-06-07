package assignment9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class assignment9 {


    public static void main(String[] args) {
        long t1 =System.currentTimeMillis();

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);

        System.out.print("\nEnter file full name :");
        String name = input.nextLine();
        System.out.print("Enter location for search :");
        String location = input1.nextLine();
        System.out.print("Enter a number (1 or 2 or 3) for Level of search :");
        int num = input.nextInt();


        File scan = new File(location);
        if (scan.isDirectory()) {
            filefind(name, location,num);
        } else {
            System.out.println("\nLocation is not a Directory");
        }

        long t2=System.currentTimeMillis()-t1;
        System.out.println("\nrun time =>"+t2+"ms");
        try {
            FileWriter writer = new FileWriter("data.txt",true);
            writer.write(""+t2+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void filefind(String name, String location, int num) {

        boolean answer = true;

        if (num == 1) {
            if (answer == true) {
                answer = search_L_1(name, location);
            }
            if (answer == false) {
                System.out.println("\n!!!FILE NOT FOUNDED!!!");
            }
        }
        if (num == 2) {
            if (answer == true) {
                answer = search_L_1(name, location);
            }
            if (answer == false) {
                answer = search_L_2(name, location);
            }
            if (answer == false) {
                System.out.println("\n!!!FILE NOT FOUNDED!!!");
            }
        }
        if (num == 3) {
            if (answer == true) {
                answer = search_L_1(name, location);
            }
            if (answer == false) {
                answer = search_L_2(name, location);
            }
            if (answer == false) {
                answer = search_L_3(name, location);
            }
            if (answer == false) {
                System.out.println("\n!!!FILE NOT FOUNDED!!!");
            }
        }
    }

    public static boolean search_L_1(String name,String location){
        boolean answer=false;
        File drive = new File(location);
        if(drive.isDirectory()) {
            File[] list = drive.listFiles();
            for (int i = 0; i < list.length; i++) {
                if (name.equals(list[i].getName())) {
                    System.out.println("\n>>FILE FOUNDED<<");
                    System.out.println("File Address => "+list[i].getPath());
                    data_saver(name);
                    data_saver(list[i].getPath());
                    answer=true;
                    break;
                }
            }
        }
        return answer;
    }
    public static boolean search_L_2(String name,String location){
        boolean answer=false;
        File drive = new File(location);
        File[] folderlist = drive.listFiles();
        for(int i=0;i<folderlist.length;i++){
            if(folderlist[i].isDirectory() && folderlist[i].getName().equals("System Volume Information")==false){
                answer=search_L_1(name,folderlist[i].getPath());
                if (answer==true){
                    break;
                }
            }
        }
        return answer;
    }
    public static boolean search_L_3(String name,String location){
        boolean answer=false;
        File drive = new File(location);
        File[] folderlist = drive.listFiles();
        for(int i=0;i<folderlist.length;i++){
            if(folderlist[i].isDirectory() && folderlist[i].getName().equals("System Volume Information")==false){
                answer=search_L_2(name,folderlist[i].getPath());
                if (answer==true) {
                    break;
                }
            }
        }
        return answer;
    }
    public static void data_saver(String data){
        try {
        FileWriter writer = new FileWriter("data.txt",true);
        writer.write(data+"    ");
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//System.out.println("1")