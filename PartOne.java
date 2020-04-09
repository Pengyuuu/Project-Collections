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

            HashMap<String, Integer> scrabbleHash = scrabbleToHash();

            long startTime = System.nanoTime();

            readToHash(scrabbleHash);

            long estimatedTime = System.nanoTime() - startTime;

            System.out.print("Amount of time: " + estimatedTime);

        }

    }

    public static TreeMap readToTree(TreeMap scrabbleTree) {

        TreeMap<String, Integer> tree = new TreeMap<>();

        int x = 0;
        try {

            Scanner read = new Scanner(new File("file.txt"));

            do {

                String line = read.nextLine();
                x = findValueInTree(scrabbleTree, line);
                tree.put(line,x);

            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }

        return tree;
    }

    public static HashMap readToHash(HashMap scrabbleHash) {

        HashMap<String, Integer> tree = new HashMap<>();
        int x = 0;

        try {
            Scanner read = new Scanner(new File("file.txt"));

            do {
                String line = read.nextLine();
                x = findValueInHash(scrabbleHash, line);
                tree.put(line,x);
            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        }

        return tree;
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

    public static int findValueInTree(TreeMap scanTree, String n) {

        int total = 0;

        try {

            for (int i = 0; i < n.length(); i++) {
                char letter = n.charAt(i);
                total  += (int) scanTree.get( Character.toString(letter).toUpperCase());

            }

        }

        catch (NullPointerException nullP) {
            System.out.println("No value found." + total);
        }

        return total;
    }

    public static int findValueInHash(HashMap scanHash, String n) {

        int total = 0;

        HashMap<String,Integer> scrabbleHash = new HashMap<String,Integer>(scanHash);

        try {

            for (int i = 0; i < n.length(); i++) {
                char letter = n.charAt(i);
                total  += (int) scanHash.get( Character.toString(letter).toUpperCase());

            }

        }

        catch (NullPointerException nullP) {
            System.out.println("No value found.");
        }

        return total;
    }

    //@Override
    public String toString(Object[] list) {
        return list.toString();
    }

}
