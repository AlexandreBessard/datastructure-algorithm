package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[] product = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        var obj = new SearchSuggestionsSystem();
        obj.suggestedProducts(product, searchWord).forEach(System.out::println);
    }

    /*
    Binary Search
    Time complexity : O(nlog(n)) + O(mlog(n))O(nlog(n))+O(mlog(n)).
    Where n is the length of products and m is the length of the search word.
    Here we treat string comparison in sorting as O(1)O(1). O(nlog(n))O(nlog(n))
    comes from the sorting and O(mlog(n))O(mlog(n)) comes from running binary
    search on products m times.
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = "";
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            //Get starting index of word starting with prefix
            start = lower_bound(products, bsStart, prefix);
            result.add(new ArrayList<>());
            for(int i = start; i < Math.min(start + 3, n); i++) {
                if(products[i].length() < prefix.length()
                        || !products[i].substring(0, prefix.length()).equals(prefix)) {
                    break;
                }
                result.get(result.size() - 1).add(products[i]);
            }
            //Reduce size of elements to binary Search
            bsStart = Math.abs(start);
        }
        return result;
    }

    int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while(i < j) {
            mid = i + (j - i) / 2;
            int comp = products[mid].compareTo(word);
            System.out.println(word + " : " + comp + " with " + products[i]);
            if(products[mid].compareTo(word) >= 0) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }




}
