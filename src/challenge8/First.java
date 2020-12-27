package challenge8;

import java.util.HashSet;
import java.util.Set;

public class First {
    public boolean halvesAreAlike(String s) {
        int num = s.length() / 2;
        String a = s.substring(0, num);
        String b = s.substring(num, s.length());
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int numa = 0, numb = 0;
        for(int i = 0; i < a.length(); i++){
            if(set.contains(a.charAt(i))) numa++;
        }
        for(int i = 0; i < b.length(); i++){
            if(set.contains(b.charAt(i))) numb++;
        }
        return (numa == numb);
    }
}
