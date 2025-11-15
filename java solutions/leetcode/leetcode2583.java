import java.util.*;

public class leetcode2583 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
        Long ans = 0L;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode newNode = q.remove();
            if(newNode==null){
                heap.add(ans);
                ans = 0L;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                ans += (long) newNode.val;
                if(newNode.left!=null){
                    q.add(newNode.left);
                }
                if(newNode.right!=null){
                    q.add(newNode.right);
                }
            }
        }
        if(k> heap.size())
            return -1L;
        for (int i=1;i<k;i++){
            heap.remove();
        }
        return heap.remove();
    }

    public static TreeNode lc2641(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int level = 0, sum = 0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode newNode = q.remove();
            if(newNode==null){
                map.put(level,sum);
                level++; sum = 0;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                sum += newNode.val;
                if(newNode.left!=null)
                    q.add(newNode.left);
                if(newNode.right!=null)
                    q.add(newNode.right);
            }
        }
        root.val = 0;
        solve(root,0,map);
        return root;
    }
    private static void solve(TreeNode root, int level, HashMap<Integer, Integer> map){
        if(root==null) return;

        int sum = 0, levelSum = 0;
        if(map.containsKey(level+1))
            levelSum = map.get(level+1);//
        //calculating the sum of the sibling of the root child
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;

        //setting the value of left and right child
        if(root.left!=null) root.left.val = levelSum - sum;
        if(root.right!=null) root.right.val = levelSum - sum;

        //calling again for left & right child
        solve(root.left,level+1,map);
        solve(root.right,level+1,map);
    }

    public static void main(String[] args) {

    }
}
