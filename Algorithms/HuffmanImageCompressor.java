package DSA.Algorithms;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import DSA.CustomDataStructures.MinHeap;

public class HuffmanImageCompressor {
    HashMap<Byte, String> encoder;
    HashMap<String, Byte> decoder;

    private class Node implements Comparable<Node> {
        Byte data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Byte data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanImageCompressor(byte[] feeder) throws Exception {
        HashMap<Byte, Integer> fmap = new HashMap<>();

        for (byte b : feeder) {
            fmap.put(b, fmap.getOrDefault(b, 0) + 1);
        }

        MinHeap<Node> minHeap = new MinHeap<>();
        for (Map.Entry<Byte, Integer> entry : fmap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node((byte) 0, first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft, "");
    }

    private void initEncoderDecoder(Node node, String osf) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }
        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    public String encode(byte[] source) {
        StringBuilder ans = new StringBuilder();
        for (byte b : source) {
            ans.append(encoder.get(b));
        }
        return ans.toString();
    }

    public byte[] decode(String codedString) {
        String key = "";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < codedString.length(); i++) {
            key += codedString.charAt(i);
            if (decoder.containsKey(key)) {
                baos.write(decoder.get(key));
                key = "";
            }
        }
        return baos.toByteArray();
    }
}

