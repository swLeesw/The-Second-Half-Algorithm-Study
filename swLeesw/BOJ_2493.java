import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	public int first;//index
	public int second;//height
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
}

public class Main {
	static Stack<Pair> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n, sol[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		sol = new int[n];		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) { //스택에 뭐 있으면
				if (stack.peek().second >= current) { //스택에 있는 값이 현재 탑보다 크거나 같으면
					sol[i] = stack.peek().first + 1;
					break;
				}
				stack.pop();//스택에 있는 값이 현재 탑보다 작으면
			}				
			stack.push(new Pair(i, current)); //스택에 넣기				
		}
		for (int i = 0; i < n; i++) {
			System.out.print(sol[i] + " ");
		}
		
	}
	
}




