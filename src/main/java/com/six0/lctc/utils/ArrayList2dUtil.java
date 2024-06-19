package com.six0.lctc.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList2dUtil {


    public static <T> List<T> arrayToList(T[] a) {
        ArrayList<T> rt = new ArrayList<>();
        Collections.addAll(rt, a);
        return rt;
    }

    public static <T> T[] listToArray(List<T> a) {
        return (T[]) a.toArray();
    }

    public static <T> List<List<T>> array2dTolist2D(T[][] a) {
        List<List<T>> rt = new ArrayList<>();
        for (T[] i:a) {
            rt.add(arrayToList(i));
        }
        return rt;
    }

    public static <T> T[][] list2dToArray2d(List<List<T>> list, Class<T> clazz) {
        // 创建二维数组
        T[][] array = (T[][]) Array.newInstance(clazz, list.size(), 0);

        // 遍历列表并转换为数组
        for (int i = 0; i < list.size(); i++) {
            List<T> innerList = list.get(i);
            array[i] = innerList.toArray((T[]) Array.newInstance(clazz, innerList.size()));
        }
        return array;
    }

    // 将 int[] 包装为 Integer[]
    public static Integer[] wrapIntArray(int[] array) {
        Integer[] wrappedArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Integer[] 解包为 int[]
    public static int[] unwrapIntArray(Integer[] array) {
        int[] unwrappedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 char[] 包装为 Character[]
    public static Character[] wrapCharArray(char[] array) {
        Character[] wrappedArray = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Character[] 解包为 char[]
    public static char[] unwrapCharArray(Character[] array) {
        char[] unwrappedArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 double[] 包装为 Double[]
    public static Double[] wrapDoubleArray(double[] array) {
        Double[] wrappedArray = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Double[] 解包为 double[]
    public static double[] unwrapDoubleArray(Double[] array) {
        double[] unwrappedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 float[] 包装为 Float[]
    public static Float[] wrapFloatArray(float[] array) {
        Float[] wrappedArray = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Float[] 解包为 float[]
    public static float[] unwrapFloatArray(Float[] array) {
        float[] unwrappedArray = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 long[] 包装为 Long[]
    public static Long[] wrapLongArray(long[] array) {
        Long[] wrappedArray = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Long[] 解包为 long[]
    public static long[] unwrapLongArray(Long[] array) {
        long[] unwrappedArray = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 boolean[] 包装为 Boolean[]
    public static Boolean[] wrapBooleanArray(boolean[] array) {
        Boolean[] wrappedArray = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Boolean[] 解包为 boolean[]
    public static boolean[] unwrapBooleanArray(Boolean[] array) {
        boolean[] unwrappedArray = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 byte[] 包装为 Byte[]
    public static Byte[] wrapByteArray(byte[] array) {
        Byte[] wrappedArray = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Byte[] 解包为 byte[]
    public static byte[] unwrapByteArray(Byte[] array) {
        byte[] unwrappedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }

    // 将 short[] 包装为 Short[]
    public static Short[] wrapShortArray(short[] array) {
        Short[] wrappedArray = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = array[i];
        }
        return wrappedArray;
    }

    // 将 Short[] 解包为 short[]
    public static short[] unwrapShortArray(Short[] array) {
        short[] unwrappedArray = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = array[i];
        }
        return unwrappedArray;
    }


    // 将 int[][] 包装为 Integer[][]
    public static Integer[][] wrapIntArray(int[][] array) {
        Integer[][] wrappedArray = new Integer[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Integer[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Integer[][] 解包为 int[][]
    public static int[][] unwrapIntArray(Integer[][] array) {
        int[][] unwrappedArray = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 char[][] 包装为 Character[][]
    public static Character[][] wrapCharArray(char[][] array) {
        Character[][] wrappedArray = new Character[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Character[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Character[][] 解包为 char[][]
    public static char[][] unwrapCharArray(Character[][] array) {
        char[][] unwrappedArray = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new char[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 double[][] 包装为 Double[][]
    public static Double[][] wrapDoubleArray(double[][] array) {
        Double[][] wrappedArray = new Double[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Double[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Double[][] 解包为 double[][]
    public static double[][] unwrapDoubleArray(Double[][] array) {
        double[][] unwrappedArray = new double[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new double[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 float[][] 包装为 Float[][]
    public static Float[][] wrapFloatArray(float[][] array) {
        Float[][] wrappedArray = new Float[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Float[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Float[][] 解包为 float[][]
    public static float[][] unwrapFloatArray(Float[][] array) {
        float[][] unwrappedArray = new float[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new float[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 long[][] 包装为 Long[][]
    public static Long[][] wrapLongArray(long[][] array) {
        Long[][] wrappedArray = new Long[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Long[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Long[][] 解包为 long[][]
    public static long[][] unwrapLongArray(Long[][] array) {
        long[][] unwrappedArray = new long[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new long[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 boolean[][] 包装为 Boolean[][]
    public static Boolean[][] wrapBooleanArray(boolean[][] array) {
        Boolean[][] wrappedArray = new Boolean[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Boolean[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Boolean[][] 解包为 boolean[][]
    public static boolean[][] unwrapBooleanArray(Boolean[][] array) {
        boolean[][] unwrappedArray = new boolean[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new boolean[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }
    // 将 byte[][] 包装为 Byte[][]
    public static Byte[][] wrapByteArray(byte[][] array) {
        Byte[][] wrappedArray = new Byte[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Byte[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Byte[][] 解包为 byte[][]
    public static byte[][] unwrapByteArray(Byte[][] array) {
        byte[][] unwrappedArray = new byte[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new byte[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }

    // 将 short[][] 包装为 Short[][]
    public static Short[][] wrapShortArray(short[][] array) {
        Short[][] wrappedArray = new Short[array.length][];
        for (int i = 0; i < array.length; i++) {
            wrappedArray[i] = new Short[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                wrappedArray[i][j] = array[i][j];
            }
        }
        return wrappedArray;
    }

    // 将 Short[][] 解包为 short[][]
    public static short[][] unwrapShortArray(Short[][] array) {
        short[][] unwrappedArray = new short[array.length][];
        for (int i = 0; i < array.length; i++) {
            unwrappedArray[i] = new short[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                unwrappedArray[i][j] = array[i][j];
            }
        }
        return unwrappedArray;
    }
}
