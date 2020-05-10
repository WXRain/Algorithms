/**
 * 
 */
package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rain
 *
 */
public class PascalTriangleII119 {
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		List<Integer> l = new LinkedList<Integer>();
		l.add(1);
		list.add(l);
        int i, j;
        if(rowIndex == 0) return list.get(0);
        for(i = 1; i <= rowIndex; i++){
        		List<Integer> a = new LinkedList<Integer>();
        		a.add(1);
        		for(j = 1; j < i; j++){
        			a.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
        		}
        		a.add(1);
        		list.add(a);
        }
        return list.get(rowIndex);
    }
}
