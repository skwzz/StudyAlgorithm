package baekjoon_OLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1712 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		/*
		 * a : κ³ μ λΉμ©
		 * b : κ°?λ³?λΉμ©
		 * (a=1000 b=70 ?Όκ²½μ° 1κ°? ??°? 1070 / 10κ°? ??°? 1700)
		 * c : ?λ§€λΉ?©
		 */
		
		if(b>=c) {
			System.out.println("-1");
		}else {
			int temp1 = c - b; // 100
			int temp2 = a/temp1;
			System.out.println(temp2+1);
		}
	}
}
