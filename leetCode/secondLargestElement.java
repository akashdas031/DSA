package DSA.leetCode;

public class secondLargestElement {
    public static int secondLargest(int[] arr){
        int n=arr.length;
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if(arr[i]>second && arr[i] != first){
                second=arr[i];
            }
        }
        return second;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(secondLargest(arr));
    }
}
