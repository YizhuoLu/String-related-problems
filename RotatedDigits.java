package string;

import java.util.*;

public class RotatedDigits {
	/*
	Q: X is a good number if after rotating each digit individually by 180 degrees, we 
	get a valid number that is different from X.  Each digit must be rotated - we 
	cannot choose to leave it alone.
	A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate 
	to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the 
	rest of the numbers do not rotate to any other number and become invalid.
	Now given a positive number N, how many numbers X from 1 to N are good?

	N  will be in range [1, 10000].
	*/

	/*
	Algorithm 1: 
		Check each digit of N, if any digit is 3, 4, or 7, it must be invalid so it
		must not be a good number. If the digit is 0, 1, or 8 we take false flag to
		keep checking. 

	Complexity Analysis:
	T: O(NlogN)
	S: O(logN)
	*/
	public int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 0; i <= N; ++i) {
            if (good(i, false)) ans++;
        }
        return ans;
    }
    
    private boolean good(int i, boolean flag) {
        // base case
        if (i == 0) {
            return flag;
        }
        int last = i % 10;
        if (last == 3 || last == 4 || last == 7) return false;
        if (last == 0 || last == 1 || last == 8) return good(i / 10, flag);
        return good(i / 10, true);
    }

    /*
	Algorithm 2: DP
		dp[i] represent if the ith number is a what kind of number.
		dp[i] = 0: invalid
		dp[i] = 1: invalid but same after rotation
		dp[i] = 2: good number

		base case: when i < 10, dp[i] = 1 for {0,1,8}, dp[i] = 2 for {3,5,6,9}
		induction rule: int a = dp[i/10], b = dp[i%10]. If a=1&&b=1, dp[i] = 1.
			else if a>=1&&b>=1, dp[i]=2. 
		Once I find dp[i] = 2, I make count++ and return it as result eventually.

	Complexity Analysis:
	T: O(N)
	S: O(N)
    */
    public int rotatedDigitsII(int N) {
        int[] dp = new int[N+1];
        int count = 0;
        for (int i = 0; i <= N; ++i) {
            if (i < 10) {
                // base case
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i/10], b = dp[i%10];
                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}