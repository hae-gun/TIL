package Synchro_Asynchro;

public class CallByValue {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.printf("a: %d, b: %d\n",a,b);
		swap(a,b);
		System.out.printf("a: %d, b: %d\n",a,b);
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}


class Tv extends Product{
    Tv() {
       super(100);
    }

}
class Product{
//	Product(){
//		
//	}
	Product(int a){
		
	}
}

//class Tv{
//    Tv() {
//       super(100);
//    }
//
//}