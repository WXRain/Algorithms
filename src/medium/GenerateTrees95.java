package medium;

import medium.RightSideView.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateTrees95 {

    /**
     *
     * @param n
     * @return
     * 对于连续整数序列[left, right]中的一点i，若要生成以i为根节点的BST，则有如下规律：
     *
     * i左边的序列可以作为左子树结点，且左儿子可能有多个，所以有List<TreeNode> leftNode = generate(left, i - 1);
     * i右边的序列可以作为右子树结点，同上所以有List<TreeNode> rightNode = generate(i + 1, right);
     * 产生的以当前i为根结点的BST（子）树有left_nodes.size() * right_nodes.size()个，遍历每种情况，即可生成以i为根节点的BST序列；
     * 然后以for循环使得[left, right]中每个结点都能生成子树序列。
     */
    public List<TreeNode> generateTrees(int n) {
        if(n >= 1) return generate(1, n);
        else return new ArrayList<TreeNode>();
    }

    private List<TreeNode> generate(int left, int right){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(left > right){
            result.add(null);
            return result;
        }

        for(int i = left; i <= right; i++){
            List<TreeNode> leftNode = generate(left, i-1);
            List<TreeNode> rightNode = generate(i+1, right);

            for(TreeNode tl : leftNode){
                for(TreeNode tr : rightNode){
                    TreeNode t = new TreeNode(i);
                    t.left = tl;
                    t.right = tr;
                    result.add(t);
                }
            }
        }
        return result;
    }
}
