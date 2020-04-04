import java.io.*;
import java.util.Scanner;
import java.util.Collections;

public class PartOne {

    public static void main (String[] args){


    }

    public static void readFile() {

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
    }
}
