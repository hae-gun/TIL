package etc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IO{
	String right=null;
    String tmp=null;
	IO(){
	 try {
		 String s;
		 BufferedReader br = new BufferedReader( new FileReader( "test.txt" ) );
		 String[] re = new String[10];
		 int ran = (int)(Math.random()*10);
         
		 int i = 0;
		 while ( (s = br.readLine()) != null ) {
			 StringTokenizer st = new StringTokenizer( s );
			 re[i] = st.nextToken();
			i++;
		 }
		 
		 right = re[ran];
		 
		 }
		 catch ( IOException ex ) {
		 ex.printStackTrace();
		 }
	}
	public String getString(){
		return right;
	}
}
