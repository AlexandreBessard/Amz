package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        TreeNode right, left;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    //Deserialize
    public TreeNode deserialize(String str) {
        String[] data = str.split(",");
        List<String> l = new LinkedList<>(Arrays.asList(data));
        return rdeserialize(l);
    }

    private TreeNode rdeserialize(List<String> l) {
        if(l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        node.left = rdeserialize(l);
        node.right = rdeserialize(l);
        return node;

    }

    //Serialize
    public String serialize(TreeNode node) {
        return rserialize(node, "");
    }

    private String rserialize(TreeNode node, String str) {
        if(node == null) {
            str += "null,";
            return str;
        }
        str += node.val + ",";
        str = rserialize(node.left, str);
        str = rserialize(node.right, str);
        return str;
    }

}
