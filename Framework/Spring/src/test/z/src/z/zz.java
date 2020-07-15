package z;

public class zz {

	public static void main(String[] args) {
		for(int i=0; i<5; i++){ 
		    String a = "";
			for(int j=0; j<5;j++){
		    	if(i==j) a +="#";
		        else a +="+";
		       
		    }  
		    System.out.println(a);
		}
	}

}
