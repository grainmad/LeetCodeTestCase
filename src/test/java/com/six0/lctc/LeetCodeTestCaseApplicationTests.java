package com.six0.lctc;

import com.six0.lctc.problem.Problem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetCodeTestCaseApplicationTests {
    @Autowired
    Problem problem;

    @Test
    public void test1() {
        problem.zigzagLevelOrder(null);
    }

    @Test
    public void test2() {
        problem.buildTree(null,null);
    }
    @Test
    public void test3() {
        problem.mergeTwoLists(null,null);
    }

}
