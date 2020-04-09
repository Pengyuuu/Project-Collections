/**@authors Erina Lara, Eric Truong
 *Date: April 8, 2020
 *Program: Reads in a text file full of words into either a tree map or hash map, depending on user choice. Also reads
 *in another text file full of letters with their scrabble point values into either a tree map or hash map. Time how
 *long either map would take to read in the words, find which ever is fastest. Time both to see which is fastest in
 *searching for a value.
 */

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

            TreeMap<String, Integer> textTree = new TreeMap<>();

            long startTime = System.nanoTime();

            textTree = readToTree();

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to load: " + estimatedTime);

            startTime = System.nanoTime();

            textTree = searchTree(textTree, scrabbleTree);

            for (String key : textTree.keySet()) {

                System.out.println(key + " -> " + textTree.get(key));
            }

            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to search: " + estimatedTime);

        }

        else {

            HashMap<String, Integer> scrabbleHash = scrabbleToHash();

            HashMap<String, Integer> textHash = new HashMap<>();

            long startTime = System.nanoTime();

            textHash = readToHash();

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to load: " + estimatedTime);

            startTime = System.nanoTime();

            textHash = searchHash(textHash, scrabbleHash);

            for (String key : textHash.keySet()) {

                System.out.println(key + " -> " + textHash.get(key));
            }

            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to search: " + estimatedTime);
        }

    }

    /**
     * Reads words in text file into a tree map
     * @return  tree map with words from text file
     */
    public static TreeMap readToTree() {

        TreeMap<String, Integer> tree = new TreeMap<>();

        try {

            Scanner read = new Scanner(new File("file.txt"));

            do {

                String line = read.nextLine();
                //x = findValueInTree(scrabbleTree, line);
                tree.put(line, 0);

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
     * Reads words from text file into a hash map
     * @return  hash map with words from text file
     */
    public static HashMap readToHash() {

        HashMap<String, Integer> tree = new HashMap<>();

        try {
            Scanner read = new Scanner(new File("file.txt"));

            do {
                String line = read.nextLine();
                //x = findValueInHash(scrabbleHash, line);
                tree.put(line, 0);
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
     * Reads letters with their scrabble point values into a tree map
     * @return  tree map with letters and their scrabble point values
     */
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

    /**
     * Reads letters and their scrabble point values from a text file into a hash map
     * @return  hash map with letters and their scrabble point values
     */
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

    /**
     * Calculates the value of a word
     * @param scanTree  tree containing point value of letters
     * @param n         word whose value is being calculated
     * @return          point value of the word
     */
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

    /**
     * Calculates the value of a word
     * @param scanHash  hash map containing point value of letters
     * @param n         word whose value is being calculated
     * @return          point value of the word
     */
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

    /**
     * Modifies value of words in a tree map
     * @param textTree      tree map to be modified
     * @param scrabbleTree  tree map with letters and their point values
     * @return              modified tree map
     */
    public static TreeMap searchTree (TreeMap textTree, TreeMap scrabbleTree){

        int value = 0;

        TreeMap<String, Integer> tree = new TreeMap<>(textTree);

        for (String key : tree.keySet()) {

            value = findValueInTree(scrabbleTree, key);

            textTree.put(key, value);
        }
        return textTree;
    }

    /**
     * Modifies value of words in a hash map
     * @param textHash      hash map to be modified
     * @param scrabbleHash  hash map with letters and their point values
     * @return              modified hash map
     */
    public static HashMap searchHash (HashMap textHash, HashMap scrabbleHash) {

        int value = 0;

        HashMap<String, Integer> hash = new HashMap<>(textHash);

        for (String key : hash.keySet()) {

            value = findValueInHash(scrabbleHash, key);

            textHash.put(key, value);

        }

        return textHash;
    }
}


