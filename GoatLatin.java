package string;

import java.util.*;

public class GoatLatin {
	/*
	Q: A sentence S is given, composed of words separated by spaces. Each word consists 
	of lowercase and uppercase letters only. We would like to convert the sentence to 
	"Goat Latin" (a made-up language similar to Pig Latin.)
	The rules of Goat Latin are as follows:
	If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the 
	word.
	For example, the word 'apple' becomes 'applema'.
 	If a word begins with a consonant (i.e. not a vowel), remove the first letter and 
 	append it to the end, then add "ma".
	For example, the word "goat" becomes "oatgma"
	Add one letter 'a' to the end of each word per its word index in the sentence, 
	starting with 1.
	For example, the first word gets "a" added to the end, the second word gets "aa" 
	added to the end and so on.
	Return the final sentence representing the conversion from S to Goat Latin. 

	1. S contains only uppercase, lowercase and spaces. Exactly one space between each 
	word.
	2. 1 <= S.length <= 150.
	*/

	/*
	Algorithm: 
        For each word in the given string, if the first character is
        not vowel, we need to put the first letter to the end. Then 
        the process are the same which is to add 'ma' and corresponding
        number of 'a's

    Complexity Analysis:
    T: O(n) n is the length of the given string.
    S: O(n) due to the resultant space.
	*/
	public String toGoatLatin(String S) {
        // corner case
        if (S == null || S.length() == 0) {
            return S;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String[] words = S.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            char first = words[i].charAt(0);
            if (!set.contains(first)) {
                if (words[i].length() > 1) {
                    res.append(words[i].substring(1));
                }
                res.append(first);
            } else {
                res.append(words[i]);
            }
            // need to add 'ma' and As
            res.append("ma");
            for (int j = 0; j < i + 1; ++j) {
                res.append("a");
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
}