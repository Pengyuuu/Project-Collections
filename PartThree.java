import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;


public class PartThree {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("1. ArrayList \n" +
                "2. LinkedList \n" +
                "Make a selection: ");

        int choiceOne = scan.nextInt();

        System.out.println("How many teams? ");
        int numTeams = scan.nextInt();

        System.out.println("What element do you want to work with. Enter a number between 1 and 100.");
        int element = scan.nextInt();


        if (choiceOne == 1) {
            ArrayList<ArrayList> teams = new ArrayList<>(numTeams);

            long startTime = System.nanoTime();
            ArrayList<String> list = loadArrayList();
            Iterator iterator = list.iterator();
            ListIterator backwards = list.listIterator();

            while (iterator.hasNext()) {
                iterator.next();
            }
            while (backwards.hasPrevious()) {
                backwards.previous();
            }

            long estimatedTime = System.nanoTime() - startTime;

           System.out.println(list.toString());
           System.out.print("Amount of time to load to Arraylist: " + estimatedTime);


           // shuffling and adding to teams
            startTime = System.nanoTime();

            for (int i = 0; i < numTeams; i ++) {
               list = loadArrayList();
               Collections.shuffle(list);
               teams.add(list);
           }

            estimatedTime = System.nanoTime() - startTime;
            System.out.print("Amount of time to load to Arraylist to teams: " + estimatedTime);


            // retrieving and inserting elements




        }

        else {

            LinkedList<LinkedList> teams = new LinkedList();

            long startTime = System.nanoTime();
            LinkedList<String> list = loadLinked();
            Iterator iterator = list.iterator();
            ListIterator backwards = list.listIterator();


            while (iterator.hasNext()) {
                iterator.next();
            }
            while (backwards.hasPrevious()) {
                backwards.previous();
            }

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println(list.toString());
            System.out.print("Amount of time to load to Linked List: " + estimatedTime);


            // shuffling and adding to teams
            startTime = System.nanoTime();

            for (int i = 0; i < numTeams; i ++) {
                list = loadLinked();
                Collections.shuffle(list);
                teams.add(list);
            }

            estimatedTime = System.nanoTime() - startTime;
            System.out.print("Amount of time to load to Linked List to teams: " + estimatedTime);





        }


    }


    public static ArrayList<String> loadArrayList() {

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


        return list;

    }

    public static LinkedList loadLinked() {

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

        return list;

    }




}
