二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/recover-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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
    private TreeNode node1;
    private TreeNode node2;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp=node1.val;
        node1.val=node2.val;
        node2.val=tmp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(pre!=null&&pre.val>root.val){
            if(node1==null) node1=pre;
            node2=root;
        }
        pre=root;
        inorder(root.right);
    }
}