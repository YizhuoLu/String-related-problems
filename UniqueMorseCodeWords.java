package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
	/*
	 * Q: International Morse Code defines a standard encoding where each letter is mapped to a series of 
	 * dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
	 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each 
	 * letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." 
	 * + ".-"). We'll call such a concatenation, the transformation of a word.
	 * Return the number of different transformations among all words we have.
	 * 
	 * 1. The length of words will be at most 100.
	 * 2. Each words[i] will have length in range [1, 12].
	 * 3. words[i] will only consist of lowercase letters.
	 * */
	
	/*
	 * Algorithm: Set + Map
	 *  For each word in the array,I will concatenate the corresponding Morse code and insert it into the set.
	 *  Eventually return set.size().
	 * 
	 * Complexity Analysis:
	 * T: O(m*n) m is the length of the array, n is the maximum length of the string in it.
	 * S: O(m)
	 * */
	public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");
        for (String s :words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
