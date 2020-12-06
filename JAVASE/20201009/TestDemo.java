public class TestDemo {

	public static void main(String[] args) {
		boolean flg = true;//布尔类型，没有明确规定占用多少字节
		System.out.println(flg);
	}

	public static void main7(String[] args) {
		short sh = 18;//短整型，2个字节
		System.out.println(Short.MAX_VALUE);//短整型的类
		System.out.println(Short.MIN_VALUE);
	}

	public static void main6(String[] args) {
		byte b = 10;//字节型，1个字节
		System.out.println(b);

		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

	}

	public static void main5(String[] args) {
		char ch = 'f';//字符型，2个字节，字符类Character
		System.out.println(ch);
	}

	public static void main4(String[] args) {
		float f = 12.5f;//默认double型，要加强制转换符;单精度浮点型，4个字节
		System.out.println(f);

		double d = 12.8;//双精度浮点型，8个字节
		System.out.println(d);

		double a = 1.0;
		double b = 2.0;
		System.out.println(a / b);//0.5

		double num = 1.1;
		System.out.println(num * num);//1.2100000000000002

	}

	public static void main3(String[] args) {
		long a = 10L;//系统默认int类型，要加强制类型转换符
		System.out.println(a);

		System.out.println(Long.MAX_VALUE);//长整型的类
		System.out.println(Long.MIN_VALUE);

	}


	public static void main2(String[] args) {
		/*int _ = 10;
		int ______ = 1
		int ____ = 10;
		int ___ = 10;ctr+shift+/
		System.out.println(_);

		int age;
		age = 99;
		System.out.println(age);*/

		System.out.println(Integer.MAX_VALUE);//int类型的类
		System.out.println(Integer.MIN_VALUE);

		int a = Integer.MAX_VALUE+2;
		System.out.println(a);//-2^32+1
		int b = Integer.MIN_VALUE-1;
		System.out.println(b);//2^32-1
	}

	public static void main1(String[] args) {
		for (int i = 0;i < args.length ;i++ ) {
			System.out.println(args[i]);
		}
		System.out.println("========");
		System.out.println("hello");
	}
}


