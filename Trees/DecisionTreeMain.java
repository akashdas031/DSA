package DSA.Trees;
import java.util.*;

import DSA.Trees.DataPoint;
public class DecisionTreeMain {
    public static void main(String[] args) {
        DecisionTree dt = new DecisionTree();
        List<DataPoint> dataPoints = new ArrayList<>();
        
        // Add various data points
        dataPoints.add(new DataPoint(0, "Zero"));
        dataPoints.add(new DataPoint(2, "Even Prime"));
        dataPoints.add(new DataPoint(3, "Odd Prime"));
        dataPoints.add(new DataPoint(4, "Even Not Prime"));
        dataPoints.add(new DataPoint(5, "Odd Prime"));
        dataPoints.add(new DataPoint(6, "Even Not Prime"));
        dataPoints.add(new DataPoint(-3, "Negative Odd"));
        dataPoints.add(new DataPoint(-2, "Negative Even"));
        dataPoints.add(new DataPoint(9, "Odd Composite"));
        dataPoints.add(new DataPoint(10, "Even Composite"));
        dataPoints.add(new DataPoint(100000, "Even Composite"));

        dt.train(dataPoints);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to know its type:");
        int num = sc.nextInt();
        String res = dt.classify(num);
        System.out.println(res);
    }
}
