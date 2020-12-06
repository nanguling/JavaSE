package exception;

import java.util.Scanner;

public class TestDemo {
    public static void func() throws ArithmeticException{
        Scanner scanner = new Scanner(System.in);
        /*int[] a = {1};
        System.out.println(a[100]);*/
        int a = scanner.nextInt();
        System.out.println(10/a);
    }
    public static void main(String[] args) {
        try {
            func();
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
        /*Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            System.out.println(10 / a);
            int[] arr = null;
            System.out.println(arr.length);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算数异常");
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } finally {
            System.out.println("一定会被执行");
            scanner.close();
        }*/
        System.out.println("hello");
    }
}
