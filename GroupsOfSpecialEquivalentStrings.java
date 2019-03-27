package string;

import java.util.*;

public class GroupsOfSpecialEquivalentStrings {
	/*
	Q: You are given an array A of strings. Two strings S and T are special-equivalent 
	if after any number of moves, S == T. A move consists of choosing two indices i 
	and j with i % 2 == j % 2, and swapping S[i] with S[j].
	Now, a group of special-equivalent strings from A is a non-empty subset S of A 
	such that any string not in S is not special-equivalent with any string in S.
	Return the number of groups of special-equivalent strings from A.

	1. 1 <= A.length <= 1000
	2. 1 <= A[i].length <= 20
	3. All A[i] have the same length.
	4. All A[i] consist of only lowercase letters.
	*/

	/*
	Algorithm: 
	 	The intuition is we have a function f() through which we have. f(S)=f(T).
	 	The f marks the number of letters in even indices and odd indices. If S
	 	and T have same counts of letters on the even indeces and odd indices, they
	 	are the same group.

	Complexity Analysis:
	T: O(SUM(A_i)) Just the number of all the letters in the given string array.
	S: O(N) N is the length of array.
	*/
	public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            int[] count = new int[52];
            for (int i = 0; i < str.length(); ++i){
                count[str.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}