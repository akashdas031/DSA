package DSA.GFG;

public class secondLargestElement {
    public static int getSecondLargestElement(int[] nums){
          int largest=Integer.MIN_VALUE;
          int secondLargest=Integer.MIN_VALUE;
          for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
            }else if(nums[i] >secondLargest && nums[i] != largest){
                secondLargest=nums[i];
            }
          }
          if(secondLargest<0){
            return -1;
          }
          return secondLargest;
    }
    public static void main(String[] args) {
        int[] nums={1,2,4,77,66,3,24,65};
        System.out.println("Second largest number in the array is : "+getSecondLargestElement(nums));
    }
}
