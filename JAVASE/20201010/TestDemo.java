public class TestDemo {
	public static void main(String[] args) {
		boolean a = true ? false : true == true ? true : false;
		System.out.println(a);//false 
		boolean b = false ? false : true == true ? true : false;
		System.out.println(b);//true
	}

	public static void main20(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(a == b);//false
		System.out.println(a != b);//true
		System.out.println(a >= b);//false
		System.out.println(a <= b);//true
		System.out.println(!(a < b));
		System.out.println(10 > 20 && 10 / 0 == 0);//flase
		//System.out.println(10 > 20 || 10 / 0 == 0);算数异常
	}

	public static void main19(String[] args) {
		int a = 10;
		a = a++;
		System.out.println(a);//10
	}

	public static void main18(String[] args) {
		int a = 10;
		int b = a++;
		System.out.println(b);//10
	}

	public static void main17(String[] args) {
		//System.out.println(10/0);编译通过，运行报错：算数异常
		int a = 10;
		a += 10;//a = a + 10
		System.out.println(a);//20
	}

	public static void main16(String[] args) {
		System.out.println(10%3);//1
		System.out.println(-10%3);//-1
		System.out.println(10%-3);//1
		System.out.println(-10%-3);//-1
		System.out.println(11.5%2.0);//1.5
	}

	public static void main15(String[] args) {
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println((float) 5/2);
		System.out.println(5/ (float) 2);
		System.out.println((float)(5/2));//2.0
	}

	public static void main14(String[] args) {
		String str = "123";
		int a = Integer.valueOf(str);
		System.out.println(a);
	}

	public static void main13(String[] args) {
		int num = 10;
		String str1 = 10 + " ";
		System.out.println(str1);

		String str2 = String.valueOf(num);
		System.out.println(str2);
	}

	public static void main12(String[] args) {
		int a = 10;
		long b = 20;

		int c = (int)(a+b);
		System.out.println(c);
	}

	public static void main11(String[] args) {
		/*byte a = 128;
		System.out.println(a);
		byte b = Byte.MAX_VALUE;
		System.out.println(b);*/
		byte b1 = 1;
		byte b2 = 2;
		byte b3 = (byte)(b1 + b2);
		System.out.println(b3);
	}

	public static void main10(String[] args) {
		int a = 1;
		boolean b = false;
		//a = (int)b;布尔类型只有两个值true和false
	}

	public static void main9(String[] args) {
		int a = 10;
		double b = 1.5;
		a = (int)b;
		System.out.println(a);//1
	}

	public static void main8(String[] args) {
		int a = 10;
		long b = a;
		int c = (int)b;//强制类型转换
		System.out.println(a + "," + b + "," + c);
	}

	public static void main7(String[] args) {
		final int A = 10;
		//A = 12;被final修饰的A不允许更改
		System.out.println(A);
	}

	public static void main6(String[] args) {
		{
			int a = 10;
			System.out.println(a);
		}
		//System.out.println(a);编译报错，a的作用域仅限于上面的括号
	}

	public static void main5(String[] args) {
		int a = 10;
		{
			a = 45;
			System.out.println(a);
		}
		System.out.println(a);
	}

	public static void main4(String[] args) {
		String str = "result =";
		String a = "10";
		String b = "20";
		System.out.println(str + a + b);
	}

	public static void main3(String[] args) {
		System.out.println("ad" + "cd");
		int a = 10;
		System.out.println("a = " + a);
		int b = 20;
		System.out.println("a" + "+" + "b" + "=" + (a + b));	
	}

	public static void main2(String[] args) {
		System.out.println("\"abcd\"");
		System.out.println("D:\\biteJAVA\\20201010");
	}

	public static void main1(String[] args) {
		String str = "hello";
		System.out.println(str);

		System.out.print("打印输出但不换行");
		System.out.println("打印输出换行");
		System.out.printf("%s\n");
	}
}