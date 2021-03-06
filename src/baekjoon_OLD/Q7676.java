package baekjoon_OLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7676 {
	static int[][] arr;
	static int[][] visited;
	// ??μ’μ° ???© λ°°μ΄
	static int[] nX = {-1, 0, 1, 0};
	static int[] nY = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		arr = new int[height][width];
		visited = new int[height][width];
		Queue<Tomato> queue = new LinkedList<Tomato>();
		// 1 : ?΅?? ? λ§ν  , 0 : ??΅?? ? λ§ν  , -1 : ? λ§ν κ°? ??€?΄κ°???
		boolean startAndComplete = true; // 0?΄ ??€?΄?? κ²½μ° μ²΄ν¬?©
		
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 0) {
					startAndComplete = false;
				}
				// 1?΄ ?€?΄?? κ²½μ° λ°λ‘ λ°©λ¬Έμ²΄ν¬ ? ?? ? λ§ν  ?μΉμ λ³΄λ?? κ°?μ§?κ³ μ? κ°μ²΄λ₯? add
				if(arr[i][j] == 1) {
					visited[i][j] = 1;
					queue.add(new Tomato(i, j));
				}
				// -1?Έ κ²½μ° λ―Έλ‘μ°ΎκΈ°? λ²½μ²?Ό ?κ°?. ?΄?Ή ?μΉλ?? λ°©λ¬Έμ²΄ν¬
				if(arr[i][j] == -1) {
					visited[i][j] = 1;
				}
			}
		}
		//μ²μ ?? ₯? ??΅?? ? λ§ν κ°? ?κ°λ ??€?΄?? κ²½μ° λ°λ‘ 0μΆλ ₯ ? ?
		if(startAndComplete) {
			System.out.print("0");
			return;
		}
		
		int max = -1;
		while(!queue.isEmpty()) {
			Tomato current = queue.poll();
			
			for(int i=0; i<4; i++) {
				// ?€? ???  ?μΉ? κ³μ°
				int nextX = current.x + nX[i];
				int nextY = current.y + nY[i];
				// ?€? ?μΉκ? λ°°μ΄? ??΄κ°? κ²½μ° continue
				if(nextX<0 || nextY<0 || nextX>=height || nextY>=width) {
					continue;
				}
				// ?€? ?μΉκ? ?΄λ―? λ°©λ¬Έ?΄ ??? κ²½μ° continue
				if(visited[nextX][nextY]==1) {
					continue;
				}else {
					/*
					 * ?€? μ’νλ₯? λ°©λ¬Έμ²΄ν¬
					 * ?€? ? λ§ν  ?μΉλ?? ??¬ ? λ§ν  κ°? + 1 (?΄κ±Έλ‘ ?Ό?λ₯? κ³μ°? κ±°μ)
					 * max?? λΉκ΅ ? maxλ³΄λ€ ?¬?€λ©? max? ???₯
					 * ?? ?€? μ’ν? λ³΄λ?? κ°?μ§?κ³? ?? ? λ§ν  κ°μ²΄ add
					 */
					visited[nextX][nextY]=1;
					arr[nextX][nextY] = arr[current.x][current.y]+1;
					if(max<arr[nextX][nextY]) {
						max = arr[nextX][nextY];
					}
					queue.add(new Tomato(nextX, nextY));
				}
			}
		}
		// ?¨?? ? λ§ν κ°? ??μ§? μ²΄ν¬
		boolean finish = true;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(arr[i][j]==0) {
					finish = false;
				}
			}
		}
		// λ§€λ¬΄λ¦? 
		if(finish) {
			System.out.print(max-1);
		}else {
			System.out.print("-1");
		}
	}
}
class Tomato{
	int x;
	int y;
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
