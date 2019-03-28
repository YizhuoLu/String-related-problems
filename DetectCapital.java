package string;

import java.util.*;

public class DetectCapital {
	/*
	Q: Given a word, you need to judge whether the usage of capitals in it is right or 
	not.
	We define the usage of capitals in a word to be right when one of the following 
	cases holds:
	All letters in this word are capitals, like "USA".
	All letters in this word are not capitals, like "leetcode".
	Only the first letter in this word is capital if it has more than one letter, 
	like "Google".
	Otherwise, we define that this word doesn't use capitals in a right way.

	The input will be a non-empty word consisting of uppercase and lowercase latin 
	letters.
	*/

	/*
	Algorithm: 
		We need to first see what is the first letter of the given string, if it is
		uppercase, the subsequent letters must be consistent. If the first is
		lowercase, the subsequent letters must be all in lowercase.

	Complexity Analysis:
	T: O(N)
	S: O(1)
	*/
	public boolean detectCapitalUse(String word) {
        // corner case
        if (word.length() == 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            boolean isUp = Character.isUpperCase(word.charAt(1)) ? true : false;
            for (int i = 2; i < word.length(); ++i) {
                boolean cur = Character.isUpperCase(word.charAt(i));
                if (isUp && !cur || !isUp && cur) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length();++i) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}