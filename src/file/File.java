package file;

import ngram.Gram;
import ngram.Model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class File {



    public static ArrayList<String> readCorpusFile(String path){

        ArrayList<String> arrayListCorpus = new ArrayList<>();

        try {

            java.io.File file = new java.io.File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arrayListCorpus.add(data);

            }

            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        return arrayListCorpus ;

    }

}
