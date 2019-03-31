package string;

import java.util.*;

public class RansomNote {
	/*
	Q: Given an arbitrary ransom note string and another string containing letters 
	from all the magazines, write a function that will return true if the ransom note 
	can be constructed from the magazines ; otherwise, it will return false.
	Each letter in the magazine string can only be used once in your ransom note.

	You may assume that both strings contain only lowercase letters.
	*/

	/*
	Algorithm: 
		Use int[26] to represent what letters and how many that letters the magazine 
		provided. Then I traverse the first string to see if the corresponding 
		position is zero, if so, return false, otherwise we decrement it and continue.

	Complexity Analysis:
	T: O(m + n) m and n are the length of two strings respectively.
	S: O(26) 
	*/
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char ch : magazine.toCharArray()) {
            map[ch-'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (map[ch -  'a'] == 0) {
                return false;
            } else {
                map[ch - 'a']--;
            }
        }
        return true;
    }
}