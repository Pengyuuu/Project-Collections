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
            TreeSet<String> scrabbleTree = readToTree();

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time: " + estimatedTime);



            System.out.println("Searching 100 times for specified word.");

            startTime = System.nanoTime();

            // need to pick random word in book then find that word
            String n = "the";  // random word yet to be computed
            boolean found = false;
            for (int i = 0; i < 101; i++) {
                found = findValueInTree(scrabbleTree,n);
            }

            estimatedTime = System.nanoTime() - startTime;

            System.out.println("Amount of time to find word: " + estimatedTime);

        }


        else {

            long startTime = System.nanoTime();
            HashSet<String> scrabbleHash = readToHash();
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Amount of time: " + estimatedTime);



            System.out.println("Searching 100 times for specified word.");

            startTime = System.nanoTime();

            // need to pick random word in book then find that word
            String n = "the";  // random word yet to be computed
            boolean found = false;
            for (int i = 0; i < 101; i++) {
                found = findValueInHash(scrabbleHash,n);
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


    public static boolean findValueInTree(TreeSet scanTree, String n) {

        TreeSet<String> scrabbleTree = new TreeSet<String>(scanTree);

        boolean word = scrabbleTree.contains(n);

        return word;
    }

    public static boolean findValueInHash(HashSet scanHash, String n) {

        HashSet<String> scrabbleHash = new HashSet<String>(scanHash);

        boolean word = scrabbleHash.contains(n);

        return word;

    }

    @Override
    public String toString(Object[] list) {
        return list.toString();
    }

}
