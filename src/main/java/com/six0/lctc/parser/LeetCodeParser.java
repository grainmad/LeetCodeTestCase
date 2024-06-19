package com.six0.lctc.parser;


import com.six0.lctc.dataNode.ListNode;
import com.six0.lctc.dataNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCodeParser {
    public static Integer getInt(String s) throws Exception {
        s = s.trim();
        if (isNull(s)) return null;
        if (s.length() == 0) throw new Exception("illegal int");
        // 123
        return Integer.parseInt(s);
    }
    public static Double getDouble(String s) throws Exception {
        s = s.trim();
        if (isNull(s)) return null;
        if (s.length() == 0) throw new Exception("illegal double");
        // 3.14
        return Double.parseDouble(s);
    }
    public static Character getChar(String s) throws Exception {
        s = s.trim();
        if (isNull(s)) return null;
        if (s.length() < 2 || s.length() > 3 || s.charAt(0) != '\'' || s.charAt(s.length()-1) != '\'') throw new Exception("illegal char");
        if (s.length() == 2) return '\0';
        // 'a' 'b'
        return s.charAt(1);
    }
    public static String getString(String s){
        // "abc"
        s = s.trim();
//        if ("\"\"".equals(s)) return "";
        return s.substring(1, s.length()-1);
    }

    public static int[] getIntArray(String s) throws Exception {
        // [12,21, 33]
        // 使用流式操作将 List<Integer> 转换为 int[]
        return getIntList(s).stream().mapToInt(Integer::intValue).toArray();
    }
    public static double[] getDoubleArray(String s) throws Exception {
        return getDoubleList(s).stream().mapToDouble(Double::doubleValue).toArray();
    }
    public static char[] getCharArray(String s) throws Exception {
        return getCharList(s).stream()
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toCharArray();
    }
    public static String[] getStringArray(String s) throws Exception {
        return (String[]) getStringList(s).toArray();
    }
    public static int[][] getIntArray2D(String s) throws Exception {
        return getIntList2D(s)
                .stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
    public static double[][] getDoubleArray2D(String s) throws Exception {
        return getDoubleList2D(s)
                .stream()
                .map(list -> list.stream().mapToDouble(Double::doubleValue).toArray())
                .toArray(double[][]::new);
    }
    public static char[][] getCharArray2D(String s) throws Exception {
        return getCharList2D(s).stream()
                .map(list -> list.stream()
                        .map(c -> c.charValue())
                        .collect(Collectors.toList())
                        .stream()
                        .mapToInt(Character::charValue)
                        .toArray())
                .toArray(char[][]::new);
    }
    public static String[][] getStringArray2D(String s) throws Exception {
        return getStringList2D(s).stream()
                .map(list -> list.toArray(new String[0])) // 转换为 String[]
                .toArray(String[][]::new);
    }
    public static List<Integer> getIntList(String s) throws Exception {
        ArrayList<Integer> rt = new ArrayList<>();
        List<String> delimit = delimit(s);
//        System.out.println(delimit.size());
        for (String i: delimit) {
             rt.add(getInt(i));
        }
        return rt;
    }
    public static List<Double> getDoubleList(String s) throws Exception {
        ArrayList<Double> rt = new ArrayList<>();
        List<String> delimit = delimit(s);
        for (String i: delimit) {
            rt.add(getDouble(i));
        }
        return rt;
    }
    public static List<Character> getCharList(String s) throws Exception {
        ArrayList<Character> rt = new ArrayList<>();
        List<String> delimit = delimit(s);
        for (String i: delimit) {
            rt.add(getChar(i));
        }
        return rt;
    }
    public static List<String> getStringList(String s) throws Exception {
        ArrayList<String> rt = new ArrayList<>();
        List<String> delimit = delimit(s);
        for (String i: delimit) {
            rt.add(getString(i));
        }
        return rt;
    }
    public static List<List<Integer>> getIntList2D(String s) throws Exception {
        List<List<Integer>> rt = new ArrayList<>();
        List<List<String>> delimit = delimit2D(s);
        for (List<String> i: delimit) {
            List<Integer> t = new ArrayList<>();
            for (String j : i)
                t.add(getInt(j));
            rt.add(t);
        }
        return rt;
    }
    public static List<List<Double>> getDoubleList2D(String s) throws Exception {
        List<List<Double>> rt = new ArrayList<>();
        List<List<String>> delimit = delimit2D(s);
        for (List<String> i: delimit) {
            List<Double> t = new ArrayList<>();
            for (String j : i)
                t.add(getDouble(j));
            rt.add(t);
        }
        return rt;
    }
    public static List<List<Character>> getCharList2D(String s) throws Exception {
        List<List<Character>> rt = new ArrayList<>();
        List<List<String>> delimit = delimit2D(s);
        for (List<String> i: delimit) {
            List<Character> t = new ArrayList<>();
            for (String j : i)
                t.add(getChar(j));
            rt.add(t);
        }
        return rt;
    }
    public static List<List<String>> getStringList2D(String s) throws Exception {
        List<List<String>> rt = new ArrayList<>();
        List<List<String>> delimit = delimit2D(s);
        for (List<String> i: delimit) {
            List<String> t = new ArrayList<>();
            for (String j : i)
                t.add(getString(j));
            rt.add(t);
        }
        return rt;
    }
    public static void getNull(String s) throws Exception {
        if (!"null".equals(s.trim())) {
            throw new Exception("Not null");
        }
    }
    public static boolean isNull(String s) {
        return "null".equals(s.trim());
    }

    public static TreeNode getTreeNode(String s) throws Exception {
        List<Integer> intList = getIntList(s);
        if (intList.size() == 0) return null;
        ArrayList<TreeNode> nodelist = new ArrayList<>();
        int sz = intList.size();
        for (int i=0; i<sz; i++) {
            if (intList.get(i) == null) nodelist.add(null);
            else nodelist.add(new TreeNode(intList.get(i)));
        }
        for (int i=1; i<sz; i++) {
            TreeNode treeNode = nodelist.get(i);
            if (treeNode == null) continue;
            if (i%2 == 1) {
                nodelist.get((i-1)/2).left = treeNode;
            } else {
                nodelist.get((i-1)/2).right = treeNode;
            }
        }
//        System.out.println(nodelist);
        return nodelist.get(0);
    }
    public static ListNode getListNode(String s) throws Exception {
        List<Integer> intList = getIntList(s);
        if (intList.size() == 0) return null;
        ListNode root = new ListNode(intList.get(0));
        ListNode cur = root;
        for (int i=1; i< intList.size(); i++) {
            cur.next = new ListNode(intList.get(i));
            cur = cur.next;
        }
        return root;
    }
    // 字符串内有[",.", "','." ]
    private static List<String> delimit(String s) throws Exception {
        List<String> rt = new ArrayList<>();
        s = s.trim();
        if (s.length()<2 || s.charAt(0) != '[' || s.charAt(s.length()-1) != ']') throw new Exception("illegal array");
        int sz = s.length()-1;
        if ("".equals(s.substring(1, sz).trim())) return rt;
        int dqm = 0;
        int j = 1;
        for (int i=1; i<sz; i++) {
            char ch = s.charAt(i);
            if (ch == '"') dqm++;
            if (ch == ',' && dqm % 2 == 0) {
                rt.add(s.substring(j, i).trim());
                j = i + 1;
            }
        }
        rt.add(s.substring(j,sz).trim());
        return rt;
    }
    private static List<List<String>> delimit2D(String s) throws Exception {
        List<List<String>> rt = new ArrayList<>();
        s = s.trim();
        if (s.length()<2 || s.charAt(0) != '[' || s.charAt(s.length()-1) != ']') throw new Exception("illegal array");
        int sz = s.length()-1;
        if ("".equals(s.substring(1, sz).trim())) return rt;
        int dqm = 0;
        int sqrb = 0;
        int j = 1;
        for (int i=1; i<sz; i++) {
            char ch = s.charAt(i);
            if (ch == '"') dqm++;
            if (dqm %2 == 0) {
                if (ch == '[') sqrb++;
                if (ch == ']') sqrb--;
            }
            if (ch == ',' && dqm % 2 == 0 && sqrb == 0) {
                rt.add(delimit(s.substring(j, i)));
                j = i + 1;
            }
        }
        rt.add(delimit(s.substring(j,sz)));
        return rt;
    }
}
