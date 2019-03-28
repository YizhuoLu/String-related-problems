package string;

import java.util.*;

public class DesignLogStorageSystem {
	/*
	Q: You are given several logs that each log contains a unique id and timestamp. 
	Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:
	Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal 
	numbers.
	Design a log storage system to implement the following functions:
	void Put(int id, string timestamp): Given a log's unique id and timestamp, store 
	the log in your storage system.
	int[] Retrieve(String start, String end, String granularity): Return the id of 
	logs whose timestamps are within the range from start to end. Start and end all 
	have the same format as timestamp. However, granularity means the time level for 
	consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:
	59:59", granularity = "Day", it means that we need to find the logs within the 
	range from Jan. 1st 2017 to Jan. 2nd 2017.

	1. There will be at most 300 operations of Put or Retrieve.
	2. Year ranges from [2000,2017]. Hour ranges from [00,23].
	3. Output for Retrieve has no order required.
	*/

	/*
	Algorithm 1: HashMap
		Make a <id, timestamp>, each time in put(), I just put new entry into the map.
		In retrieve() I just traverse the key set of map and tell if the corresponding
		timestamp is in the required range, if so, I add the id into the result list.

	Complexity Analysis:
	T: O(m + n * m * len(timestamp)) m is the times of calling put(), n is the number of
		calling retrieve().
	S: O(m)
	*/
	Map<Integer, String> map;
    
    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        for (int id : map.keySet()) {
            String time = map.get(id);
            String[] arr = time.split(":");
            String[] srr = s.split(":");
            String[] err = e.split(":");
            if (gra.equals("Year")) {
                if (arr[0].compareTo(srr[0]) >= 0 && arr[0].compareTo(err[0]) <= 0)
                {
                    res.add(id);
                }
            } else if (gra.equals("Month")) {
                String mine = arr[0] + arr[1];
                String ss = srr[0] + srr[1];
                String ee = err[0] + err[1];
                if (mine.compareTo(ss) >= 0 && mine.compareTo(ee) <= 0) {
                    res.add(id);
                }
            } else if (gra.equals("Day")) {
                String mine = arr[0] + arr[1] + arr[2];
                String ss = srr[0] + srr[1] + srr[2];
                String ee = err[0] + err[1] + err[2];
                if (mine.compareTo(ss) >= 0 && mine.compareTo(ee) <= 0) {
                    res.add(id);
                }
            } else if (gra.equals("Hour")) {
                String mine = arr[0] + arr[1] + arr[2] + arr[3];
                String ss = srr[0] + srr[1] + srr[2] + srr[3];
                String ee = err[0] + err[1] + err[2] + err[3];
                if (mine.compareTo(ss) >= 0 && mine.compareTo(ee) <= 0) {
                    res.add(id);
                }
            } else if (gra.equals("Minute")) {
                String mine = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
                String ss = srr[0] + srr[1] + srr[2] + srr[3] + srr[4];
                String ee = err[0] + err[1] + err[2] + err[3] + err[4];
                if (mine.compareTo(ss) >= 0 && mine.compareTo(ee) <= 0) {
                    res.add(id);
                }
            } else {
                // seconds
                if (time.compareTo(s) >= 0 && time.compareTo(e) <= 0) {
                    res.add(id);
                }
            }
        }
        return res;
    }

    /*
	Algorithm 2: slightly different implement way in retrieve(), just use substring
		and switch - case, no need to use split() to split into string array.

	Complexity Analysis:
	T: O(n) n is the number of entries of map since I traverse map calling retrieve()
	S: O(n) 
    */
    public LogSystemII() {
        map = new HashMap<>();
    }
    
    public void putII(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieveII(String s, String e, String gra) {
        int x = 0;
        switch (gra) {
            case "Year":
                x = 4;
                break;
            case "Month":
                x = 7;
                break;
            case "Day":
                x = 10;
                break;
            case "Hour":
                x = 13;
                break;
            case "Minute":
                x = 16;
                break;
            default:
                x = 19;
                break;
        }
        s = s.substring(0, x);
        e = e.substring(0, x);
        List<Integer> res = new ArrayList<>();
        for (int id : map.keySet()) {
            String cur = map.get(id).substring(0, x);
            if (cur.compareTo(s) >= 0 && cur.compareTo(e) <= 0) {
                res.add(id);
            }
        }
        return res;
    }

    /*
	Algorithm 3: Use subMap to do range query. The lower bound is 2000:01:01:00:00:00,
		the upper bound is 2017:12:31:23:59:59. Each time I concatenate the
		suffix from lower bound, upper bound with the start time, end time to decide
		the range and get the answer from the subMap of this range.
		*: Here I use a hashMap to map <granularity, index> index is where to do
		substring.
		*: I use a treeMap<timeStamp, List<Integer>(id)> to store log entry, wehre
		I use time stamp as key, corresponding ids loaded into list as values.

	Complexity Analysis:
	T: O(M*logN) M is the size of subset, N is the height of red-black tree.
	S: O(N) 
    */
	private String min, max;
    Map<String, Integer> idx;
    TreeMap<String, List<Integer>> logs;
    public LogSystemIII() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";
        idx = new HashMap<>();
        idx.put("Year", 4);
        idx.put("Month", 7);
        idx.put("Day", 10);
        idx.put("Hour", 13);
        idx.put("Minute", 16);
        idx.put("Second", 19);
        logs = new TreeMap<>();
    }
    
    public void putIII(int id, String timestamp) {
        if (!logs.containsKey(timestamp)) {
            logs.put(timestamp, new ArrayList<>());
        }
        logs.get(timestamp).add(id);
    }
    
    public List<Integer> retrieveIII(String s, String e, String gra) {
        int index = idx.get(gra);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0, index) + max.substring(index);
        Map<String, List<Integer>> range = logs.subMap(start, true, end, true);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entries : range.entrySet()) {
            res.addAll(entries.getValue());
        }
        return res;
    }
}