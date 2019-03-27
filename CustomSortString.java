package string;

import java.util.*;

public class CustomSortString {
	/*
	Q: S and T are strings composed of lowercase letters. In S, no letter occurs more 
	than once. S was sorted in some custom order previously. We want to permute the 
	characters of T so that they match the order that S was sorted. More specifically, 
	if x occurs before y in S, then x should occur before y in the returned string.
	Return any permutation of T (as a string) that satisfies this property.

	1. S has length at most 26, and no character is repeated in S.
	2. T has length at most 200.
	3. S and T consist of lowercase letters only.
	*/

	/*
	Algorithm 1: I use map to store all the indices of letters in T that also appear 
		in T. Next I use a stringbuilder to first load all letters in the map and then
		all left letter that is not in the map (maintain the relative order in T).

	Attention: S may contains letter that T doesn't have. Therefore, when we are at
	 the first stage of processing the result, we need to firstly tell if map contains
	 the current character.

	Complexity Analysis:
	T: O(m + n) m is the length of S, n is the length of T.
	S: O(m + m * x) x is the number of same character of each letter in S.
	*/
	public String customSortString(String S, String T) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chs = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chs){
            set.add(c);
        }
        char[] ch = T.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (set.contains(ch[i])) {
                if (!map.containsKey(ch[i])) {
                    map.put(ch[i], new ArrayList<>());
                }
                map.get(ch[i]).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (map.containsKey(c)) {
                for (int idx : map.get(c)) {
                    sb.append(ch[idx]);
                }
            }
        }
        for (char c : ch){
            if (!set.contains(c)) {
                sb.append(c);
            }
        }                    
        return sb.toString();
    }

    /*
	Algorithm 2: No use of map and set, just an int[26].
		we store all letters and corrsponding counts in an array of T. Then we
		first add all letters that has appeared in S into result and then process
		the left letters.
    */
    public String customSortStringII(String S, String T) {
        int[] count= new int[26];
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                sb.append(c);
            }
            count[c - 'a'] = 0;
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}