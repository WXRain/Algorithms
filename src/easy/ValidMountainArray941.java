package easy;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidMountainArray941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        if (A[0] > A[1]) return false;
        int i = 0;
        for (i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) continue;
            else break;
        }
        // 遍历到最后
        if (i >= A.length) return false;
        //找到山峰
        for (; i < A.length; i++) {
            if (A[i] < A[i - 1]) continue;
            else return false;
        }
        return true;
    }
}
