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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int cLevel = 1;

        while(!q.isEmpty()){
            int levelSize = q.size();
            int lSum = 0;
            for(int i = 0 ; i< levelSize;i++){
                TreeNode node = q.poll();
                lSum += node.val;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(lSum > maxSum ){
                maxSum = lSum;
                maxLevel = cLevel;
            }
            cLevel++;
        }
        return maxLevel;
    }
}