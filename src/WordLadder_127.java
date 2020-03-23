import java.util.*;

public class WordLadder_127 {

    public static void main(String[] args) {
        String[] arr = new String[] {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(arr));
        String begin = "hit";
        String end = "cog";

        LadderLength(begin, end, wordList);
    }

    private static int LadderLength(String beginWord, String end, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        HashMap<String, List<String>> pattern = new HashMap<>();
        int count = 1;
        int wordLength = beginWord.length();
        wordList.add(beginWord);
        int listSize = wordList.size();

        for(int i = 0; i < listSize; i++) {
            if(!pattern.containsKey(wordList.get(i))) {
                pattern.put(wordList.get(i), new ArrayList<>());
            }
            for(int j = 0; j < wordLength; j++) {
                String tempWord = getEditedWord(wordList.get(i), j, '.');
                if(!pattern.containsKey(tempWord)) {
                    pattern.put(tempWord, new ArrayList<>());
                }
                pattern.get(tempWord).add(wordList.get(i));
                pattern.get(wordList.get(i)).add(tempWord);
            }
        }

        queue.add(beginWord);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                String currentWord = queue.remove();
                if(currentWord.equals(end)) {
                    return count;
                }
                if(!seen.add(currentWord)) {
                    continue;
                }
                List<String> neighbors = pattern.get(currentWord);
                for(int j = 0; j < neighbors.size(); j++) {
                    List<String> neighborsChildren = pattern.get(neighbors.get(j));
                    for(String nextWord : neighborsChildren) {
                        queue.add(nextWord);
                    }
                }

            }

            count++;
        }
        return 0;
    }
    private static String getEditedWord(String s, int index, char c) {
        return s.substring(0, index) + c + s.substring(index + 1, s.length());
    }
}
