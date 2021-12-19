package task1;

import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationRunner {

    public static void main(String[] args) {

        //Path to the files
        String filePath = System.getProperty("user.dir");
        //Path to the datafile .txt
        String ipFile = filePath + File.separator + "../../datafile.txt";
        //Making an output file named results.txt
        String opFile = filePath + File.separator + "../../results.txt";
        //File object
        File fileobj = new File(ipFile);

        Scanner input = null;

        try {
            input = new Scanner(fileobj);

            //Reading the file
            while (input.hasNext()) {
                String line = input.nextLine();
                //Printing the output
                System.out.println(cipher(line));

            }

            //If the file is not found
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
    }

    public static String cipher(String ipFile) {
        String cipher = "";
        String line = "";

        //For loop to get length of input file 
        for (int i = 0; i < ipFile.length(); i++) {
            char chars = ipFile.charAt(i);

            //An empty String
            String tmp = "";
            // If statment to get the vowels from the file "V1" 
            if (chars == 'V') {

                for (int j = i + 1; j < ipFile.length(); j++) {
                    if (j == ipFile.length() - 1) {
                        tmp += ipFile.charAt(j);
                        cipher += vowelCipher(tmp);
                        break;

                    } else if (Character.isDigit(ipFile.charAt(j))) {
                        tmp += ipFile.charAt(j);
                    } else if (ipFile.charAt(j) == ' ') {
                        tmp = "" + vowelCipher(tmp);
                        cipher += tmp + " ";

                        break;
                    } else {
                        tmp = "" + vowelCipher(tmp);
                        cipher += tmp;

                        break;
                    }
                }

            }
            // If statment to get the consonants from the file "C1" 
            if (chars == 'C') {

                for (int j = i + 1; j < ipFile.length(); j++) {
                    if (j == ipFile.length() - 1) {
                        tmp += ipFile.charAt(j);
                        cipher += consonantCipher(tmp);
                        break;

                    } else if (Character.isDigit(ipFile.charAt(j))) {
                        tmp += ipFile.charAt(j);
                    } else if (ipFile.charAt(j) == ' ') {
                        tmp = "" + consonantCipher(tmp);
                        cipher += tmp + " ";

                        break;
                    } else {
                        tmp = "" + consonantCipher(tmp);
                        cipher += tmp;
                        break;
                    }

                }

            }
            //Writing the output to the file named results.txt
            try {
                FileWriter resultsFile = new FileWriter("../../results.txt");
             
                resultsFile.write(cipher(line) + "\n");
                resultsFile.close();
                //If unable to write the file into txt file
            } catch (IOException io) {
                System.out.println("Unable to Write.");
            }

        }
        return cipher;

    }

    //Replacing the position of the consonants "C1" to alphabets
    public static char consonantCipher(String consonantNumber) {
        char cipher = 1;

        int consonantInt = Integer.parseInt(consonantNumber);
        switch (consonantInt) {
            case 1:
                cipher = 'b';
                break;
            case 2:
                cipher = 'B';
                break;
            case 3:
                cipher = 'c';
                break;
            case 4:
                cipher = 'C';
                break;
            case 5:
                cipher = 'd';
                break;
            case 6:
                cipher = 'D';
                break;
            case 7:
                cipher = 'f';
                break;
            case 8:
                cipher = 'F';
                break;
            case 9:
                cipher = 'g';
                break;
            case 10:
                cipher = 'G';
                break;
            case 11:
                cipher = 'h';
                break;
            case 12:
                cipher = 'H';
                break;
            case 13:
                cipher = 'j';
                break;
            case 14:
                cipher = 'J';
                break;
            case 15:
                cipher = 'k';
                break;
            case 16:
                cipher = 'K';
                break;
            case 17:
                cipher = 'l';
                break;
            case 18:
                cipher = 'L';
                break;
            case 19:
                cipher = 'm';
                break;
            case 20:
                cipher = 'M';
                break;
            case 21:
                cipher = 'n';
                break;
            case 22:
                cipher = 'N';
                break;
            case 23:
                cipher = 'p';
                break;
            case 24:
                cipher = 'P';
                break;
            case 25:
                cipher = 'q';
                break;
            case 26:
                cipher = 'Q';
                break;
            case 27:
                cipher = 'r';
                break;
            case 28:
                cipher = 'R';
                break;
            case 29:
                cipher = 's';
                break;
            case 30:
                cipher = 'S';
                break;
            case 31:
                cipher = 't';
                break;
            case 32:
                cipher = 'T';
                break;
            case 33:
                cipher = 'v';
                break;
            case 34:
                cipher = 'V';
                break;
            case 35:
                cipher = 'w';
                break;
            case 36:
                cipher = 'W';
                break;
            case 37:
                cipher = 'x';
                break;
            case 38:
                cipher = 'X';
                break;
            case 39:
                cipher = 'z';
                break;
            case 40:
                cipher = 'Z';
                break;
        }
        return cipher;
    }

    //Replacing the position of the vowels  "V1" to alphabets
    public static char vowelCipher(String vowelNumber) {
        char cipher = 1;
        int vowelInt = Integer.parseInt(vowelNumber);
        switch (vowelInt) {
            case 1:
                cipher = 'a';
                break;
            case 2:
                cipher = 'A';
                break;
            case 3:
                cipher = 'e';
                break;
            case 4:
                cipher = 'E';
                break;
            case 5:
                cipher = 'i';
                break;
            case 6:
                cipher = 'I';
                break;
            case 7:
                cipher = 'o';
                break;
            case 8:
                cipher = 'O';
                break;
            case 9:
                cipher = 'u';
                break;
            case 10:
                cipher = 'U';
                break;
            case 11:
                cipher = 'y';
                break;
            case 12:
                cipher = 'Y';
                break;
        }

        return cipher;
    }

}
