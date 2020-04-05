import java.io.*;
import java.util.Scanner;
import java.util.*;

public class PartOne {

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("1. Map with just the word \n" +
                "2. Map with scrabble point value \n" +
                "Make a selection: ");

        int choiceOne = scan.nextInt();

        if (choiceOne == 1){

            System.out.print("1. TreeMap \n" +
                    "2. HashMap \n" +
                    "Make a selection: ");

            int choiceTwo = scan.nextInt();

            if (choiceTwo == 1){

                long startTime = System.nanoTime();

                readToTree();

                long estimatedTime = System.nanoTime() - startTime;

                System.out.print("Amount of time: " + estimatedTime);
            }
        }

        else {

            System.out.print("1. TreeMap \n" +
                    "2. HashMap \n" +
                    "Make a selection: ");

            int choiceTwo = scan.nextInt();

            if (choiceTwo == 1){


            }
        }
    }

    public static TreeMap readToTree() {

        TreeMap<String, Integer> tree = new TreeMap<>();

        try {

            Scanner read = new Scanner(new File("file.txt"));

            int i = 0;

            do {

                String line = read.nextLine();

                tree.put(line, i);

                i++;
            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }

        return tree;
    }

    public static HashMap readToHash() {

        HashMap<String, Integer>
    }
}
