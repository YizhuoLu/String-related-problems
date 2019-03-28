package string;

import java.util.*;

public class ReverseOnlyLetters {
	/*
	Q: Given a string S, return the "reversed" string where all characters that are 
	not a letter stay in the same place, and all letters reverse their positions.

	1. S.length <= 100
	2. 33 <= S[i].ASCIIcode <= 122 
	3. S doesn't contain \ or "
	*/

	/*
	Algorithm 1: Two pass.
		In the first pass, I store all letters in a list. Then in the second pass, I 
		replace the letters with items in the list in reversed order.

	Complexity Analysis:
	T: O(n) n is the length of the given string.
	S: O(n)
	*/
	public String reverseOnlyLetters(String S) {
        // corner case
        if (S == null || S.length() == 0) {
            return S;
        }
        List<Character> list = new ArrayList<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }
        int j = list.size() - 1;
        char[] ch = S.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (Character.isLetter(ch[i])) {
                ch[i] = list.get(j--);
            }
        }
        return new String(ch);
    }
    /*
	Algorithm 2: Two-pointers
		use two pointer, each time when they are both letters, we swap.
    */
    public String reverseOnlyLettersII(String S) {
        char[] ch = S.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i <= j) {
            while (i < j && !Character.isLetter(ch[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(ch[j])) {
                j--;
            }
            swap(ch, i++, j--);
        }
        return new String(ch);
    }
    
    private void swap(char[] ch, int left, int right) {
        char tmp = ch[left];
        ch[left] = ch[right];
        ch[right] = tmp;
    }
}