package stariq.older;

import jdk.nashorn.api.tree.Tree;
import stariq.datastructures.nodes.TreeNode;

import java.util.*;
import java.util.LinkedList;

public class Rough {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        int store = stack.pop();
        if(stack.isEmpty() || store != 1) {
            System.out.println("bleh");
        }
    }

    public boolean method(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if(s.toLowerCase().charAt(start) != s.toLowerCase().charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }



        }
        return true;
    }






}
