import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        toString(array);
    }
    //把数组转换成字符串
    public static void toString(int[] array) {
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            System.out.println("[ ]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
            if (i == array.length-1) {
                System.out.println("]");
            }
        }
    }

    public static void main4(String[] args) {
        int[] arrary = {1,2,3,4,5};
        System.out.println(Arrays.toString(copy(arrary)));
    }
    //拷贝数组，得到新的数组
    public static int[] copy(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(binArraySearch(array,3));
    }
    //二分查找
    public static int binArraySearch(int[] array,int n) {
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (array[mid] < n) {
                left = mid + 1;
            }else if (array[mid] > n) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,5,4};
        System.out.println(judgeSort(array));
    }
    //判断是否有序
    public static boolean judgeSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        int[] array = {1,3,5,4,2};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    //冒泡排序
    public static void bubbleSort(int[] array) {
        boolean flg = false;//默认不交换
        for (int i = array.length-1; i >= 0 ; i--) {
            flg = false;//每一次都有可能不交换
            for (int j = 0; j < i; j++) {
                if (array[j+1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;//交换
                }
            }
            if (flg = false) {//不交换了
                break;
            }
        }
    }
}
