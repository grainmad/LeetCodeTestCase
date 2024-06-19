# LeetCodeTestCase

通过AOP获取方法上注解中的测试数据，利用反射将方法的参数替换为测试数据。

`@LeetCodeTestCase`参数
* type 方法的各个参数类型，与参数顺序一致 
* data 测试用例字符串，根据参数类型进行解析
* answerType 返回值参数类型 
* answer 非必须，提供则与返回值进行对比

``` java
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
```

```text
::::: buildTree :::::
Your Answer:
│       ┌── 7
│   ┌── 20
│   │   └── 15
└── 3
    └── 9

Real Answer:
│       ┌── 7
│   ┌── 20
│   │   └── 15
└── 3
    └── 9

Verdict:
Accepted

```
