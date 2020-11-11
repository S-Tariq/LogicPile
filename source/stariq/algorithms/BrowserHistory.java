package stariq.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-browser-history/
public class BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("jrbilt.com");
        bh.visit("uiza.com");
        bh.forward(3);
        bh.forward(3);
        bh.visit("fveyl.com");
        bh.visit("hyhqfqf.com");
        bh.back(3);
        bh.visit("cccs.com");
        bh.visit("bivz.com");
        bh.forward(6);
        System.out.println(bh.back(1));
    }

    List<String> browserList;
    int currentIndex;

    public BrowserHistory(String homepage) {
        browserList = new ArrayList<>();
        browserList.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        if(currentIndex + 1 != browserList.size()) {
            // Reassigns the browserList as a new shorter list until current index.
            //browserList = browserList.subList(0, currentIndex + 1);
            // Removes the sublist after current index.
            browserList.subList(currentIndex + 1, browserList.size()).clear();
        }
        browserList.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        int newIndex = currentIndex - steps;
        currentIndex = (newIndex >= 0) ? newIndex : 0;
        return browserList.get(currentIndex);
    }

    public String forward(int steps) {
        int newIndex = currentIndex + steps;
        currentIndex = (newIndex < browserList.size()) ? newIndex : browserList.size() - 1;
        return browserList.get(currentIndex);
    }
}
