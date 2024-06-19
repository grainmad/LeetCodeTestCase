package com.six0.lctc.annotations;



import com.six0.lctc.constant.DataType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(LeetCodeTestCases.class)
public @interface LeetCodeTestCase {
    DataType[] type();
    String[] data();
    DataType answerType();
    String answer() default "null";
}
