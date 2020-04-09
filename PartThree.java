import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;


public class PartThree {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("1. ArrayList \n" +
                "2. LinkedList \n" +
                "Make a selection: ");

        int choiceOne = scan.nextInt();

        System.out.println("How many teams? ");
        int teams = scan.nextInt();

        System.out.println("What element do you want to work with. Enter a number between 1 and 100.");
        int element = scan.nextInt();


        if (choiceOne == 1) {
           ArrayList<String> list = loadArrayList();


        }

        else {
            LinkedList<String> list = new LinkedList<String>();
        }


    }


    public static ArrayList loadArrayList() {
        long startTime = System.nanoTime();

        ArrayList<String> list = new ArrayList<String>();

        try {

            Scanner read = new Scanner(new File("items.txt"));

            do {

                String line = read.nextLine();
                list.add(line);

            }

            while (read.hasNext());
            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }


        long estimatedTime = System.nanoTime() - startTime;
        System.out.print("Amount of time to load to Arraylist: " + estimatedTime);

        return list;

    }

    public static LinkedList loadLinked() {
        long startTime = System.nanoTime();

        LinkedList<String> list = new LinkedList<>();

        try {

            Scanner read = new Scanner(new File("items.txt"));

            do {

                String line = read.nextLine();
                list.add(line);

            }

            while (read.hasNext());
            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.print("Amount of time to load to Linked List: " + estimatedTime);

        return list;

    }




}
