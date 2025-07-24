package LinearSearch;

public class WordSearchInSentences {
    public static String findSentenceWithWord(String[] sents, String word) {
        for (String s : sents) {
            if (s.toLowerCase().contains(word.toLowerCase())) {
                return s;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sents = {
            "The quick brown fox jumps over the lazy dog",
            "A journey of a thousand miles begins with a single step",
            "All that glitters is not gold",
            "Actions speak louder than words"
        };
        
        String word = "journey";
        String res = findSentenceWithWord(sents, word);
        
        System.out.println("Search result for word '" + word + "': " + res);
    }
}