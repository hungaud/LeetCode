import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSuggestion_1268 {

    public static void main(String[] args) {
        String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = suggestedProducts(products, searchWord);
        for(List<String> l : result) {
            System.out.print("[ ");
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("] ");
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        return bruteForce(products, searchWord);
    }

    public static List<List<String>> bruteForce(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        for(int i = 1; i <= searchWord.length(); i++) {
            String search = searchWord.substring(0, i);
            List<String> listToAdd = new ArrayList<>();
            for(String s : products) {
                if(s.startsWith(search) && listToAdd.size() < 3) {
                    listToAdd.add(s);
                }
            }
            result.add(listToAdd);
        }
        return result;
    }
}

