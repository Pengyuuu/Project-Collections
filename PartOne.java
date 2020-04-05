import java.io.*;
import java.util.Scanner;
import java.util.*;

public class PartOne {

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("1. TreeMap \n" +
                "2. HashMap \n" +
                "Make a selection: ");

        int choiceOne = scan.nextInt();

        if (choiceOne == 1){

            TreeMap<String, Integer> scrabbleTree = scrabbleToTree();

            long startTime = System.nanoTime();

            readToTree(scrabbleTree);

            long estimatedTime = System.nanoTime() - startTime;

            System.out.print("Amount of time: " + estimatedTime);
        }


        else {

        }
    }

    public static TreeMap readToTree(TreeMap scrabbleTree) {

        TreeMap<String, Integer> tree = new TreeMap<>();

        try {

            Scanner read = new Scanner(new File("file.txt"));

            do {

                String line = read.nextLine();

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

    public static TreeMap scrabbleToTree() {

        TreeMap<String, Integer> scrabbleTree = new TreeMap<>();

        try {

            Scanner read = new Scanner(new File("scrabble.txt"));

            do {

                String [] line = read.nextLine().split(";");

                String letter = line[0];

                int value = Integer.parseInt(line[1]);

                scrabbleTree.put(letter, value);
            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf) {

            System.out.println("File not found");
        }

        return scrabbleTree;
    }

    public static HashMap scrabbleToHash() {

        HashMap<String, Integer> scrabbleHash = new HashMap<>();

        try {

            Scanner read = new Scanner(new File("scrabble.txt"));

            do {

                String [] line = read.nextLine().split(";");

                String letter = line [0];

                int value = Integer.parseInt(line[1]);

                scrabbleHash.put(letter, value);
            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf) {

            System.out.println("File not found");
        }

        return scrabbleHash;
    }

    public static int findValueInTree(TreeMap scrabbleTree, String n) {

        try {
            int value = scrabbleTree.get(n);


        return value;
    }
}
