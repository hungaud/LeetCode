import java.util.*;

public class GroupSimilarStringAnagram {

    public static void main (String[] args) {
        System.out.println(groupAnagrams(new String[]{"Good", "pan", "nap", "dog", "god"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            Set<Character> ch = new HashSet<>();
            for(int i=0;i<s.length();i++)
                ch.add(Character.toLowerCase(s.charAt(i)));
            Arrays.sort(ch.toArray());

            String key = String.valueOf(ch);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

}
