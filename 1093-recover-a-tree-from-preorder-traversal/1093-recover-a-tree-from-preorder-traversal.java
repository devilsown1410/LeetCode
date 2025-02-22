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
    int i=1;
    public TreeNode recoverFromPreorder(String traversal) {
        List<Integer>val=new ArrayList<>();
        List<Integer>lvl=new ArrayList<>();
        for(int i=0;i<traversal.length();i++){
            int d=0;
            if(traversal.charAt(i)=='-'){
                while(traversal.charAt(i)=='-'){
                    d++;
                    i++;
                }
            }
            lvl.add(d);
            int v=0;
            while(i<traversal.length() && traversal.charAt(i)!='-'){
                v=v*10+(traversal.charAt(i++)-'0');
            }
            val.add(v);
            i--;
        }
        HashMap<TreeNode,Integer>map=new HashMap<>();
        TreeNode root=new TreeNode(val.get(0));
        map.put(root,0);
        recover(root,val,lvl,map);
        return root;
    }
    public void recover(TreeNode root,List<Integer>val,List<Integer>lvl,HashMap<TreeNode,Integer>map){
        if(i==val.size())return;
        if(lvl.get(i)==map.get(root)+1){
                root.left=new TreeNode(val.get(i));
                map.put(root.left,lvl.get(i));
                i++;
                recover(root.left,val,lvl,map);
        }
        if(i<val.size() && lvl.get(i)==map.get(root)+1){
                root.right=new TreeNode(val.get(i));
                map.put(root.right,lvl.get(i));
                i++;
                recover(root.right,val,lvl,map);
            }
    }
}