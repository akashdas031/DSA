package DSA.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import DSA.CustomDataStructures.MinHeap;

/**
 * The {@code rankTransformationArray} class provides methods to transform an array into 
 * its rank representation. Each element in the resulting array is replaced by its rank 
 * based on the unique values present in the original array.
 */
public class rankTransformationArray {

    /**
     * Transforms the input array into its rank representation without using a priority queue.
     *
     * @param arr the input array of integers
     * @return an array of the same length where each element represents the rank of the corresponding 
     *         element in the input array
     */
    public int[] arrayRankTransformWithoutPQ(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for (int n : arr) {
            nums.add(n);
        }
        
        int[] ranks = new int[nums.size()];
        int ind = 0;
        for (int val : nums) {
            ranks[ind++] = val;
        }
        
        Arrays.sort(ranks);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            m.put(ranks[i], i + 1);
        }
        
        int[] res = new int[arr.length];
        int index = 0;
        for (int v : arr) {
            res[index++] = m.get(v);
        }
        
        return res;
    }

    /**
     * Transforms the input array into its rank representation using a minimum heap.
     *
     * @param arr the input array of integers
     * @return an array of the same length where each element represents the rank of the corresponding 
     *         element in the input array
     * @throws Exception if an error occurs during heap operations
     */
    public int[] arrayRankTransform(int[] arr) throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>();
        for (int num : arr) {
            minHeap.insert(num);
        }
        
        int[] res = new int[arr.length];
        Map<Integer, Integer> mp = new HashMap<>();
        int rank = 1;

        while (!minHeap.isEmpty()) {
            int min = minHeap.remove();
            if (!mp.containsKey(min)) {
                mp.put(min, rank);
                rank++;
            }
        }
        
        int index = 0;
        for (int n : arr) {
            if (mp.containsKey(n) && index < arr.length) {
                res[index] = mp.get(n);
                index++;
            }
        }
        
        return res;
    }
}
