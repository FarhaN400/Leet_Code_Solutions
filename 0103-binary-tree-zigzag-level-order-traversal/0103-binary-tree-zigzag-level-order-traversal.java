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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Boolean flag = true;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                temp.add(0);
            }
            for(int i=0 ; i<size ; i++){
                TreeNode node = q.poll();
                int idx = flag ? i : size - i - 1;
                temp.set(idx , node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }
}