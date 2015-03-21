package nyc.c4q.tashsmit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 * Calculate the verbosity of a text
 */
public class Main {
    public static void main(String[] args) {

        // An abstract representation of a File
        File mobyDick = new File("/Users/c4q-tashasmith/Desktop/VerbCalc/resources/A Tale of Two Cities.rtf");
        File twoCities = new File("/Users/c4q-tashasmith/Desktop/VerbCalc/resources/Moby Dick.rtf");

        Count(mobyDick);
        Count(twoCities);

    }

    public static void Count(File yourFile) {


        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        int wordCount = 0;
        int sentenceCount = 0;
        double average;


        try {

            Scanner input = new Scanner(yourFile);

            while (input.hasNext()) {
                String text = input.next();
                wordCount++;
                if (text.contains("Mr.") || text.contains("Ms.") || text.contains("Mrs.")) {
                    continue;
                }
                else if (text.contains(".") || text.contains("!") || text.contains("?")) {
                    sentenceCount++;
                }
            }

            System.out.println("Word count: " + decimalFormat.format(wordCount));
            System.out.println("Sentence count: " + decimalFormat.format(sentenceCount));
            average = wordCount / ((double)sentenceCount);
            System.out.println("Average: " + decimalFormat.format(average));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}













