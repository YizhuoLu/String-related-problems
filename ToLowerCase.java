package string;

public class ToLowerCase {
	/*
	 * Q: Implement function ToLowerCase() that has a string parameter str, and returns the same 
	 * string in lowercase.
	 * */
	
	/*
	 * Algorithm: 'a' = 'A' + 32 in ASCII code.
	 * 
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public String toLowerCase(String str) {
        // corner case
        if (str == null|| str.length() == 0) {
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i=0; i < ch.length; ++i) {
            if (ch[i] >= 'A' && ch[i] <= 'Z'){
                ch[i] += 32;
            }
        }
        return new String(ch);
    }
}
