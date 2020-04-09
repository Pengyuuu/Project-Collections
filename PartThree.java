import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Random;


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
           System.out.println("Amount of time to load to Arraylist: " + estimatedTime);


           // shuffling and adding to teams
            startTime = System.nanoTime();
            ArrayList<String> hunt = list;

            for (int i = 0; i < numTeams; i ++) {
               list = loadArrayList();
               Collections.shuffle(list);
               teams.add(list);
           }

            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to load to Arraylist to teams: " + estimatedTime);


            // retrieving  elements
            startTime = System.nanoTime();

            for (int i = 0; i < teams.size(); i++) {
                String retrieved = retrieveElementsArray(element, teams.get(i));
                System.out.println(teams.get(i).toString());
                System.out.println("Team #" + (i + 1) + "'s item: " + retrieved);

            }
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to retrieve element #" + element + "from each team: " + estimatedTime);


            // inserting elements
            System.out.println("Enter a new element to be inserted at this position: ");
            String newItem = scan.next();

            startTime = System.nanoTime();

            for (int i = 0; i < teams.size(); i++) {
                String retrieved = retrieveElementsArray(element, teams.get(i));
                System.out.println(teams.get(i).toString());
                System.out.println("Team #" + (i + 1) + "'s item: " + retrieved);
                teams.get(i).add(element, newItem);
            }

            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to insert " + newItem + "at element #" + element + " to teams: " + estimatedTime);


            // random
            startTime = System.nanoTime();

            Random random = new Random();
            int randNum = random.nextInt(100);
            System.out.println("Random number: " + randNum);
            String item = retrieveElementsArray(randNum, hunt);
            System.out.println("Scavenger hunt list retrieved: " + item);

            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to retrieve  element #" + randNum + " (item) " + item + ": " + estimatedTime);

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
            System.out.println("Amount of time to load to Linked List: " + estimatedTime);


            // shuffling and adding to teams
            startTime = System.nanoTime();
            LinkedList<String> hunt = list;


            for (int i = 0; i < numTeams; i ++) {
                list = loadLinked();
                Collections.shuffle(list);
                teams.add(list);
            }

            estimatedTime = System.nanoTime() - startTime;
            System.out.print("Amount of time to load to Linked List to teams: " + estimatedTime);


            // retrieving  elements
            startTime = System.nanoTime();

            for (int i = 0; i < teams.size(); i++) {
                String retrieved = retrieveElementsLinked(element, teams.get(i));
                System.out.println(teams.get(i).toString());
                System.out.println("Team #" + (i + 1) + "'s item: " + retrieved);

            }
            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to retrieve element #" + element + "from each team: " + estimatedTime);


            // inserting elements
            System.out.println("Enter a new element to be inserted at this position: ");
            String newItem = scan.next();

            startTime = System.nanoTime();

            for (int i = 0; i < teams.size(); i++) {
                String retrieved = retrieveElementsLinked(element, teams.get(i));
                System.out.println(teams.get(i).toString());
                System.out.println("Team #" + (i + 1) + "'s item: " + retrieved);
                teams.get(i).add(element, newItem);
            }

            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to insert " + newItem + "at element #" + element + " to teams: " + estimatedTime);


            // random
            startTime = System.nanoTime();

            Random random = new Random();
            int randNum = random.nextInt(100);
            System.out.println("Random number: " + randNum);
            String item = retrieveElementsLinked(randNum, hunt);
            System.out.println("Scavenger hunt list retrieved: " + item);

            estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time to retrieve  element #" + randNum + " (item) " + item + ": " + estimatedTime);

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

    public static String retrieveElementsArray(int element, ArrayList inventory) {

        for (int i = 0; i < inventory.size(); i++) {
            if (i == (element - 1)) {
                return inventory.get(i) + "";
            }
        }
        return "Not found";
    }

    public static String retrieveElementsLinked(int element, LinkedList inventory) {

        for (int i = 0; i < inventory.size(); i++) {
            if (i == (element - 1)) {
                return inventory.get(i) + "";
            }
        }
        return "Not found";
    }

    //@Override
    public String toString(Object[] list) {
        return list.toString();
    }
}
