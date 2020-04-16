/**
 * 
 */
package medium;

import util.Utils;

/**
 * @author wangxinyu
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 *
 */
public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, j = 0;
        int allGas = 0, allCost = 0, length = gas.length, result = 0;
        for(i = 0; i < gas.length; i++){
        		allGas += gas[i];
        }
        for(i = 0; i < cost.length; i++){
        		allCost += cost[i];
        }
        if(allCost > allGas) return -1;
        
        for(i = 0; i < length; i++){
        		result = 0;
        		if(!check(gas, cost, i)) continue;
        		else{
        			result = result + gas[i] - cost[i];
        			for(j = i+1; j % length != i; j++){
        				result = result + gas[j%length] - cost[j%length];
        				if(result < 0) break;
        			}
        		}
        		if(result >= 0) return i;
        }
        return -1;
    }
	public static boolean check(int[] gas, int[] cost, int i){
		if(i >= gas.length) return false;
		if(gas[i] < cost[i]) return false;
		return true;
	}
	
	public static void main(String[] args) {
		int[] gas = Utils.string2intarray("[1,2,3,4,5]");
		int[] cost = Utils.string2intarray("[3,4,5,1,2]");
		System.out.println(canCompleteCircuit(gas, cost));
	}
	/**
	 * 
	 * @time  O（n）
	 * @param currntSum是用来确定选择的站点是否符合条件
	 * @param totalSum是用来确定给定序列是否存在路径
	 * @param currentSumLeastIndex是用来确定最终选择的站点
 const canCompleteCircuit = function(gas, cost) {
  if(!gas){
    return -1;
  }

  if(!gas.length){
    return -1;
  }

  let currentSum = 0, currentSumLeastIndex = null, totalSum = 0;
  for(let i = 0; i < gas.length; i++){
    let diff = gas[i] - cost[i];

    if(currentSumLeastIndex === null){
      currentSumLeastIndex = i;
    }

    currentSum += diff;
    totalSum += diff;

    if(currentSum < 0){
      currentSum = 0;
      currentSumLeastIndex = null;
    }

  }

  if(totalSum < 0){
    return -1;
  }

  return currentSumLeastIndex !== null ? currentSumLeastIndex : -1;
};
	 */
}
