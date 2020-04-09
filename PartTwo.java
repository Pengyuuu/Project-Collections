/**@authors Erina Lara, Eric Truong
 * Date: April 8, 2020
 * Program: Insert all the words from Alice in Wonderland and time how long it takes to insert the words into a tree map
 * or a hash map. Also time how long it takes to search for a word
 */

import java.io.*;
import java.util.Scanner;
import java.util.*;


public class PartTwo {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("1. TreeMap \n" +
                "2. HashMap \n" +
                "Make a selection: ");

        int choiceOne = scan.nextInt();

        if (choiceOne == 1){


            long startTime = System.nanoTime();
            TreeSet<String> words = readToTree();

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time: " + estimatedTime);



            System.out.println("Searching 100 times for specified word.");

            startTime = System.nanoTime();

            // chosen random word
            String n = "the";  // random word yet to be computed
            boolean found = false;
            for (int i = 0; i < 101; i++) {
                found = findValueInTree(words,n);
            }

            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to find word: " + estimatedTime);

        }


        else {

            long startTime = System.nanoTime();
            HashSet<String> words = readToHash();
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time: " + estimatedTime);



            System.out.println("Searching 100 times for specified word.");

            startTime = System.nanoTime();

            // need to pick random word in book then find that word
            String n = "the";  // random word yet to be computed
            boolean found = false;
            for (int i = 0; i < 101; i++) {
                found = findValueInHash(words,n);
            }
            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to find word: " + estimatedTime);

        }

    }

    /**
     * Reads the text file into a tree map
     * @return  tree map with words from text file
     */
    public static TreeSet readToTree() {

        TreeSet<String> tree = new TreeSet<>();

        try {

            Scanner read = new Scanner(new File("alice.txt"));

            do {

                String line = read.nextLine();
                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    tree.add(words[i]);
                }

            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }

        return tree;
    }

    /**
     * Reads the text file into a hash map
     * @return  hash map with words from hash map
     */
    public static HashSet readToHash() {

        HashSet<String> tree = new HashSet<>();

        try {
            Scanner read = new Scanner(new File("alice.txt"));

            do {
                String line = read.nextLine();
                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    tree.add(words[i]);
                }
            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        }

        return tree;
    }


    /**
     * Check to see if the word exists in the tree map
     * @param scanTree  tree map full of words
     * @param n         word to search for
     * @return          true if word exists, false otherwise
     */
    public static boolean findValueInTree(TreeSet scanTree, String n) {

        TreeSet<String> scrabbleTree = new TreeSet<String>(scanTree);

        boolean word = scrabbleTree.contains(n);

        return word;
    }

    /**
     * Check to see if the word exists in the hash map
     * @param scanHash  hash map full of words
     * @param n         word to search for
     * @return          true if word exists, false otherwise
     */
    public static boolean findValueInHash(HashSet scanHash, String n) {

        HashSet<String> scrabbleHash = new HashSet<String>(scanHash);

        boolean word = scrabbleHash.contains(n);

        return word;

    }

    /**
     * Puts the list into a nicely, formatted string
     * @param list  list to be converted into a string
     * @return      nicely, formatted string
     */
    //@Override
    public String toString(Object[] list) {
        return list.toString();
    }

}
