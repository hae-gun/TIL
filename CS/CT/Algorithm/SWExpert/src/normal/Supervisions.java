package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Supervisions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.valueOf(br.readLine());
			Long[] A = new Long[N];
			
			String[] countA = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				A[i] = Long.valueOf(countA[i]);
			}
			
			String[] countBC = br.readLine().split(" ");
			
			Long B = Long.valueOf(countBC[0]);
			Long C = Long.valueOf(countBC[1]);
			
			Long Nb = Long.valueOf(N);
			Long Nc = 0L;
			Long aNc = 0L;
			for(Long a : A) {
				Long temp;
				if (a>=B) {
					temp = (a-B) % C;
					if(temp == 0) Nc += (a-B)/C;
					else Nc += (a-B)/C + 1;
				}
			}
			// 루프 안에 수식을 분기 없이 한줄로 표현가
			for(Long a: A) {
				aNc += (a - B + C + 1) / C;
			}
			
			
			System.out.println(Nb + Nc);
			System.out.println(Nb + aNc);

	}

}
