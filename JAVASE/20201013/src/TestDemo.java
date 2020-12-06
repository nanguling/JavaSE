import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a + " " + b);
        swap(a,b);
        System.out.println(a + " " + b);//10,20实参给形参传值是按值传递，形参的改变不影响实参
    }

    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = sc.nextInt();
        System.out.println(facSum(num));
    }

    //求一个数的阶乘
    public static int fac(int a) {
        int i = 1;
        int num = 1;
        while (i <= a) {
            num *= i;
            i++;
        }
        return num;
    }
    //求阶乘的和
    public static int facSum(int a) {
        int sum = 0;
        for (int i = 1;i <= a;i ++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        int num = maxTwoNumber(a,b);
        System.out.println(num);
        System.out.println(maxThreeNumber(10,20,30));
    }

    public static int maxTwoNumber(int a,int b) {
        if (a > b) {
            //System.out.println(a);
            return a;
        } else {
            return b;
        }
    }

    public static int maxThreeNumber(int a,int b,int c) {
        int max1 = maxTwoNumber(a , b);
        int max2 = maxTwoNumber(max1 , c);
        return max2;
    }

}
