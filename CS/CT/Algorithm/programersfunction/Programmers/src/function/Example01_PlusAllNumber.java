package function;

public class Example01_PlusAllNumber {

	public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        long ans = sum(a);
        System.out.println(ans);
    }

    static long sum(int[] a) {
        
        
        long ans = 0;
        for(int i : a){
         ans += i;   
        }
        return ans;
    }
}
