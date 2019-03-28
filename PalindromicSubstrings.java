package string;

import java.util.*;

public class PalindromicSubstrings {
	/*
	Q: Given a string, your task is to count how many palindromic substrings in this 
	string.
	The substrings with different start indexes or end indexes are counted as different 
	substrings even they consist of same characters.

	The input string length won't exceed 1000.
	*/

	/*
	Algorithm: 
		For each index of the given string, I make it as the center and then I extend
		the string to the both side twice to check. One is odd length which I start
		by making left = right = ith index, another one is even length which I start
		by making left = ith index = right + 1. Each time when I find left and right
		equals, I make count++ and continue extending left and right index.

	Complexity Analysis:
	T: O(n^2)
	S: O(1)
	*/
	int count = 0;
    public int countSubstrings(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); ++i) {
            extend(s, i, i); // odd length
            extend(s, i, i + 1); // even length
        }
        return count;
    }
    
    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}