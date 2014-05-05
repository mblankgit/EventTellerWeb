package index.model;

/**
 * Created by mblank on 14-4-25.
 */
public class WebWord {
    private String name;
    private String wordTimeNumber;
    private String relatedWords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWordTimeNumber() {
        return wordTimeNumber;
    }

    public void setWordTimeNumber(String wordTimeNumber) {
        this.wordTimeNumber = wordTimeNumber;
    }

    public String getRelatedWords() {
        return relatedWords;
    }

    public void setRelatedWords(String relatedWords) {
        this.relatedWords = relatedWords;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

}
