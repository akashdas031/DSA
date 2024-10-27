 package DSA.Trees;


import java.util.function.Predicate;
import java.util.*;

public class DecisionTree {
    private class Feature {
        String name;
        Predicate<Integer> condition;

        Feature(String name, Predicate<Integer> condition) {
            this.name = name;
            this.condition = condition;
        }
    }

    private class TreeNode {
        Feature feature;
        TreeNode left;
        TreeNode right;
        String label;

        TreeNode(Feature feature) {
            this.feature = feature;
        }

        TreeNode(String label) {
            this.label = label;
        }

        boolean isLeaf() {
            return label != null;
        }
    }

    TreeNode root;

    public DecisionTree() {
        root = null;
    }

    public void train(List<DataPoint> dataPoints) {
        if (dataPoints.isEmpty()) {
            System.out.println("No Data for Training...");
            return;
        }
        List<Feature> features = extractFeatures();
        root = buildTree(dataPoints, features);
    }

    private List<Feature> extractFeatures() {
        List<Feature> features = new ArrayList<>();
        features.add(new Feature("Zero", num -> num == 0));
        features.add(new Feature("Positive", num -> num > 0));
        features.add(new Feature("Negative", num -> num < 0));
        features.add(new Feature("Even", num -> num % 2 == 0));
        features.add(new Feature("Odd", num -> num % 2 != 0));
        features.add(new Feature("Prime", this::isPrime));
        features.add(new Feature("Composite", num -> num > 1 && !isPrime(num)));
        
        return features;
    }

    private TreeNode buildTree(List<DataPoint> dataPoints, List<Feature> features) {
        if (dataPoints.isEmpty()) {
            return null; // Handle empty data points
        }
        if (allSameLabels(dataPoints)) {
            return new TreeNode(dataPoints.get(0).label);
        }
        if (features.isEmpty()) { // Check for empty features
            return new TreeNode("Unknown");
        }

        Feature feature = features.get(0);
        TreeNode node = new TreeNode(feature);
        List<DataPoint> leftDataPoints = new ArrayList<>();
        List<DataPoint> rightDataPoints = new ArrayList<>();

        for (DataPoint point : dataPoints) {
            if (feature.condition.test(point.value)) {
                leftDataPoints.add(point);
            } else {
                rightDataPoints.add(point);
            }
        }

        node.left = buildTree(leftDataPoints, features.subList(1, features.size()));
        node.right = buildTree(rightDataPoints, features.subList(1, features.size()));
        
        return node;
    }

    public String classify(int number) {
        return classifyRecursive(root, number);
    }

    private String classifyRecursive(TreeNode node, int number) {
        if (node == null) {
            return "Unknown"; // Handle null node
        }
        if (node.isLeaf()) {
            return node.label;
        }
        if (node.feature.condition.test(number)) {
            return classifyRecursive(node.left, number);
        } else {
            return classifyRecursive(node.right, number);
        }
    }

    private boolean allSameLabels(List<DataPoint> dataPoints) {
        String label = dataPoints.get(0).label;
        for (DataPoint point : dataPoints) {
            if (!point.label.equals(label)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // Check divisibility up to sqrt(num)
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
