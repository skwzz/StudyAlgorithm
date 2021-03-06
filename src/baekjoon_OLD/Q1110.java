package baekjoon_OLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1110 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 0 <= n <= 99
		int base = n;
		int cnt = 0;
		
		
		do {
			cnt++;
			n = plusCycle(n);
		}while(base!=n);
		
		System.out.println(cnt);
	}
	public static int plusCycle(int n) {
		/*
		 * 1. n?΄ 10λ³΄λ€ ??Όλ©? ?? 0? λΆμ¬ ? ?λ¦¬μλ₯? λ§λ€κ³? ( 6 -> 06 )
		 * 2. κ°? ?λ¦¬μ ?«?λ₯? ???€ ( 0 + 6 = 6 )
		 * μ£Όμ΄μ§? ?? κ°??₯ ?€λ₯Έμͺ½ ? + ?©?Όλ‘? κ΅¬ν ?? κ°??₯ ?€λ₯Έμͺ½ ? ???€
		 */
		if(n<10) {
			return (10*n)+n;
		}
		int sum = 0;
		sum = n/10 + n%10;
		return (n%10)*10 + sum%10;
	}
}
