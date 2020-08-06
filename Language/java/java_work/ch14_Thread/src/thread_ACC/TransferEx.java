package thread_ACC;

public class TransferEx {
	public static void main(String[] args) {
		Bank sb = new Bank();
		sb.acc1 = new Account("111","tom",19000);
		sb.acc2 = new Account("222","jane",20000);
		
		
		System.out.println(sb.getTotal());
		
		sb.transfer(5000);
		System.out.println(sb.getTotal());
		
		System.out.println("--------------------");
		TransferThread tf = new TransferThread(sb);
		
		TotalPrintThread tp = new TotalPrintThread(sb);
		tf.start();
//		tf2.start();
		tp.start();
	}
}
