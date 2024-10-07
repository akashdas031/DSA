package DSA.leetCode;

import java.util.*;

/**
 * The {@code equalRowColumnPairs} class contains a main method that demonstrates 
 * the process of counting equal row-column pairs in a given 2D grid.
 * This program constructs a list of column representations as strings and compares 
 * them to the string representations of each row to count how many matches occur.
 */
class equalRowColumnPairs {
    
    /**
     * The main method where the execution starts.
     * It initializes a 2D integer array (grid) and counts the number of equal row-column pairs.
     * It constructs string representations of both the rows and columns of the grid,
     * then compares these representations to count the matches.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[][] grid = {
            {3, 1, 2, 2},
            {1, 4, 4, 4},
            {2, 4, 2, 2},
            {2, 5, 2, 2}
        };

        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid

        // List to store string representations of columns
        List<String> singleArray = new ArrayList<String>();

        // Construct string representations for each column
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append(",");
            }
            singleArray.add(sb.toString());
        }

        int count = 0; // Counter for equal row-column pairs

        // Compare each row's string representation with the column representations
        for (int[] nums : grid) {
            StringBuilder sbs = new StringBuilder();
            for (int nn : nums) {
                sbs.append(nn).append(",");
            }
            for (String s : singleArray) {
                if (sbs.toString().equals(s)) {
                    count++;
                }
            }
        }

        // Output the count of equal row-column pairs
        System.out.println(count);
    }
}
