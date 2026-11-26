/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxdia=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       level(root);
       return maxdia;
    }
    int level(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0, level(root.left));
        int right = Math.max(0, level(root.right));
        maxdia=Math.max(maxdia,left+right+root.val);
        int height=root.val+Math.max(left,right);
        return height;
    }
}
