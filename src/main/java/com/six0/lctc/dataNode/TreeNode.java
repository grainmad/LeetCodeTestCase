package com.six0.lctc.dataNode;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        prettyPrintTree(sb, this, "", true);
        return sb.toString();
    }
    void prettyPrintTree(StringBuilder sb, TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            sb.append("Empty tree");
            return;
        }

        if(node.right != null) {
            prettyPrintTree(sb, node.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        sb.append(prefix + (isLeft ? "└── " : "┌── ") + Integer.toString(node.val) + "\n");

        if (node.left != null) {
            prettyPrintTree(sb, node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}