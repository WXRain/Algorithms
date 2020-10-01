package challenge;

public class First {
    public int minOperations(String[] logs) {
        int num = 0;
        for(String str : logs){
            if(str.equals("../")){
                if(num > 0) num--;
                continue;
            }
            if(str.equals("./")) continue;
            num++;
        }
        return num;
    }
}
