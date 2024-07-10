import java.util.*;
import java.io.*;


public class Main {

	
	static int n, m;
	static List<Integer> graph[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	graph[u].add(v);
        	graph[v].add(u);
        	
        }
        
        
        System.out.println(bfs(1));
        
    }
    
    static int bfs(int s) {
    	int size = 0;
    	Queue<int[]> que = new ArrayDeque<>();
    	visited[1] = true;
    	que.offer(new int[] {1, 0});
    	
    	while (!que.isEmpty()) {
    		int[] cur = que.poll();
    		if (cur[1] == 2) continue;
    		for (int i = 0; i < graph[cur[0]].size(); i++) {
    			int next = graph[cur[0]].get(i);
    			
    			if (!visited[next]) {
    				visited[next] = true;
    				size++;
    				que.offer(new int[] {next, cur[1] + 1});
    			}
    		}
    		
    	}
    	
    	
    	
    	return size;
    }
    
}
