package medium;

import java.util.LinkedList;
import java.util.Queue;

public class FindOrder210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        int[] inDegree = new int[numCourses];
        for(int[] p : prerequisites){
        		inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
        		if(inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        int[] result = new int [numCourses];
        while(!queue.isEmpty()){
        		int q = queue.poll();
        		result[count++] = q;
        		for(int[] p : prerequisites){
        			if(p[1] == q){
        				inDegree[p[0]]--;
        				if(inDegree[p[0]] == 0) queue.offer(p[0]);
        			}
        		}
        }
        if(count == numCourses) return result;
        return new int[0];
    }
}
