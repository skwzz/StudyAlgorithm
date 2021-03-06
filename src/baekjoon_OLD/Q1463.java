package baekjoon_OLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		/*
		 * Xκ°? 2λ‘? ???΄ ?¨?΄μ§?λ©? 2?Όλ‘? ??
		 * Xκ°? 3λ‘? ???΄ ?¨?΄μ§?λ©? 3λ‘? ??
		 * 1? λΊ?
		 */
		arr = new int[num+1];
		
		arr[1] = 0;
		for(int i=2; i<=num; i++) {
			int c1 = 1000001;
			int c2 = 1000001;
			int c3 = 1000001;
			
			if(i%2==0) {
				c1 = arr[i/2];
			}
			if(i%3==0) {
				c2 = arr[i/3];
			}
			c3 = arr[i-1];
			arr[i] = Math.min(Math.min(c1, c2), c3)+1;
		}
		//System.out.println(arr[num]);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("["+i+"]:"+arr[i]);
		}
	}
}
