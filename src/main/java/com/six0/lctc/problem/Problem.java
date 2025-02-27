package com.six0.lctc.problem;


import com.six0.lctc.annotations.LeetCodeTestCase;
import com.six0.lctc.constant.DataType;
import com.six0.lctc.dataNode.ListNode;
import com.six0.lctc.dataNode.TreeNode;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Problem {

    // 1. 两数之和
    @LeetCodeTestCase(
            type = {DataType.IntArray, DataType.Int},
            data = {"[2,7,11,15]", "9"},
            answerType = DataType.IntArray,
            answer = "[0,1]"
    )
    @LeetCodeTestCase(
            type = {DataType.IntArray, DataType.Int},
            data = {"[3,2,4]", "6"},
            answerType = DataType.IntArray,
            answer = "[1 , 2]"
    )
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (mp.containsKey(target-nums[i])) {
                return new int[]{mp.get(target-nums[i]), i};
            }
            mp.put(nums[i], i);
        }
        return null;
    }

    // 103. 二叉树的锯齿形层序遍历
    @LeetCodeTestCase(
            type = DataType.TreeNode,
            data = "[3,9,20,null,null,15,7]",
            answerType = DataType.IntList2D,
            answer = "[[3],[20,9],[15,7]]"
    )
    @LeetCodeTestCase(
            type = DataType.TreeNode,
            data = "[1]",
            answerType = DataType.IntList2D,
            answer = "[[1]]"
    )
    @LeetCodeTestCase(
            type = DataType.TreeNode,
            data = "[]",
            answerType = DataType.IntList2D,
            answer = "[]"
    )
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        System.out.println(root);
        List<List<Integer>> rt = new ArrayList<>();
        if (root == null) return rt;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int stp = 0;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int sz = q.size();
            for (int i=0; i<sz; i++) {
                TreeNode node = q.remove();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (stp%2 == 1) {
                Collections.reverse(list);
            }
            rt.add(list);
            stp++;
        }
        System.out.println(rt);
        return rt;
    }

    // 105. 从前序与中序遍历序列构造二叉树
    @LeetCodeTestCase(
            type = {DataType.IntArray, DataType.IntArray},
            data = {"[3,9,20,15,7]", "[9,3,15,20,7]"},
            answerType = DataType.TreeNode,
            answer = "[3,9,20,null,null,15,7]"

    )
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        HashMap<Integer,Integer> pos = new HashMap<>();
        for (int i=0; i<n; i++) {
            pos.put(inorder[i], i);
        }

        ForFunction<ForFunction, Integer, Integer, Integer, TreeNode> dfs = (self, l1, l2, len) -> {
            if (len<=0) return null;
            int sp = pos.get(preorder[l1]);
            int left = sp-l2;
            return new TreeNode(
                    preorder[l1],
                    (TreeNode) self.apply(self, l1+1, l2, left),
                    (TreeNode) self.apply(self, l1+left+1, sp+1, len-left-1)
            );
        };
        return dfs.apply(dfs, 0, 0, n);
    }
    @FunctionalInterface
    interface ForFunction<A, B, C, D, R> {
        R apply(A a, B b, C c, D d);
    }

    // 21. 合并两个有序链表
    @LeetCodeTestCase(
            data = {"[1,2,4]", "[1,3,4]"},
            type = {DataType.ListNode, DataType.ListNode},
            answerType = DataType.ListNode
    )
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = list2;
            list2 = list1.next;
            cur = cur.next;
        }
        return head.next;
    }

}
