package DSA.DataTypeIdentifier;

import java.util.function.Predicate;
import java.util.*;

public class DataTypeDecisionTree {
    private class Feature {
        String name;
        Predicate<Object> condition;

        Feature(String name, Predicate<Object> condition) {
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

    public DataTypeDecisionTree() {
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
        features.add(new Feature("Is Null", value -> value == null));
        features.add(new Feature("Is Boolean", value -> value instanceof Boolean));
        features.add(new Feature("Is Character", value -> value instanceof Character));
        features.add(new Feature("Is Integer", value -> value instanceof Integer));
        features.add(new Feature("Is Long", value -> value instanceof Long));
        features.add(new Feature("Is Float", value -> value instanceof Float));
        features.add(new Feature("Is Double", value -> value instanceof Double));
        features.add(new Feature("Is String", value -> value instanceof String));
        return features;
    }

    private TreeNode buildTree(List<DataPoint> dataPoints, List<Feature> features) {
        if (dataPoints.isEmpty()) {
            return null;
        }
        if (allSameLabels(dataPoints)) {
            return new TreeNode(dataPoints.get(0).label);
        }
        if (features.isEmpty()) {
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

    public String classify(Object value) {
        return classifyRecursive(root, value);
    }

    private String classifyRecursive(TreeNode node, Object value) {
        if (node == null) {
            return "Unknown";
        }
        if (node.isLeaf()) {
            return node.label;
        }
        if (node.feature.condition.test(value)) {
            return classifyRecursive(node.left, value);
        } else {
            return classifyRecursive(node.right, value);
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
}
