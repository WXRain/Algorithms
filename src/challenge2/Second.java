package challenge2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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


public class Second {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> layer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return true;
        q.offer(root);
        TreeNode last = root;
        TreeNode curLast = root;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            list.add(t.val);
            if(t.left != null){
                q.offer(t.left);
                curLast = t.left;
            }
            if(t.right != null){
                q.offer(t.right);
                curLast = t.right;
            }
            if(t == last){
                layer.add(list);
                list = new ArrayList<>();
                last = curLast;
            }
        }
        for(int i = 0; i < layer.size(); i++){
            List<Integer> l = layer.get(i);
            if(l.size() == 0) continue;
            if(i % 2 == 0){
                if(l.size() == 1 && l.get(0) % 2 == 1) continue;
                if(l.get(0) % 2 == 0) return false;
                for(int j = 1; j < l.size(); j++){
                    if(l.get(j) % 2 == 1 && l.get(j) > l.get(j-1));
                    else return false;
                }
            }else{
                if(l.size() == 1 && l.get(0) % 2 == 0) continue;
                if(l.get(0) % 2 == 1) return false;
                for(int j = 1; j < l.size(); j++){
                    if(l.get(j) % 2 == 0 && l.get(j) < l.get(j-1));
                    else return false;
                }
            }
        }
        return true;
    }
}
