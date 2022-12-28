package ngram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Gram {

    public static HashMap<String , Model> CORPUS_HASH_MAP = new HashMap<>();

    public static void buildFourGram(ArrayList<List<String>> tokenizeArrayList){

        for (List<String> strings : tokenizeArrayList) {

            makeOneGram(strings);
            makeTwoGram(strings);
            makeThreeGram(strings);
            makeFourGram(strings);

        }

        Probabilities.setAllProbabilities();

    }

    public static void printOrderedHashMapToCSV(String fileName) {

        List<String> keys = new ArrayList<>(CORPUS_HASH_MAP.keySet());
        Collections.sort(keys, (key1, key2) -> CORPUS_HASH_MAP.get(key1).getGram() - CORPUS_HASH_MAP.get(key2).getGram());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("Word,Gram,Count,Probabilities");
            bw.newLine();

            for (String key : keys) {

                Model model = CORPUS_HASH_MAP.get(key);
                bw.write(key + "," + model.getGram() + "," + model.getCount() + "," + model.getProbabilities());
                bw.newLine();

            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void makeOneGram(List<String> array){

        for (String word : array) {

            if (!word.trim().equalsIgnoreCase("")) {

                if (isFound(word)) {

                    Model model = CORPUS_HASH_MAP.get(word);
                    int count = model.getCount();
                    count = count + 1;
                    model.setCount(count);

                } else {

                    Model model = new Model();
                    model.setGram(1);
                    model.setCount(1);
                    model.setWord(word);
                    CORPUS_HASH_MAP.put(word, model);

                }

            }

        }

    }

    public static void makeTwoGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 ;

        if (array.size() > 1 ) {

            for (int i = 0; i < array.size() - 1 ; i++) {

                if (!array.get(i).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex);
                    String secondWord = array.get(secondIndex);
                    String sentence = firstWord.trim() + " " + secondWord.trim();

                    if (isFound(sentence.trim())) {

                        Model model = CORPUS_HASH_MAP.get(sentence.trim());
                        int count = model.getCount();
                        count += 1;
                        model.setCount(count);

                    } else {

                        Model model = new Model();
                        model.setWord(sentence.trim());
                        model.setCount(1);
                        model.setGram(2);
                        CORPUS_HASH_MAP.put(sentence.trim(), model);


                    }
                    firstIndex += 1;
                    secondIndex += 1;

                }

            }

        }

    }

    public static void makeThreeGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 ;

        if (array.size() > 2 ) {

            for (int i = 0; i < array.size() - 2 ; i++) {

                if (!array.get(i).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex);
                    String secondWord = array.get(secondIndex);
                    String thirdWord = array.get(thirdIndex);
                    String sentence = firstWord.trim() + " " + secondWord.trim() + " " + thirdWord.trim();

                    if (isFound(sentence.trim())) {

                        Model model = CORPUS_HASH_MAP.get(sentence.trim());
                        int count = model.getCount();
                        count += 1;
                        model.setCount(count);

                    } else {

                        Model model = new Model();
                        model.setWord(sentence.trim());
                        model.setGram(3);
                        model.setCount(1);
                        CORPUS_HASH_MAP.put(sentence.trim(), model);


                    }
                    firstIndex += 1;
                    secondIndex += 1;
                    thirdIndex += 1;
                }

            }

        }

    }

    public static void makeFourGram(List<String> array){

        int firstIndex = 0 , secondIndex = 1 , thirdIndex = 2 , fourIndex = 3;

        if (array.size() > 3 ) {

            for (int j = 0; j < array.size() - 3 ; j++) {

                if (!array.get(j).trim().equalsIgnoreCase("")) {

                    String firstWord = array.get(firstIndex).trim();
                    String secondWord = array.get(secondIndex).trim();
                    String thirdWord = array.get(thirdIndex).trim();
                    String fourthWord = array.get(fourIndex).trim();
                    String sentence = firstWord.trim() + " " + secondWord.trim() + " "
                            + thirdWord.trim() + " " + fourthWord.trim();

                    if (isFound(sentence)) {

                        Model model = CORPUS_HASH_MAP.get(sentence.trim());
                        int count = model.getCount();
                        count += 1;
                        model.setCount(count);

                    } else {

                        Model model = new Model();
                        model.setGram(4);
                        model.setCount(1);
                        model.setWord(sentence.trim());
                        CORPUS_HASH_MAP.put(sentence.trim(), model);

                    }

                    firstIndex += 1;
                    secondIndex += 1;
                    thirdIndex += 1;
                    fourIndex += 1;

                }

            }

        }

    }

    private static boolean isFound(String word) {

        return Gram.CORPUS_HASH_MAP.get(word.trim()) != null;

    }


}
