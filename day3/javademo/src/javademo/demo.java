package javademo;

public class demo {
int a=20;
static int b = 11;
	void demo() {
		System.out.println("constructor");
	}
	
	void add(int a) {
		System.out.println("abcd"+a);
		System.out.println("abcd"+this.a);
	}
	public static void main(String[] args) {
		demo Demo= new demo();
		Demo.demo();
		Demo.add(3);
		System.out.println(Demo.a);
		System.out.println(b);
	}
}
