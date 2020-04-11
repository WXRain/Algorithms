/**
 * 
 */
package medium;

import java.util.Arrays;

/**
 * @author wangxinyu
 *
 */

/* 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */

public class ZigzagConversion {

	public static String convert(String s, int numRows) {
		if(s == null || s.length() == 0) return "";
		if(numRows == 1) return s;
		int numColum = s.length() / (2 * numRows - 2) * (numRows - 1) + s.length() % (2 * numRows - 2);
        char[][] cs = new char[numRows][numColum];
        for(int x = 0; x < cs.length; x++){
        		Arrays.fill(cs[x], (char)0);
        }
        int i = 0, j = 0, location = 0;
        
        while(location < s.length()){
        		if(i == 0){
        			for(; i < numRows && location < s.length(); i++){
        				cs[i][j] = s.charAt(location);
        				location++;
        			}
        			j++;
        		}
        		if(i == numRows){
        			i -= 2;
        			for(; i > 0 && location < s.length(); i--){
        				cs[i][j] = s.charAt(location);
        				location++;
        				j++;
        			}
        		}
        }
        
        return result(cs);
    }
	
	public static String result(char[][] cs){
		String s = "";
		for(int i = 0; i < cs.length; i++){
			for(int j = 0; j < cs[i].length; j++){
				System.out.print(cs[i][j] + "\t");
				if(cs[i][j] != 0){
					s += cs[i][j];
				}
			}
			System.out.println();
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(convert("abcdefghijklmnopqrstuvwxyz", 5));
	}
	
}
