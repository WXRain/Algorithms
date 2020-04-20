/**
 * 
 */
package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Utils;

/**
 * @author rain
给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。

如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。

 

示例 1：

输入：words = ["mass","as","hero","superhero"]
输出：["as","hero"]
解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
["hero","as"] 也是有效的答案。
示例 2：

输入：words = ["leetcode","et","code"]
输出：["et","code"]
解释："et" 和 "code" 都是 "leetcode" 的子字符串。
示例 3：

输入：words = ["blue","green","bu"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-matching-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Stringmatchinginarray {
	public static List<String> stringMatching(String[] words) {
		if(words == null || words.length == 1) return new LinkedList<String>();
        Set<String> result = new HashSet<String>();
        for(int i = 0; i < words.length; i++){
        		for(int j = 0; j < words.length; j++){
        			if(i == j) continue;
        			if(words[i].contains(words[j])) result.add(words[j]);
        		}
        }
        return new LinkedList<String>(result);
    }
	
	public static void main(String[] args) {
		String[] words = {"mass","as","hero","superhero"};
		Utils.printList(stringMatching(words));
	}
}
