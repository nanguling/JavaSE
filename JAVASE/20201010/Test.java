public class Test
{
	public static void main(String[] args){
		int a = 6;
		int b = -1;
		int c = a;//����a��ֵ����c����ʱ����a��ֵΪ�գ�����c��ֵΪ6
		a = b;//����b��ֵ����a����ʱ����b��ֵΪ�գ�����a��ֵΪ-1
		b = c;//����c��ֵ����b����ʱ����c��ֵΪ�գ�����b��ֵΪ6
		System.out.println("a = " + a);//-1
		System.out.println("b = " + b);//6
	}
}