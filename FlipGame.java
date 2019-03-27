package string;

import java.util.*;

public class FlipGame {
	/*
	Q: You are playing the following Flip Game with your friend: Given a string that 
	contains only these two characters: + and -, you and your friend take turns to 
	flip two consecutive "++" into "--". The game ends when a person can no longer 
	make a move and therefore the other person will be the winner.
	Write a function to compute all possible states of the string after one valid move.
	If there is no valid move, return an empty list [].
	*/

	/*
	Algorithm: 
		For each index we check if there is "++" starting from current index. 

	Complexity Analysis:
	T: O(n) n is the length of the given string.
	S: O(n * x) x is the final size of list.
	*/
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        char[] ch = s.toCharArray();
        for (; i < s.length() - 1; ++i){
            if (ch[i] == '+' && ch[i + 1] == '+') {
                ch[i] = '-';
                ch[i + 1] = '-';
                res.add(new String(ch));
                ch[i] = '+';
                ch[i + 1] = '+';
            }
        }
        return res;
    }
}