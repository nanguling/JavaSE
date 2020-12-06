import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        System.out.println(array[1][0]);
        //int[][] arr = new int[][]{{1,2},{3,4}};
        //打印二维数组的每一位
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5};
        sortOdd(array);
        System.out.println(Arrays.toString(array));
    }
    //偶数和奇数位置兑换
    public static void sortOdd(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                left ++;
            }
            while (left < right && array[right] % 2 != 0) {
                right --;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5};
        noSort(array);
        System.out.println(Arrays.toString(array));
    }
    //逆序排列
    public static void noSort(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left ++;
            right --;
        }
    }

    public static void main5(String[] args) {
        int[] array = {1,3,5,4,2};
        /*int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long startTime = System.currentTimeMillis();
        sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);*/
        System.out.println(Arrays.toString((array)));
    }
    //冒泡排序
    public static void sort(int[] array) {
        //boolean flg = false;//默认不交换
        int count = 0;//计数器
        for (int i = array.length-1; i >= 0; i--) {
            //flg = false;
            count = 0;//每一次都有可能不发生排序，每次都要初始化
            for (int j = 0; j < i; j++) {
                if (array[j+1] < array[j]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    //flg = true;//发生交换
                    count ++;//发生交换则加1
                }
            }
            /*if (flg == false) {//没交换了
                break;
            }*/
            if (count == 0) {//没发生交换就跳出
                break;
            }
        }
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(numSort(array));
    }
    //检查数组有序性
    public static boolean numSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i+1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(binArraySearch(array,3));
    }
    //二分查找
    public static int binArraySearch(int[] array,int n) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (array[mid] < n) {
                right = mid+1;
            }else if (array[mid] > n) {
                left = mid-1;
            }else {
                return mid;
            }
        }
        return -1;//没找到
    }

    public static void main2(String[] args) {
        int[] array = {1,3,5,2,4};
        System.out.println(maxNum(array));
    }
    //找出数组当中最大的元素
    public static int maxNum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i+1];
            }
        }
        return max;
    }

    public static void main1(String[] args) {
        int[] arrary = {1,2,3,4,5};
        int[] copy = arrary.clone();
        System.out.println(Arrays.toString(arrary));
        System.out.println(Arrays.toString(copy(arrary)));
    }
    //拷贝数组
    public static int[] copy(int[] arrary) {
        int[] copy = Arrays.copyOf(arrary,arrary.length);

        /*int[] copy = new int[arrary.length];
        for (int i = 0; i < arrary.length; i++) {
            copy[i] = arrary[i];*/
        return copy;
    }
}
