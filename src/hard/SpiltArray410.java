package hard;

/**
 *给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiltArray410 {
    /**
     * 首先分析题意，可以得出结论，结果必定落在【max（nums）， sum（nums）】
     * 这个区间内，因为左端点对应每个单独的元素构成一个子数组，右端点对应所有元素
     * 构成一个子数组。
     *
     * 然后可以利用二分查找法逐步缩小区间范围，当区间长度为1时，即找到了最终答案。
     *
     * 每次二分查找就是先算一个mid值，这个mid就是代表当前猜测的答案，然后模拟一下
     * 划分子数组的过程，可以得到用这个mid值会一共得到的子区间数cnt，然后比较
     * cnt和m的关系，来更新区间范围。
     */
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = 1;
        for(int n: nums){
            sum += n;
            max = Math.max(max, n);
        }

        long r = sum;
        long l = max;

        while(l < r){
            long mid = l + (r-l)/2;
            int s = 0;
            int k = 0;
            for(int n: nums){
                s += n;
                if(s > mid){
                    s = n;
                    k++;
                }
            }

            if(s <= mid){
                k++;
            }else{
                k += 2;
            }

            if(k <= m){
                r = mid;
            }else{
                l = mid+1;
            }

        }
        return (int)r;
    }
}
