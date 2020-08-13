package util;

public class RandomChinese {
    public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }
    public static void main(String[] args){
        System.out.println(getRandomChar());
    }
}
