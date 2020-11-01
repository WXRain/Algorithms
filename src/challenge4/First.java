package challenge4;

public class First {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            int loc = 0;
            for (int j = 0; j < pieces[i].length; j++, loc++) {
                if (loc == 0)
                    loc = findLocation(pieces[i][j], arr);
                if (loc == -1 || loc >= arr.length) return false;
                if (pieces[i][j] != arr[loc]) return false;
            }
        }
        return true;
    }

    public int findLocation(int x, int[] arr) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }
}
