import java.util.*;

public class TopNCompetitors {

    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 5;
        String[] toys = new String[] {"'"};
        String[] quotes = new String[] {
                "'"

        };
        List<String> result = getTopToys(numToys, topToys, toys, quotes);
        for(String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> getTopToys(int numToys, int topToys, String[] toys, String[] quotes) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> mentionedFreq = new HashMap<>();
        HashMap<String, Integer> quoteFreq = new HashMap<>();
        if (quotes.length == 0) {
            return result;
        }

        for(String toy : toys) {
            mentionedFreq.put(toy.toLowerCase(), 0);
            quoteFreq.put(toy.toLowerCase(), 0);
        }

        for(int i = 0; i < quotes.length; i++) {
            String[] sentence = quotes[i].split("\\s+");
            HashSet<String> visted = new HashSet<>();
            for(String word : sentence) {
                word = word.replaceAll("[^A-Za-z]+", "").toLowerCase();
                if(mentionedFreq.containsKey(word)) {
                    mentionedFreq.put(word, mentionedFreq.get(word) + 1);
                    // if im able to add the word to the set. if true, means first time seeing the word in sentence
                    if(visted.add(word)) {
                        quoteFreq.put(word, quoteFreq.get(word) + 1);
                    }
                }
            }
        }
        // set up heap
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(mentionedFreq.get(o1) != mentionedFreq.get(o2))
                    return mentionedFreq.get(o2) - mentionedFreq.get(o1);
                if(quoteFreq.get(o1) != quoteFreq.get(o2))
                    return quoteFreq.get(o2) - quoteFreq.get(o1);
                return o1.compareTo(o2);
            }
        });

        for(String key : toys) {
            if(mentionedFreq.get(key) > 0)
                pq.add(key);
        }

        int n = 0;
        //int itr = topToys > numToys ? pq.size() : topToys;
        int size = pq.size();
        while (n <  size && n < topToys) {
            result.add(pq.poll());
            n++;
        }

        return result;
    }
}
