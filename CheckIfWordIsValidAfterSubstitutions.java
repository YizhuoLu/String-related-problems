package string;

import java.util.*;

public class  CheckIfWordIsValidAfterSubstitutions {
	/*
	Q: We are given that the string "abc" is valid.
	From any valid string V, we may split V into two pieces X and Y such that X + Y 
	(X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + 
	Y is also valid.
	If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", 
	"abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", 
	"cababc", "bac".
	Return true if and only if the given string S is valid.

	1. 1 <= S.length <= 20000
	2. S[i] is 'a', 'b', or 'c'
	*/

	/*
	Algorithm: Stack
		Use a stack to store all the characters, once we encounter 'c', we poll twice
		consecutively to see if the first is 'b' and the second is 'a'. If not or if
		the stack is empty, it signifies it's not 'abc' inserted,  so return false;
		otherwise, I just add into stack. Eventually I return if stack is empty.

	Complexity Analysis:
	T: O(n)
	S: O(n)
	*/
	public boolean isValid(String S) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            if (ch == 'c') {
                if (stack.isEmpty() || stack.pollFirst() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pollFirst() != 'a') {
                    return false;
                }
            } else {
                stack.offerFirst(ch);
            }
        }
        return stack.isEmpty();
    }
}