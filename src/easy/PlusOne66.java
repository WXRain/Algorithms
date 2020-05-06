/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
public class PlusOne66 {
	public static int[] plusOne(int[] digits) {
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		int[] result = new int [digits.length + 1];
		int i = digits.length - 1;
		for(; i >= 0; i--){
			if(digits[i] >= 10 && i > 0){
				digits[i-1] = digits[i] / 10 + digits[i-1];
				digits[i] = digits[i] % 10;
			}
			if(digits[i] >= 10 && i == 0){
				result[0] = digits[i] / 10;
				digits[i] = digits[i] % 10;
				for(int j = 0; j < digits.length-1; j++){
					result[j+1] = digits[i];
				}
				return result;
			}
		}
		return digits;
    }
	public static void main(String[] args) {
		int[] digits = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
		int[] result = plusOne(digits);
		String arr = "";
		for(int i = 0; i < result.length; i++){
			arr = arr + result[i];
		}
		System.out.println(arr);
	}
}
