public class TestDemo {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
    public static int fib(int n) {
        if (n < 3) {
            return  n;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main5(String[] args) {
        int n = 132;
        System.out.println(sumNum(n));
    }
    public static int sumNum(int n) {
        if (n < 10) {
            return n;
        }
        return sumNum(n/10) + n%10;
    }

    public static void main4(String[] args) {
        int n = 10;
        System.out.println(sum(n));
    }
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    public static void main3(String[] args) {
        int n = 132;
        System.out.println(n);
    }
    public static void num(int n) {
        if (n > 9) {
            num(n/10);
        }
        System.out.println(n%10);
    }

    public static void main2(String[] args) {
        int n = 5;
        System.out.println(fac(n));
    }
    public static int fac(int n) {
        if (n ==1) {
            return n;
        }
        n = n * fac(n-1);
        return n;
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(add(a, b));

        double m = 12.3;
        double n = 15.2;
        System.out.println(add(m,n));
    }
    //以下两个方法构成方法重载：方法名相同，参数列表不同，返回值不做要求
    public static int add(int a,int b) {
        int ret = a + b;
        return ret;
    }
    public static double add(double a,double b) {
        double ret = a + b;
        return ret;
    }
}
