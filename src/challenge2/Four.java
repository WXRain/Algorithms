package challenge2;

public class Four {
    public static int minimumOneBitOperations(int n) {
        String bin = Integer.toBinaryString(n);
        if(n == 0) return 0;
        if(n == 1) return 1;
        int num = n;
        int num1 = 0;
        while(num != 0 && num != 1){
            num = oper1(bin);
            num1 ++;
            if(num == 0 || num == 1) break;
            bin = Integer.toBinaryString(num);
            num = oper2(bin);
            num1 ++;
        }
        int num2 = 0;
        num = n;
        bin = Integer.toBinaryString(n);
        while(num != 0 && num != 1){
            num = oper2(bin);
            num2 ++;
            if(num == 0 || num == 1) break;
            bin = Integer.toBinaryString(num);
            num = oper1(bin);
            num2 ++;
        }
        return Math.min(num1, num2);
    }
    public static int oper1(String bin){
        char[] chars = bin.toCharArray();
        if(chars[chars.length - 1] == '0'){
            chars[chars.length - 1] = '1';
        }else{
            chars[chars.length - 1] = '0';
        }
        String s = new String(chars);
        return Integer.parseInt(s, 2);
    }
    public static int oper2(String bin){
        char[] chars = bin.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1'){
                System.out.println(chars[i]);
                chars[i] = '0';
                System.out.println(chars[i]);
                break;
            }
        }
        String s = new String(chars);
        return Integer.parseInt(s, 2);
    }
    public static void main(String[] args){
        System.out.println(minimumOneBitOperations(333));
    }
}
