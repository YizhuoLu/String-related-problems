package string;

import java.util.*;

public class CountBinarySubstrings {
	/*
	Q: Give a string s, count the number of non-empty (contiguous) substrings that 
	have the same number of 0's and 1's, and all the 0's and all the 1's in these 
	substrings are grouped consecutively.
	Substrings that occur multiple times are counted the number of times they occur.

	1. s.length will be between 1 and 50,000.
	2. s will only consist of "0" or "1" characters.
	*/

	/*
	Algorithm: Make groups array to simplify the problem.
		Say 00111000011110000000, we can make group array = {2, 3, 4, 4, 7} in which the
		integer is the number of consecutive same values for each part. Then say two
		consecutive group say group[i-1], group[i]. For '0' * k + '1' * k or '1'* k +
		'0' * k. It can be 00111 or 11000, anyway, the number of contiguous substrings
		can only be min(gourp[i-1], group[i]) which is 2 since the middle '01' or '10'
		must exist and possessed by two group together.

	Complexity Analysis:
	T: O(N) since we only use a for-loop to construct the group array and traverse
		the group array to find the answer.
	S: O(N) space used by group array.
	*/
	public int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        int t = 0;
        group[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                group[++t] = 1;
            } else {
                group[t]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= t; ++i) {
            ans += Math.min(group[i-1], group[i]);
        }
        return ans;
    }
}