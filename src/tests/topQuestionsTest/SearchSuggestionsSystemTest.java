package tests.topQuestionsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystemTest {

    public static void main(String[] args) {
        String[] product = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        var obj = new SearchSuggestionsSystemTest();
        obj.suggestedProducts(product, searchWord).forEach(System.out::println);
    }
    public List<List<String>> suggestedProducts(String[] produits, String word) {
        List<List<String>> result = new ArrayList<>();
        if(produits == null || produits.length == 0) return result;
        Arrays.sort(produits);
        StringBuilder prefix = new StringBuilder();
        int start = 0;
        for(char c : word.toCharArray()) {
            prefix.append(c);
            int idx = getIndexBS(produits, start, prefix.toString());
            result.add(new ArrayList<>());
            for(int i = idx; i < Math.min(idx + 3, produits.length); i++) {
                if(produits[i].length() < prefix.toString().length()
                        || !produits[i].substring(0, prefix.length()).equals(prefix.toString())){
                    break;
                }
                result.get(result.size() - 1).add(produits[i]);
            }
            start = idx;
        }
        return result;
    }
    private int getIndexBS(String[] products, int start, String word) {
        int end = products.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(products[mid].compareTo(word) >= 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
