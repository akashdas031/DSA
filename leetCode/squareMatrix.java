package DSA.leetCode;

public class squareMatrix {
    public static int slideWindow(int[][] matrix, int windowSize) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if window size is valid
        if (windowSize <= 0 || windowSize > rows || windowSize > cols) {
            System.out.println("Invalid window size.");
            return -1;
        }
        int count=0;
        // Slide the window over the matrix
        for (int i = 0; i <= rows - windowSize; i++) {
            for (int j = 0; j <= cols - windowSize; j++) {
               int co=printWindow(matrix, i, j, windowSize);
               if(windowSize*windowSize==co){
                count+=co;
            }
            }
        }
        System.out.println("Count In slide method"+count);
        return count;
    }

    public static int printWindow(int[][] matrix, int startRow, int startCol, int windowSize) {
        System.out.println("Window starting at (" + startRow + ", " + startCol + "):");
        int count=0;
        for (int i = 0; i < windowSize; i++) {
            int tmp=0;
            for (int j = 0; j < windowSize; j++) {
                System.out.print(matrix[startRow + i][startCol + j]+" ");
                if(matrix[startRow + i][startCol + j]==1){
                    tmp++;
                }
            }
            if(tmp==windowSize){
                count+=1;
            }
            System.out.println();
        }
        System.out.println();
         System.out.println(count+"Count");
        return count;
    }
   public static void main(String[] args) {
        int [][]matrix={
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
            
        };
        int count=0;
        for(int i=1;i<=matrix.length;i++){
            int co=slideWindow(matrix,i);  
            
        }
        System.out.println(count);
    }
}
