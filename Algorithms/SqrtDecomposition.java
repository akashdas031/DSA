package DSA.Algorithms;

import java.util.Arrays;

public class SqrtDecomposition {
   public static void main(String[] args) {
    int [] nums={2,3,5,4,6,8,7,9,2,1};
    int[] blocks=decompose(nums);
    int sqrt=(int)Math.sqrt(nums.length);
    System.out.println(Arrays.toString(blocks));
    System.out.println(queryForSum(blocks,nums,2,7,sqrt));
    update(blocks, nums, 7, 10, sqrt);
    System.out.println("After Updation : "+Arrays.toString(blocks));
    System.out.println("After updation : "+Arrays.toString(nums));
    System.out.println("Sum of query after updation : "+queryForSum(blocks,nums,2,7,sqrt));
   }
   public static int[] decompose(int[] nums){
    int n=nums.length;
    int sqrt=(int)Math.sqrt(n);
    int blocks_id=-1;
    //build blocks of size sqrt
    int[] blocks=new int[sqrt+1];
    // Arrays.fill(blocks, 1);
    //build blocks array 
    for (int i = 0; i < n; i++) {
        //check if the current block ends and create new block
        if(i%sqrt==0){
            blocks_id++;
        }
       blocks[blocks_id] +=nums[i];
        // blocks[blocks_id] *=nums[i];
    }
    return blocks;
   }
   //query to get sum between two index
   public static int queryForSum(int[] blocks,int[] nums,int left,int right,int sqrt){
    int ans=0;
    //left part 
    while(left%sqrt != 0 && left<right && left!=0){
        ans+=nums[left];
        left++;
    }
    //middle part 
    while(left+sqrt<=right){
        //take the total block
        ans+=blocks[left/sqrt];
        left+=sqrt;
    }
    //right part
    while(left<=right){
        ans += nums[left];
        left++;
    }
    return ans;
   }
   // Query to get multiplication between two index
   public static int queryForMultiplication(int[] blocks,int[] nums,int left,int right,int sqrt){
    int ans=1;
    //left part
    while(left%sqrt !=0 && left<right && left!=0){
        ans*=nums[left];
        left++;
    }
    //middle part
    while(left+sqrt<=right){
        ans*=blocks[left/sqrt];
        left+=sqrt;
    }
    //right part
    while(left<=right){
        ans*=nums[left];
        left++;
    }
    return ans;
   }
   //update the array using this algorithm
   public static void update(int[] blocks,int[] nums,int index,int val,int sqrt){
    //get the block_id means in which block in the blocks array the index is present
     int block_id=index / sqrt;
     //update the value in blocks array
     blocks[block_id] += (val-nums[index]);
     //update the value in nums array
     nums[index]=val;
   }


}
