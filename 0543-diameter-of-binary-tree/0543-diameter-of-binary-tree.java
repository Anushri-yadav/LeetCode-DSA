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
    int maxdia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> dp=new HashMap<>();
       level(root,dp);
       return maxdia;
    }
    int level(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left=level(root.left,dp);
        int right=level(root.right,dp);
        maxdia=Math.max(maxdia,left+right);
        int height=1+Math.max(left,right);
        dp.put(root,height);
        return height;
    }
}

  

//  if(root==null) return 0;
//       level(root);
//       return max;
//     }
//     int level(TreeNode root){
//         if(root==null) return 0;
//         int left=level(root.left);
//         int right=level(root.right);
//         int num=left+right;
//         if(max<num) max=num;
//         return 1+Math.max(left,right);


//   max=0;
//         level(root);
//         return max;
//     }
//     int level(TreeNode root){
//         if(root ==null) return 0;
//         int leftlevel=level(root.left);
//         int rightlevel=level(root.right);
//         max=Math.max(max,leftlevel+rightlevel);
//         return 1+Math.max(leftlevel,rightlevel);