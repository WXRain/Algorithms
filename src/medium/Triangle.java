/**
 * 
 */
package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rain
 *
 */
public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 1) return triangle.get(0).get(0);
		int i, j, min;
		for(i = triangle.size()-2; i >= 0; i--){
			for(j = 0; j < triangle.get(i).size(); j++){
				min = Math.min(triangle.get(i).get(j) + triangle.get(i+1).get(j), 
						triangle.get(i).get(j) + triangle.get(i+1).get(j+1));
				triangle.get(i).set(j, min);
			}
		}
		return triangle.get(0).get(0);
    }
	
	public static void main(String[] args) {
		int[][] tri = {{2}, {3,4}, {6,5,7}};
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		for(int i = 0; i < tri.length; i++){
			List<Integer> l = new LinkedList<Integer>();
			for(int j = 0; j < tri[i].length; j++){
				l.add(tri[i][j]);
			}
			triangle.add(l);
		}
		System.out.println(minimumTotal(triangle));
	}
}
