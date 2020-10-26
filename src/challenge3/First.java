package challenge3;

public class First {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] time = new int[releaseTimes.length];
        time[0] = releaseTimes[0];
        for(int i = 1; i < releaseTimes.length; i++){
            time[i] = releaseTimes[i] - releaseTimes[i-1];
        }
        int max = time[0], maxindex = 0;
        for(int i = 0; i < time.length; i++){
            if(time[i] > max){
                maxindex = i;
                max = time[i];
            }
        }
        char res = 'a';
        for(int i = 0; i < time.length; i++){
            if(time[i] == max){
                if(keysPressed.charAt(i) > res){
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }
}
