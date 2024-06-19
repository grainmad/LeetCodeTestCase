package com.six0.lctc.aspect;


import com.six0.lctc.annotations.LeetCodeTestCase;
import com.six0.lctc.annotations.LeetCodeTestCases;
import com.six0.lctc.constant.DataType;
import com.six0.lctc.parser.LeetCodeParser;
import com.six0.lctc.utils.ArrayList2dUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义切面，实现题目参数注入
 */

@Aspect
@Component
public class VerdictAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.six0.lctc.problem.*.*(..))")
    public void autoFillPointCut(){}

    /**
     * 前置通知，在通知中进行公共字段的赋值
     */
    @Around("autoFillPointCut()")
    public Object logAroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("::::: " + signature.getMethod().getName()+" :::::");
        LeetCodeTestCase lctc = signature.getMethod().getAnnotation(LeetCodeTestCase.class);
        LeetCodeTestCases lctcs = signature.getMethod().getAnnotation(LeetCodeTestCases.class);
//        System.out.println(lctc);
//        System.out.println(lctcs);
        if (lctc != null) { // single test case
            Object answer = assignParam(lctc, args);
            Object result = joinPoint.proceed(args);
            cmp(answer, result, lctc);
            return result;
        } else if (lctcs != null) { // multi test case
            Object result = null;
            for (LeetCodeTestCase i:lctcs.value()) {

                Object answer = assignParam(i, args);
                result = joinPoint.proceed(args);
                cmp(answer, result, i);
            }
            return result;
        }

        return null;
    }
    Object assignParam(LeetCodeTestCase lctc, Object[] args) throws Exception {
        int sz = args.length;
        String[] data = lctc.data();
        DataType[] type = lctc.type();
        if (data.length != sz || sz != type.length) throw new Exception("test case config error");
        for (int i=0; i<sz; i++) {
//            System.out.println(type[i].name());
            Method method = LeetCodeParser.class.getMethod("get" + type[i].name(), String.class);
            Object invoke = method.invoke(null, data[i]);
            args[i] = invoke;
        }
        if (lctc.answer().equals("null")) return null;
        // answer
        return LeetCodeParser.class.getMethod("get" + lctc.answerType(), String.class).invoke(null, lctc.answer());

    }

    Object noArray(Object o, DataType ansType) {
        if (o == null) return null;
        switch (ansType) {
            case Int: return (Integer) o;
            case Double: return (Double) o;
            case Char: return (Character) o;
            case String: return (String) o;
            case IntArray: return ArrayList2dUtil.arrayToList(ArrayList2dUtil.wrapIntArray((int[])o));
            case DoubleArray: return ArrayList2dUtil.arrayToList(ArrayList2dUtil.wrapDoubleArray((double[])o));
            case CharArray: return ArrayList2dUtil.arrayToList(ArrayList2dUtil.wrapCharArray((char[])o));
            case StringArray: return ArrayList2dUtil.arrayToList((String[]) o);
            case IntArray2D: return ArrayList2dUtil.array2dTolist2D(ArrayList2dUtil.wrapIntArray((int[][]) o));
            case DoubleArray2D: return ArrayList2dUtil.array2dTolist2D(ArrayList2dUtil.wrapDoubleArray((double[][]) o));
            case CharArray2D: return ArrayList2dUtil.array2dTolist2D(ArrayList2dUtil.wrapCharArray((char[][]) o));
            case StringArray2D: return ArrayList2dUtil.array2dTolist2D((String[][]) o);
            case IntList:
            case DoubleList:
            case CharList:
            case StringList:
            case IntList2D:
            case DoubleList2D:
            case CharList2D:
            case StringList2D:
            case ListNode:
            case TreeNode: return o;
            case Null: return null;
        }
        return null;
    }
    boolean cmp(Object answer, Object result, LeetCodeTestCase lctc) {
        Object real = noArray(answer, lctc.answerType());
        Object your = noArray(result, lctc.answerType());
        System.out.println("Your Answer:\n"+your);
        System.out.println("Real Answer:\n"+real);
        System.out.println("Verdict:");
        if (your == null && real != null || your != null && real == null) {
            System.out.println("Wrong Answer\n");
            return false;
        } else {
            System.out.println((your == real || your.equals(real)) ?"Accepted\n":"Wrong Answer\n");
            return (your == real || your.equals(real));
        }
    }
}
