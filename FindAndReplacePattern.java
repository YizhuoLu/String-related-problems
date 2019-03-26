package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAndReplacePattern {
	/*
	 * Q: You have a list of words and a pattern, and you want to know which words in words matches the pattern.
	 * A word matches the pattern if there exists a permutation of letters p so that after replacing every 
	 * letter x in the pattern with p(x), we get the desired word.
	 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to 
	 * another letter, and no two letters map to the same letter.)
	 * Return a list of the words in words that match the given pattern. 
	 * You may return the answer in any order.
	 * 
	 * 1. 1 <= words.length <= 50
	 * 2. 1 <= pattern.length = words[i].length <= 20
	 * */
	
	/*
	 * Algorithm: Map + Set
	 *  For each word in the array, I map the corresponding letter and put it into a set at the first time. Later
	 *  if there is no such mapping already been used in the set, I can create such a mapping otherwise  I will
	 *  break and check next word.
	 *  
	 * Complexity Analysis:
	 * T: O(m * n) m is the length of array, n is the length of the pattern.
	 * S: O(n)
	 * */
	public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        char[] ch = pattern.toCharArray();
        for (int i = 0; i < words.length; ++i) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            boolean flag = true;
            char[] cur = words[i].toCharArray();
            for (int j = 0; j < cur.length; ++j) {
                if (map.containsKey(ch[j])) {
                    if (map.get(ch[j]) != cur[j]) {
                        flag = false;
                        break;
                    }
                } else {
                    if (!set.contains(cur[j])) {
                        map.put(ch[j], cur[j]);
                        set.add(cur[j]);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
