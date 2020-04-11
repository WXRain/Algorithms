/**
 * 
 */
package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangxinyu
 *
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		if(numRows == 0) return new LinkedList<List<Integer>>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> inti = new LinkedList<Integer>();
        inti.add(1);
        result.add(inti);
        int i, j;
        for(i = 1; i < numRows; i++){
        		List<Integer> list = new LinkedList<Integer>();
        		list.add(1);
        		for(j=1; j < i; j++){
        			list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
        		}
        		list.add(1);
        		result.add(list);
        }
        return result;
    }
}
