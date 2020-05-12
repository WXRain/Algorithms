package easy;

import java.util.Collections;
import java.util.LinkedList;
/**
 * 
 *@author rain
						设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
						
						push(x) —— 将元素 x 推入栈中。
						pop() —— 删除栈顶的元素。
						top() —— 获取栈顶元素。
						getMin() —— 检索栈中的最小元素。
						 
						
						示例:
						
						输入：
						["MinStack","push","push","push","getMin","pop","top","getMin"]
						[[],[-2],[0],[-3],[],[],[],[]]
						
						输出：
						[null,null,null,null,-3,null,0,-2]
						
						解释：
						MinStack minStack = new MinStack();
						minStack.push(-2);
						minStack.push(0);
						minStack.push(-3);
						minStack.getMin();   --> 返回 -3.
						minStack.pop();
						minStack.top();      --> 返回 0.
						minStack.getMin();   --> 返回 -2.
						 
						
						提示：
						
						pop、top 和 getMin 操作总是在 非空栈 上调用。
						
						来源：力扣（LeetCode）
						链接：https://leetcode-cn.com/problems/min-stack
						著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack155 {
	/** initialize your data structure here. */
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> sort = new LinkedList<Integer>();
	int min = Integer.MAX_VALUE;
    public MinStack155() {
        
    }
    
    public void push(int x) {
    		stack.add(x);
    		sort.add(x);
    		Collections.sort(sort);
    }
    
    public void pop() {
    		Integer i = stack.removeLast();
    		sort.remove(i);
    }
    
    public int top() {
    		return stack.getLast();
    }
    
    public int getMin() {
    		return sort.get(0);
    }
}
