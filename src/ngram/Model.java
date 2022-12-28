package ngram;

public class Model {

    private String word;
    private int gram;
    private int count;
    private double probabilities;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(double probabilities) {
        this.probabilities = probabilities;
    }

    @Override
    public String toString() {
        return "ngram.Model{" +
                "word='" + word + '\'' +
                ", gram=" + gram +
                ", count=" + count +
                ", probabilities=" + probabilities +
                '}';
    }

}
