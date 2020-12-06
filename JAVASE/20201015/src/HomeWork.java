import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int n = 100;
        int[] arr = setUpNumbers(n);
        System.out.println(Arrays.toString(arr));
    }
    //创建一个数组，元素个数为，元素为n
    public static int[] setUpNumbers(int n) {
        int[] arrary = new int[n];
        for (int i = 0; i < n; i++) {
            arrary[i] = i + 1;
        }
        return arrary;
    }

    public static void main4(String[] args) {
        int[] arrary = {1,2,3,4,5};
        printArrary(arrary);
    }
    //循环打印数组每个元素的值
    public static void printArrary(int[] arrary) {
        for (int i = 0; i < arrary.length; i++) {
            System.out.print(arrary[i] + " ");
        }
    }

    public static void main3(String[] args) {
        int[] arrary = {1,2,3,4,5};
        //int[] arr1 = expandNumbers(arrary);
        int[] arr2 = expandNum(arrary);
        //System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    //数组所有元素扩大二倍
    //不改变原来的数组，返回一个新的数组
    public static int[] expandNum(int[] arrary) {
        int[] ret = new int[arrary.length];
        for (int i = 0; i < arrary.length; i++) {
            ret[i] = arrary[i];
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ret[i] * 2;
        }
        return ret;
    }
    //直接修改原来的数组
    public static int[] expandNumbers(int[] arrary) {
        for (int i = 0; i < arrary.length; i++) {
            arrary[i] = arrary[i] * 2;
        }
        return arrary;
    }

    public static void main2(String[] args) {
        int[] arrary = {1,2,3,4,5};
        System.out.println(numbersSum(arrary));
    }
    //求数组中所有元素之和
    public static int numbersSum(int[] array) {
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            ret = ret + array[i];
        }
        return ret;
    }

    public static void main1(String[] args) {
        int[] arrary = {1,2,3,4,5,6};
        System.out.println(average(arrary));
    }
    //求数组中所有元素的平均值
    public static double average (int[] arrary) {
        int ret = 0;
        for (int i = 0; i < arrary.length; i++) {
            ret = ret + arrary[i];
        }
        return (double) ret /(double) arrary.length;
    }
}
