package string;

import java.util.*;

public class ReorderLogFiles {
	/*
	Q: You have an array of logs.  Each log is a space delimited string of words. For 
	each log, the first word in each log is an alphanumeric identifier.  Then, either:
	Each word after the identifier will consist only of lowercase letters, or; Each 
	word after the identifier will consist only of digits. We will call these two 
	varieties of logs letter-logs and digit-logs. It is guaranteed that each log has 
	at least one word after its identifier.
	Reorder the logs so that all of the letter-logs come before any digit-log.  The 
	letter-logs are ordered lexicographically ignoring identifier, with the identifier 
	used in case of ties.  The digit-logs should be put in their original order.
	Return the final order of the logs.

	1. 0 <= logs.length <= 100
	2. 3 <= logs[i].length <= 100
	3. logs[i] is guaranteed to have an identifier, and a word after the identifier.
	*/

	/*
	Algorithm: custom sort
		Override compare method of interface Comparator, if two string are both number-
		log, we just return 0 which means they are tie since they need to keep original
		order. If one is letter-log, another is number-log, just put letter-log ahead
		of number-log one. Otherwise, we use compareTo to compare the substring of
		content of two strings. If there is a tie, we compare the identifier.

	Complexity Analysis:
	T: O(A*logA) A is the length of contents of the string in the given array.
	S: O(A)
	*/
	public String[] reorderLogFiles(String[] logs) {
		Comparator<String> myCom = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int idx1 = s1.indexOf(' ');
				int idx2 = s2.indexOf(' ');
				char first = s1.charAt(idx1 + 1);
				char second = s2.charAt(idx2 + 1);
				if (Character.isDigit(first)) {
					if (Character.isDigit(second)) {
						return 0;
					}
					return 1;
				}
				if (Character.isDigit(second)) {
					return -1;
				}
				int decision = s1.substring(idx1 + 1).compareTo(s2.substring(idx2 + 1));
				if (decision == 0) {
					return s1.substring(0, idx1).compareTo(s2.substring(0, idx2));
				}
				return decision;
			}
		};
		Arrays.sort(logs, myCom);
		return logs;
	}
}