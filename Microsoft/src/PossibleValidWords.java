import java.util.*;

public class PossibleValidWords {

    public static void main(String[] args) {
        String[] dict = new String[] {"go","bat","me","eat","goal", "boy", "run", "google"};
        char[] arr = new char[] {'e','o','b', 'a','m','g', 'l'};

        System.out.println(printPossibleWords(dict, arr).toString());
        System.out.println(printPossibleWordsExact(dict, arr).toString());
    }

    private static List<String> printPossibleWordsExact(String[] dict, char[] arr) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : arr) {
            if(!freq.containsKey(c))
                freq.put(c, 0);
            freq.put(c, freq.get(c) + 1);
        }
        for(int i = 0; i < dict.length; i++) {
            HashMap<Character, Integer> currentMap = new HashMap<>();
            char[] word = dict[i].toCharArray();
            boolean isValidWord = true;
            for(char c : word) {
                if(!currentMap.containsKey(c))
                    currentMap.put(c, 0);
                currentMap.put(c, currentMap.get(c) + 1);
                if(!freq.containsKey(c) || currentMap.get(c) > freq.get(c))
                    isValidWord = false;
            }
            if(isValidWord)
                res.add(dict[i]);
        }

        return res;
    }

    private static List<String> printPossibleWords(String[] dict, char[] arr) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<Character> letters = new HashSet<>();
        for(char c : arr) {
            letters.add(c);
        }
        for(int i = 0; i < dict.length; i++) {
            char[] word = dict[i].toCharArray();
            int count = 0;
            for(int j = 0; j < word.length; j++) {
                if(letters.contains(word[j]))
                    count++;
            }
            if(count == word.length)
                res.add(dict[i]);
        }
        return res;
    }
}
