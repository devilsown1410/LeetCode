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
class FindElements {
    Set<Integer> st=new HashSet<>();
    public FindElements(TreeNode root) {
        if(root==null){
            return;
        }
        root.val=0;
        st.add(0);
        check(root,root.val);
    }
    public void check(TreeNode root,int x){
        if(root.left!=null){
            int xl=x*2+1;
            st.add(xl);
            check(root.left,xl);
        }if(root.right!=null){
            int xr=x*2+2;
            st.add(xr);
            check(root.right,xr);
        }
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */