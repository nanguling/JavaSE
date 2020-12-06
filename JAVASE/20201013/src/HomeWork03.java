import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork03 {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,4,2,5,3};
        arrNum(arr);
    }
    //找出数组中的数字：只出现一次，其他都出现两次，找出这个数字
	 public static int num(int [] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret = ret ^ arr[i];
        }
        return ret;
    }
    /*public static void arrNum(int[] arr) {
        int count;//计数器
        for (int i = 0;i < arr.length;i++) {//从第一位开始依次比较
            count = 0;//初始化计数器，确保每次嵌套for循环之后count初始化
            for (int j = 0;j < arr.length;j++) {//第i位和每一位比较
                if (arr[i] == arr[j]) {
                    count ++;//如果有相等的则计数器加1
                }
            }
            if (count == 1) {//只有当这个数字只出现一次时，计数器等于1，因为和这个数字相等的数只有它本身
                System.out.println(arr[i]);
                break;//提高程序效率
            }
        }
    }*/


    public static void main4(String[] args) {
        int[] arr = {1,3,8,6,9,4};
        arrSort(arr);
    }
    //调整数组顺序方法：使得奇数位位于偶数位之前
    public static void arrSort(int[] arr) {
        int i = 0;//作为一个指针从数组第一位开始
        int j = arr.length-1;//作为一个指针从数组最后一位开始
        while (i < j) {
            if (arr[i] % 2 ==1) {//判断当前位是否为奇数，如果是则不做改变，继续i++检查下一位
                i++;
            }else if (arr[j] % 2 == 0) {//判断当前位是否为偶数，如果是则不做改变，继续j--检查前一位
                j--;
            }else {//如果第i位不是奇数或者第j位不是偶数，则交换两位上的值
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }//检查完毕跳出while循环
        }
        String newArr = Arrays.toString(arr);//把数组转换成字符串类型
        System.out.println(newArr);//打印转换后的字符串
    }


    public static void main3(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数:");
        int n = sc.nextInt();
        System.out.println("第" + n + "项的斐波那契数为：" + fib(n));
    }
    //求斐波那契数列方法
	/*public static int fib(int n) {
		int fib1 = 1;
		int fib2 = 1;
		int fib3 = 1;
		for(int i = 3;i <= n;i++){
			fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
		}
		return fib3;
	}*/
    public static int fib(int n) {
        int i = 1;//起始项为1
        if (n < 3) {
            return i;//前两项都为1
        }
        //从第3项开始等于前两项i之和，直接递归求得前两项i的值即为这一项i的值
        i = fib(n-1) + fib(n-2);
        return i;
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("最大数是：" + threeNumber(a,b,c));
    }
    //求两个数中最大数的方法
    public static int twoNumber(int a,int b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    //求三个数中最大数的方法
    public static int threeNumber(int a,int b,int c) {
        int tmp1 = twoNumber(a,b);
        int tmp2 = twoNumber(tmp1,c);
        return tmp2;
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        System.out.println("这个数的阶乘为：" + fac(n));
        System.out.println("从一到这个数的阶乘和为：" + facSum(n));
    }
    //求一个数的阶乘
    public static int fac(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
    //求阶乘和
    public static int facSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }
}
