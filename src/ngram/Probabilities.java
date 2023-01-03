package ngram;

import tokenizer.ArabicTokenizer;

public class Probabilities {

    private static void setProbability(Model model){

        if (model.getGram() == 1){

            int countWord = model.getCount();
            double probabilityOneGram = (double) countWord/ ArabicTokenizer.numberWordCorpus ;
            model.setProbabilities(probabilityOneGram);

        }else if (model.getGram() == 2){

            int countTwoWord = model.getCount();
            String[] split = model.getWord().split(" ");
            String firstWord = split[0].trim() ;
            int countWordBefore = Gram.CORPUS_HASH_MAP.get(firstWord).getCount();
            float probabilityTwoGram = (float) countTwoWord / countWordBefore;
            model.setProbabilities(probabilityTwoGram);

        }else if (model.getGram() == 3){

            int countThreeWord = model.getCount();
            String[] splitThreeGram = model.getWord().split(" ");
            String towWordBefore = splitThreeGram[0].trim() + " " + splitThreeGram[1].trim();
            int countTowWordBefore = Gram.CORPUS_HASH_MAP.get(towWordBefore.trim()).getCount();
            double probabilityThreeGram = (double) countThreeWord / countTowWordBefore;
            model.setProbabilities(probabilityThreeGram);

        }else if (model.getGram() == 4){

            int countFourWord = model.getCount();
            String[] splitFourGram = model.getWord().split(" ");
            String threeWordBefore = splitFourGram[0].trim().concat(" " + splitFourGram[1].trim() + " " + splitFourGram[2].trim());
            int countThreeWordBefore = Gram.CORPUS_HASH_MAP.get(threeWordBefore.trim()).getCount();
            float probabilityFourGram = (float) countFourWord / countThreeWordBefore ;
            model.setProbabilities(probabilityFourGram);

        }

    }

    public static void setAllProbabilities(){

        for (String word : Gram.CORPUS_HASH_MAP.keySet()) {

            Model model = Gram.CORPUS_HASH_MAP.get(word);
            setProbability(model);

        }

    }

}
