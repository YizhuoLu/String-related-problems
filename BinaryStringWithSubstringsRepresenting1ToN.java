package string;

public class BinaryStringWithSubstringsRepresenting1ToN {
	/*
	 * Q: Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return 
	 * true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.
	 * 
	 * 1. 1 <= S.length <= 1000
	 * 2. 1 <= N <= 10^9
	 * */
	
	/*
	 * Algorithm: 
	 *   Check each number if it's a substring.
	 *   
	 * Complexity Analysis:
	 * T: O(N * S) S is the length of S.
	 * S: O(
	 * */
	public boolean queryString(String S, int N) {
        for (int i = 1; i <= N;++i){
            if (!S.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
