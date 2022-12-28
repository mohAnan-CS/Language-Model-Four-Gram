import file.File;
import tokenizer.ArabicTokenizer;
import ngram.Gram;
import ngram.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        ArrayList<String> arrayListCorpus = File.readCorpusFile("cleanCorpus.txt");
        ArrayList<List<String>> arrayList = ArabicTokenizer.tokenAllLines(arrayListCorpus);
        Gram.buildFourGram(arrayList);
        Gram.printOrderedHashMapToCSV("out.csv");

    }

    private static void printArrayList(ArrayList<String> arrayList){

        for (String s : arrayList) System.out.println(s);

    }

    private static void printTokenize(ArrayList<String[]> arrayList){

        for (String[] strings : arrayList)
            for (String string : strings)
                System.out.println(string);

    }

    private static void printHashTable(HashMap<String , Model> hashMap){

        for (String model : hashMap.keySet()) {
            System.out.println(hashMap.get(model));
        }

    }

}
