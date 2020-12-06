import java.util.Arrays;
class Calculator {
    private int num1;
    private int num2;

    //无参构造方法
    public Calculator() {

    }
    //有参构造方法
    public Calculator(int num1,int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    //setter方法
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public void setNum2(int num1) {
        this.num2 = num2;
    }
    //四则运算
    public int sum() {
        return this.num1 + this.num2;
    }
    public int diff() {
        return this.num1 - this.num2;
    }
    public int product() {
        return this.num1 * this.num2;
    }
    public double quo() {
        return (double) this.num1 /this.num2;
    }
}
class Exchange {
    int num;
}


public class HomeWork {
    public static void swap(Exchange exc1,Exchange exc2) {
        int tmp = exc1.num;
        exc1.num = exc2.num;
        exc2.num = tmp;
    }

    public static void main(String[] args) {
        Exchange exc1 = new Exchange();
        Exchange exc2 = new Exchange();
        exc1.num = 1;
        exc2.num = 2;
        swap(exc1,exc2);
        System.out.println(exc1.num + " " + exc2.num);
    }

        public static void main3 (String[]args){
            Calculator c1 = new Calculator(10, 20);
            System.out.println(c1.sum());
            System.out.println(c1.diff());
            System.out.println(c1.product());
            System.out.println(c1.quo());
            Calculator c2 = new Calculator();
            c2.setNum1(20);
            c2.setNum2(10);
            System.out.println(c2.sum());
            System.out.println(c2.diff());
            System.out.println(c2.product());
            System.out.println(c2.quo());
        }

        public static void main2 (String[]args){
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {5, 6, 7, 8};
            swapNum(arr1, arr2);
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
        }
        //交换两个数组的元素
        public static void swapNum (int[] arr1, int[] arr2){
            for (int i = 0; i < arr1.length; i++) {
                int tmp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = tmp;
            }
        }

        public static void main1 (String[]args){
            int[] array = {1, 2, 3, 5, 6};
            sort(array);
            System.out.println(Arrays.toString(array));
        }
        //把数组中奇数放到偶数后面
        public static void sort ( int[] array){
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                while (left < right && array[left] % 2 == 0) {
                    left++;
                }
                while (left < right && array[right] % 2 != 0) {
                    right--;
                }
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
}
