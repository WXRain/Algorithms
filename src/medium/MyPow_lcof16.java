package medium;

public class MyPow_lcof16 {
    public double myPow(double x, int n) {
        int m = Math.abs(n);
        double d = caculate(x, m);
        if(n < 0){
            d = 1 / d;
        }
        return d;
    }
    public double caculate(double x, int m){
        double res = x;
        while(m > 1){
            if(m % 2 == 1){
                res *= x;
                m--;
            }else{
                res *= res;
                m = m / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new MyPow_lcof16().myPow(2.0, 10);
    }
}
