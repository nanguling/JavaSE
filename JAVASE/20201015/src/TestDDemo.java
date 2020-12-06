import java.util.Arrays;

public class TestDDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] arr = {};
        int[] arr1 = null;
        toString(array);
        toString(arr);
        toString(arr1);
    }
    //打印数组方法
    public static void toString(int[] array) {
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            System.out.println("[]");
        }
        String s = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print(s + array[i] + ",");
            }else if (i != array.length-1) {
                System.out.print(array[i] + ",");
            }else {
                System.out.println(array[i] +"]");
            }
        }
    }

    public static void main8(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = func2(array);
        System.out.println(Arrays.toString(ret));
    }
    //不经过拷贝
    public static int[] func(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        return array;
    }
    public static int[] func2(int[] array) {
        int[] tmp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        //tmp当中存放拷贝后的数据
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] *= 2;
        }
        return tmp;
    }

    public static void main7(String[] args) {
        int a = 0;
        int[] array = null;//代表不指向任何对象
        //静态初始化，定义的同时要进行初始化
        array = new int[] {1,2,3,4,5};
        System.out.println(array.length);//NullPointerException空指针异常
    }

    public static void main6(String[] args) {
        int[] arr = new int[5];//5个零
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main5(String[] args) {
        int[] arr = {1,2,3,4,5};
        //当前x里面保存的就是数字当中的每个元素
        //for和foreach区别：for可以知道每个元素的下标
        for (int x:arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    public static void main4(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = new int[]{1,2,3,4};
        int[] arr3 = new int[5];
    }

    public static void main3(String[] args) {
        int n = 5;
        System.out.println(floor(n));
    }
    public static int floor(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;

    }

    public static void main2(String[] args) {
        int n = 132;
        sumNum(n);
    }
    public static void sumNum(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        sumNum(n/10);
        System.out.println(n%10);
    }

}
