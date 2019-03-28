package string;

import java.util.*;

public class FindDuplicateFileInSystem {
	/*
	Q: Given a list of directory info including directory path, and all the files with 
	contents in this directory, you need to find out all the groups of duplicate files 
	in the file system in terms of their paths.
	A group of duplicate files consists of at least two files that have exactly the 
	same content.
	A single directory info string in the input list has the following format:
	"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
	It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, 
	f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that 
	n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
	The output is a list of group of duplicate file paths. For each group, it contains 
	all the file paths of the files that have the same content. A file path is a 
	string that has the following format:
	"directory_path/file_name.txt"

	1. No order is required for the final output.
	2. You may assume the directory name, file name and file content only has letters 
	and digits, and the length of file content is in the range of [1,50].
	3. The number of files given is in the range of [1,20000].
	4. You may assume no files or directories share the same name in the same directory.
	5. You may assume each given directory info represents a unique directory. 
	Directory path and file info are separated by a single blank space.
	*/

	/*
	Algorithm: 
		I use a HashMap to record each content mapping corresponding directory + filename.
		After processing the whole string array. I will check the values of the map if
		the size of the list is larger than 1, I will add the whole list into the result.

	Complexity Analysis:
	T: O(SUM_i(x)) Just sum up all the length of strings in the given array.
	S: O(SUM_i(x)) almost I use a map to store all the strings that appearred.
	*/
	public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] arr = s.split(" ");
            for (int i = 1; i < arr.length; ++i) {
                int idx1 = arr[i].indexOf('(');
                int idx2 = arr[i].indexOf(')');
                String content = arr[i].substring(idx1 + 1, idx2);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                String value = arr[0] + "/" + arr[i].substring(0, idx1);
                map.get(content).add(value);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> val : map.values()) {
            if (val.size() > 1) {
                res.add(val);
            }
        }
        return res;
    }
}