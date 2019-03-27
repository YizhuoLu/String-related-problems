package string;

import java.util.ArrayList;
import java.util.List;

public class main {
	/*
	Q: Given a string, you need to reverse the order of characters in each word 
	within a sentence while still preserving whitespace and initial word order.

	In the string, each word is separated by single space and there will not be any 
	extra space in the string.
	*/

	/*
	Algorithm 1: No use of built-in methods
		First I split the given string by " " and then I reverse each single word, 
		eventually I use a stringBuilder to include the whole words and a " " to 
		separate them.

	Complexity Analysis:
	T: O(N) N is the length of the given string.
	S: O(N)
	*/
	public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] arr = split(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            String cur = reverse(arr[i]);
            sb.append(cur);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    private String[] split(String s){
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()){
            if (s.charAt(j) == ' ') {
                list.add(s.substring(i, j));
                i = j + 1;
            }
            j++;
        }
        list.add(s.substring(i, s.length()));
        String[] res = new String[list.size()];
        res = list.toArray(res);
        return res;
    }
    
    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*
	Algorithm 2: use built-in methods
    */
	public String reverseWordsII(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : arr) {
            sb.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return sb.toString().trim();
    }
}