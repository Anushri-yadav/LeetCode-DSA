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
      HashMap<TreeNode,Integer> dp=new HashMap<>();
       level(root,dp);
       return maxdia;
    }
    int level(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = Math.max(0, level(root.left, dp));
        int right = Math.max(0, level(root.right, dp));
        maxdia=Math.max(maxdia,left+right+root.val);
        int height=root.val+Math.max(left,right);
        dp.put(root,height);
        return height;
    }
}
