package stariq.datastructures.custom;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-browser-history/
public class BrowserHistory {

    List<String> history;
    int currentIdx;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIdx = 0;
    }

    public void visit(String url) {
        history.subList(currentIdx+1, history.size()).clear();
        history.add(url);
        currentIdx++;
    }

    public String back(int steps) {
        currentIdx = Math.max(currentIdx - steps, 0);
        return history.get(currentIdx);
    }

    public String forward(int steps) {
        currentIdx = Math.min(currentIdx + steps, history.size()-1);
        return history.get(currentIdx);
    }
}
