package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] array = new int[] {-10,-3,0,5,9};
        TreeNode.print(sortedArrayToBST(array));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    // DFS
    public static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(nums, left, mid - 1);
        root.right = constructTreeFromArray(nums, mid + 1, right);
        return root;
    }
}
