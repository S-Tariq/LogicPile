package stariq.algorithms.array;

import java.util.*;

// Question in data
// https://leetcode.com/problems/kill-process/
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Parent to list of Children map.
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            List<Integer> childList = parentChildMap.get(parent);
            if(childList != null) {
                childList.add(child);
            } else {
                childList = new ArrayList<>();
                childList.add(child);
                parentChildMap.put(parent, childList);
            }
        }

        Queue<Integer> killQueue = new LinkedList<>();
        List<Integer> killedProcess = new ArrayList<>();
        killQueue.add(kill);
        while(!killQueue.isEmpty()) {
            int killedPid = killQueue.poll();
            if(parentChildMap.containsKey(killedPid)) {
                List<Integer> childList = parentChildMap.get(killedPid);
                // Adds the whole list to the queue.
                killQueue.addAll(childList);
            }
        }
        return killedProcess;
    }
}
