import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(jump(n));
    }
    //青蛙跳台阶：可以随便跳
    //f(n)=2^n-1
    //第n项等于前一项的值乘以2
    public static int jump(int n) {
        if (n == 1) {
            return n;
        }
        return jump(n-1)*2;
    }

    public static void main9(String[] args) {
        int n = 6;
        System.out.println(jumpTimes(n));
    }
    //青蛙跳台阶方法：一次只能跳一级或者两级
    /*假设n个台阶的跳法一共有f(n)个，那么当第一次选择只跳一个台阶的时候，
        还剩下f(n-1)个跳法；当第一次选择跳两个台阶的时候，那么还剩下f(n-2)
        个跳法。由于青蛙只能一次跳一级或者两级台阶，所以f(n)=f(n-1)+f(n-2)
     */
    public static int jumpTimes(int n) {
        if (n < 2) {
            return n;
        }
        return jumpTimes(n-1) + jumpTimes(n-2);
    }

    public static void main8(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }
    //递归求n的阶乘
    public static int sum(int n) {
        if (n == 1) {
            return n;
        }
        return n*sum(n-1);
    }

    public static void main7(String[] args) {
        int n = 10;
        System.out.println(addSum(n));
    }
    //递归求连续n个整数的和的方法
    public static int addSum(int n) {
        if (n == 1) {
            return n;
        }
        return n + addSum(n-1);
    }

    public static void main6(String[] args) {
        int a = 132;
        print(a);
    }
    //顺序打印一个数的每一位
    public static void print(int n) {
        if (n < 9) {//打印第一位为递归终止条件
            System.out.println(n);
            return;//运行到这里”递“结束，开始”归“
        }
        //除以10得到下一位
        print(n/10);
        //打印输出这一位的数
        System.out.println(n%10);
    }

    public static void main5(String[] args) {
        int n = 123;
        System.out.println(sumAdd(n));
    }
    //返回一个组成非负整数的数字之和
    public static int sumAdd(int n) {
        if (n < 9) {
            return n;
        }
        return n%10 + sumAdd(n/10);
    }

    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = sc.nextInt();
        System.out.println("第" + n + "项的斐波那契数等于：" + fib(n));
    }
    //递归求斐波那契数的第n项
    public static int fib(int n) {
        if (n < 3) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main3(String[] args) {
        hanoiTower(1,'A','B','C');
        System.out.println();
        hanoiTower(2,'A','B','C');
        System.out.println();
        hanoiTower(3,'A','B','C');
        System.out.println();
        hanoiTower(4,'A','B','C');
    }
    //移动盘子的方法
    public static void hanoiTowerMove(char pos1,char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    /**
     * @param n 盘子数量
     * @param pos1 盘子初始位置
     * @param pos2 盘子中转位置
     * @param pos3 盘子目标位置
     */
    public static void hanoiTower(int n,char pos1,char pos2,char pos3) {
        if (n == 1) {//只有一个盘子的时候直接从起始位置传到目标位置
            hanoiTowerMove(pos1,pos3);
            return;
        }
        hanoiTower(n-1,pos1,pos3,pos2);//最底下以上的盘子从pos1通过pos3传到pos2
        hanoiTowerMove(pos1,pos3);//把上面的盘子传完之后把最底下的盘子传到目标位置
        hanoiTower(n-1,pos2,pos1,pos3);//再把剩下的盘子从pos2通过pos1传到pos3
        }

    public static void main2(String[] args) {
        int a = 12;
        int b = 55;
        double m = 15.2;
        double n = 15.5;
        double c = 12.5;
        System.out.println(sumAdd(a,b));
        System.out.println(sumAdd(m,n,c));
    }
    public static int sumAdd(int a,int b) {
        return a+b;
    }
    public static double sumAdd(double a,double b,double c) {
        return a+b+c;
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        double m = 12.2;
        double n = 15.5;
        System.out.println(numMax(a,b));
        System.out.println(numMax(m,n));
        numMax(m,n,a);
    }
    //求两个整数的最大值
    public static int numMax(int a,int b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    //求两个小数的最大值
    public static double numMax(double a,double b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    //求两个小数和一个整数的最大值
    public static void numMax(double a,double b,int c) {
        if (c > numMax(a,b)) {
            System.out.println(c);
        }else {
            System.out.println(numMax(a,b));
        }
    }
}
