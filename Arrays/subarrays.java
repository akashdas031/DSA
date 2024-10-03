package DSA.Arrays;
import java.util.ArrayList;
import java.util.List;
public class subarrays {
    public static List<List<Integer>> getSubarray(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> helper=new ArrayList<>();
            for(int j=0;j<i;j++){
                helper.add(nums[j]);
            }
            res.add(helper);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(getSubarray(nums));
    }
}
