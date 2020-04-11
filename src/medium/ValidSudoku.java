/**
 * 
 */
package medium;

/**
 * @author wangxinyu
 *
 */

/**
 * 
 * [
 * ['.','8','7','6','5','4','3','2','1'],
 * ['2','.','.','.','.','.','.','.','.'],
 * ['3','.','.','.','.','.','.','.','.'],
 * ['4','.','.','.','.','.','.','.','.'],
 * ['5','.','.','.','.','.','.','.','.'],
 * ['6','.','.','.','.','.','.','.','.'],
 * ['7','.','.','.','.','.','.','.','.'],
 * ['8','.','.','.','.','.','.','.','.'],
 * ['9','.','.','.','.','.','.','.','.']
 * ]
 *
 */

class ValidSudoku {
	public int check[] = new int[10];
    public boolean isValidSudoku(char[][] board) {
        setCheck(check);
        boolean isRow = checkRow(board);
        setCheck(check);
        boolean isColumn = checkColumn(board);
        setCheck(check);
        boolean isNine = checkNine(board);
        return isRow && isColumn && isNine;
    }
    
    public boolean checkRow(char[][] board){
        int i, j;
        for(i = 0; i < 9; i++){
            setCheck(check);
            for(j = 0; j < 9; j++){
            		if(board[i][j] == '.') continue;
            		if(check[board[i][j] - '1'] == 0) 
                    check[board[i][j] - '1'] = 1;
                else return false;
            }
        }
        return true;
     }
    
    public boolean checkColumn(char[][] board){
        int i, j;
        for(i = 0; i < 9; i++){
            setCheck(check);
            for(j = 0; j < 9; j++){
            		if(board[j][i] == '.') continue;
            		else if(check[board[j][i] - '1'] == 0) 
                    check[board[j][i] - '1'] = 1;
                else return false;
            }
        }
        return true;
    }
    
    public boolean checkNine(char[][] board){
        int i, j, k;
        for(k = 0; k < 3; k++){
           setCheck(check);
           for(i = k*3; i < (k+1)*3; i++){
        	   		for(j = 0; j < 3; j++){
        	   			if(board[i][j] == '.') continue;
        	   			else if(check[board[i][j] - '1'] == 0) 
                            check[board[i][j] - '1'] = 1;
                        else return false;
        	   		}
           }
        	   		setCheck(check);
        	   for(i = k*3; i < (k+1)*3; i++){
        	   		for(j = 3; j < 6; j++){
        	   			if(board[i][j] == '.') continue;
        	   			else if(check[board[i][j] - '1'] == 0) 
                            check[board[i][j] - '1'] = 1;
                        else return false;
        	   		}
        	   }
        	   		setCheck(check);
        	   for(i = k*3; i < (k+1)*3; i++){
        	   		for(j = 6; j < 9; j++){
        	   			if(board[i][j] == '.') continue;
        	   			else if(check[board[i][j] - '1'] == 0) 
                            check[board[i][j] - '1'] = 1;
                        else return false;
        	   		}
        	   }
        }
        return true;
    }
    
    public void setCheck(int check[]){
        for(int i = 0; i < 10; i++){
            check[i] = 0;
        }
    }
    
    public static void main(String[] args) {
    		char board[][] = {
    				{'.','8','7','6','5','4','3','2','1'},
    				{'2','.','.','.','.','.','.','.','.'},
    				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
    				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}};
    		//boolean a = isValidSudoku(board);
		//System.out.println(a);
	}
}
