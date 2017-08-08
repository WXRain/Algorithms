package medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author wangxinyu
 *
 */

public class CombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		letterCombinations("4523");
	}
	
	public static List<String> letterCombinations(String digits) {
        char[] two = {'a', 'b', 'c'};
        char[] three = {'d', 'e', 'f'};
        char[] four = {'g', 'h', 'i'};
        char[] five = {'j', 'k', 'l'};
        char[] six = {'m', 'n', 'o'};
        char[] seven = {'p', 'q', 'r', 's'};
        char[] eight = {'t', 'u', 'v'};
        char[] nine = {'w', 'x', 'y', 'z'};
        
        List<String> result = new ArrayList<String>();
        
        for(int i = 0; i < digits.length(); i++){
        		char ch = digits.charAt(i);
        		if(ch == '2'){
        			result = combat(result, two);
        		}else if(ch == '3'){
        			result = combat(result,three);
        		}else if(ch == '4'){
        			result = combat(result,four);
        		}else if(ch == '5'){
        			result = combat(result,five);
        		}else if(ch == '6'){
        			result = combat(result,six);
        		}else if(ch == '7'){
        			result = combat(result,seven);
        		}else if(ch == '8'){
        			result = combat(result,eight);
        		}else if(ch == '9'){
        			result = combat(result,nine);
        		}
        }
        
        for(int i = 0; i < result.size(); i++){
        		System.out.print(result.get(i) + " ");
        }
        
        return result;
        
    }
	
	public static List<String> combat(List<String> list, char[] sz){
		List<String> newList = new ArrayList<String>();
		if(list.size() <= 0){
			for(int i = 0; i < sz.length; i++){
				newList.add(sz[i] + "");
			}
		}
		for(int i = 0; i < list.size(); i++){
			String str = list.get(i);
			for(int j = 0; j < sz.length; j++){
				newList.add(str + sz[j]);
			}
		}
		return newList;
	}
	 
}
