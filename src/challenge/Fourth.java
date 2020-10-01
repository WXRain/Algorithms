package challenge;

public class Fourth {
    public int maximumRequests(int n, int[][] requests) {
        int[][] x = new int[n][n];
        int sum = 0;
        for(int i = 0; i < requests.length; i++){
            x[requests[i][0]][requests[i][1]]++;
        }
        for(int i = 0; i < n; i++){
            sum += x[i][i];
            x[i][i] = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < 2*n; m++){
            for(int j = 0; j < n; j++){
                if(x[j][m-j] < min) min = x[j][m-j];
            }
            sum += min;
        }
        return sum;
    }
}
