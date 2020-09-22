package hard;

public class MinCameraCover968 {

    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return needCamera(root) == 3 ? res + 1 : res;
    }

    // 0：该位置已经填充了（但是是沾孩子节点的光而跟着填充）；
    // 1：该位置为叶子节点：2：该节点被填充（实打实的填充，而不是沾光）
    // 3：该位置左右孩子节点都被填充，但节点急需填充
    private int needCamera(TreeNode root) {
        // 根结点为空
        if (root == null) return 0;
        // 左右节点均为空
        if (root.left == null && root.right == null) return 1;
        int left = needCamera(root.left);
        int right = needCamera(root.right);
        // 左右节点至少一个为叶子结点或者左右节点急需填充
        if (left == 1 || right == 1 || left == 3 || right == 3) {
            res += 1;
            return 2;
        }
        //左右节点至少一个已经填充
        if (left == 2 || right == 2) return 0;
        return 3;
    }
}
