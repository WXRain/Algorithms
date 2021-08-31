package sort;

public class QuickSort {

    public static int partation(int[] arr, int left, int right){
        int partationIndex = left;
        int temp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= arr[partationIndex]){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= arr[partationIndex]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int partationIndex = partation(arr, left, right);
            quickSort(arr, 0, partationIndex - 1);
            quickSort(arr, partationIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = {4,9,2,6,13,100,65,34,28,67,9,4,23};
        quickSort(a, 0, a.length - 1);
        for(int i : a){
            System.out.print(i + " ");
        }
    }

}
