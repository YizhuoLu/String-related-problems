package string;

import java.util.*;

public class GroupShiftedStrings {
	/*
	Q: Given a string, we can "shift" each of its letter to its successive letter, 
	for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
	"abc" -> "bcd" -> ... -> "xyz".
	Given a list of strings which contains only lowercase alphabets, group all strings 
	that belong to the same shifting sequence.
	*/

	/*
	Algorithm: 
		Use HashMap to solve it. For each string in the given array, I firstly 
		calculate the offset by making letter[0] - 'a'. And then I traverse
		each letter of the current string to do letter[cur] - offset. If it
		< 'a', I'll do lettr + 26 to make it a lowercase character. All the job
		is to find the first possible string which will act as the key. Every
		time I do as this way, I can get the first starting string, if it is
		I will add it into the hashMap, otherwise, I will create a new entry.

	Complexity Analysis:
	T: O(SUM(ni) from 1 to m) m is the length of the array, ni is the length of each
		string.
	S: O(m) there will be m entries for the HashMap.
	*/
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (char ch : str.toCharArray()) {
                char cur = (char)(ch - offset);
                if (cur < 'a') {
                    cur += 26;
                }
                key += cur;
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> val = map.get(key);
            ans.add(val);
        }
        return ans;
    }
}