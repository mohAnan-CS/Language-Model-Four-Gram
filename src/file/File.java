package file;

import ngram.Gram;
import ngram.Model;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

    public static void printOrderedHashMapToCSV(String fileName) {

        List<String> keys = new ArrayList<>(Gram.CORPUS_HASH_MAP.keySet());
        Collections.sort(keys, Comparator.comparingInt(key -> Gram.CORPUS_HASH_MAP.get(key).getGram()));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("Word,Gram,Count,Probabilities");
            bw.newLine();

            for (String key : keys) {

                Model model = Gram.CORPUS_HASH_MAP.get(key);
                bw.write(key + "," + model.getGram() + "," + model.getCount() + "," + model.getProbabilities());
                bw.newLine();

            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

}
