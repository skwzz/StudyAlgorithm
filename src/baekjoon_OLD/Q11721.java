package baekjoon_OLD;
import java.util.Scanner;

/**
 * ?΄ κ°μ© ??΄ μΆλ ₯?κΈ?
 * 
 * @author kiwoong
 *
 */
public class Q11721 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		for(int i=0; i<str.length(); i++) {
			if(i!=0 && i%10==0) {
				System.out.println("");
			}
			System.out.print(str.charAt(i));
		}
	}
}
