package tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicTokenizer {

    public static int numberWordCorpus ;
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\p{L}+");

    public static List<String> tokenize(String text) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(text);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    public static ArrayList<List<String>> tokenAllLines(ArrayList<String> arrayList){

        ArrayList<List<String>> arrayListCorpus = new ArrayList<>();

        for (String s : arrayList) {

            List<String> token = tokenize(s);
            numberWordCorpus += token.size() ;
            arrayListCorpus.add(token);

        }

        return arrayListCorpus;

    }


}
