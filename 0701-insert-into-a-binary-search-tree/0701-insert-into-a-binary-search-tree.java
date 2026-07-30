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
    public TreeNode insertIntoBST(TreeNode root, int key) {
        if(root == null) return new TreeNode(key);
        TreeNode temp = root;
        while(true){
            if(temp.val > key){
                if(temp.left == null){
                    TreeNode node = new TreeNode(key,null,null);
                    temp.left = node;
                    break;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    TreeNode node = new TreeNode(key,null,null);
                    temp.right = node;
                    break;
                }
                temp = temp.right;
            }
        }
        return root;
    }
}