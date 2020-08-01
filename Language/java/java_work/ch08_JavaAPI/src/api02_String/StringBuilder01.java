package api02_String;

public class StringBuilder01 {
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		System.out.println("() 버퍼크기: " + sb.capacity());
		
		StringBuilder sb1 = new StringBuilder("Java");
		
		System.out.println("() 버퍼크기: " + sb1.capacity());
		System.out.println("----------------------");
		System.out.println(sb);
		
		sb.append("Java ");
		
		System.out.println(sb);
		System.out.println(sb1);
		System.out.println("() 버퍼크기: " + sb.capacity());
		
		sb.append(" King");
		
		System.out.println(sb);
		System.out.println("() 버퍼크기: " + sb.capacity());
		
		sb.setCharAt(5, 'k');
		
		System.out.println(sb);
		
		sb.insert(5, "of ");
		
		System.out.println(sb);
		
		sb.replace(8, 13, "love");
		
		System.out.println(sb);
		
		sb.delete(4, 7);
		
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println("() 버퍼크기: " + sb.capacity());
		
		sb.trimToSize();
		
		System.out.println("() 버퍼크기: " + sb.capacity());
		
	}
}
