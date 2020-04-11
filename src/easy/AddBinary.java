/**
 * 
 */
package easy;

/**
 * @author wangxinyu
 *
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		if(a.equals("0")) return b;
		if(b == "0") return a;
		int length = a.length() > b.length() ? a.length() : b.length();
		String q = "";
		for(int i = 0; i < length - a.length(); i++){
			q = "0" + q;
		}
		a = q + a;
		q="";
		for(int i = 0; i < length - b.length(); i++){
			q = "0" + q;
		}
		b = q + b;
		
		char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int[] z = new int [length+1];
        int[] m = new int [length];
        int[] n = new int [length];
        
        for(int i = 0; i < length; i++){
        		m[i] = x[i] - '0';
        }
        for(int i = 0; i < length; i++){
    			n[i] = y[i] - '0';
        }
        for(int i = length-1; i >= 0; i--){
        		z[i+1] = m[i] + n[i] + z[i+1];
        		if(z[i+1] > 1){
        			z[i] = z[i] + z[i+1] / 2;
        			z[i+1] = z[i+1] % 2;
        		}
        }
        
        
        String result = "";
        for(int i = 0; i < z.length; i++){
        		result = result + z[i];
        }
        while(result.startsWith("0")){
        		result = result.replaceFirst("0", "");
        }
        return result;
    }
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	public static void print(char[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary(
				"100",
				"110010"));
	}
}
