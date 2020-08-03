package easy;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings415 {
    public String addStrings(String num1, String num2) {

        if (num2.length() > num1.length()) {
            return addStrings(num2, num1);
        }

        char[] ch1s = num1.toCharArray();
        char[] ch2s = num2.toCharArray();

        int add = 0;
        int diff = ch1s.length - ch2s.length;
        char[] rs = new char[ch1s.length + 1];

        for (int i = ch1s.length - 1; i >= 0; i --) {
            add = add + (ch1s[i] - '0') + (i>= diff? (ch2s[i - diff] - '0'): 0);
            rs[i + 1] = (char) ((add) % 10 + '0');
            add /= 10;
        }

        if (add > 0) {
            rs[0] = '1';
            return new String(rs);
        } else {
            return new String(rs, 1, num1.length());
        }


//        StringBuffer sb1 = new StringBuffer(num1);
//        StringBuffer sb2 = new StringBuffer(num2);
//        sb1 = sb1.reverse();
//        sb2 = sb2.reverse();
//
//        int l1 = num1.length();
//        int l2 = num2.length();
//
//        int[] in1 = new int[l1];
//        int[] in2 = new int[l2];
//
//        for(int i = 0; i < l1; i++){
//            in1[i] = sb1.charAt(i) - '0';
//        }
//        for(int i = 0; i < l2; i++){
//            in2[i] = sb2.charAt(i) - '0';
//        }
//
//        int jw = 0;
//        int l = Math.max(l1, l2);
//        int[] result = new int[l];
//
//        for(int i = 0; i < l; i++){
//            int x;
//            if(i < l1 && i < l2){
//                x = in1[i] + in2[i] + jw;
//            }else if(i < l1){
//                x = in1[i] + jw;
//            }else{
//                x = in2[i] + jw;
//            }
//            result[i] = x % 10;
//            jw = x / 10;
//        }
//
//        String s = "";
//        for(int i = 0; i < l; i++){
//            s = result[i] + s;
//        }
//        if(jw != 0) s = jw + s;
//        return s;
    }
}
