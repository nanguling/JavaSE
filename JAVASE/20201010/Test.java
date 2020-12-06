public class Test
{
	public static void main(String[] args){
		int a = 6;
		int b = -1;
		int c = a;//变量a的值赋给c，此时变量a的值为空，变量c的值为6
		a = b;//变量b的值赋给a，此时变量b的值为空，变量a的值为-1
		b = c;//变量c的值赋给b，此时变量c的值为空，变量b的值为6
		System.out.println("a = " + a);//-1
		System.out.println("b = " + b);//6
	}
}