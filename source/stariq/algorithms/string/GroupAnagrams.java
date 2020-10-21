package stariq.algorithms.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        for(int i = 0; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            List<String> strList = groups.get(sorted);
            if(strList == null) {
                strList = new ArrayList<>();
                strList.add(strs[i]);
                groups.put(sorted, strList);
            } else {
                strList.add(strs[i]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : groups.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
