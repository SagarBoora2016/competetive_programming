package advanceGraph;
import java.util.*;
import java.io.*;
public class ConnectedHorses {
	static int kkk=0;
	static long ansarr[] = new long[9000];
public static void main(String[] args) throws IOException {
	ansarr[0]=1;
	ansarr[1]=1;
	int mm = 1000000000+7;
	for (int i = 2; i < ansarr.length; i++) {
		ansarr[i] = ansarr[i-1]*i;
		ansarr[i] = ansarr[i]%mm;
	}
	BufferedReader br = new BufferedReader( 
            new InputStreamReader(System.in)); 

	 StringTokenizer ssst = new StringTokenizer(br.readLine()); 
	int cases = Integer.parseInt(ssst.nextToken()); 
//	sc.close();
	while(cases-->0) {
		boolean ans=true;
		 StringTokenizer st = new StringTokenizer(br.readLine()); 
		 int n = Integer.parseInt(st.nextToken()); 
		 int m = Integer.parseInt(st.nextToken());
		 int q = Integer.parseInt(st.nextToken());
	
		
		
		int graph[][] = new int[n][m];
		while(q-->0) {
			 StringTokenizer s1t = new StringTokenizer(br.readLine()); 
			 int a = Integer.parseInt(s1t.nextToken()); 
			 int b = Integer.parseInt(s1t.nextToken());
			a--;b--;
			graph[a][b]=1;
		}
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if(graph[i][j]==1) {
					
				}else {
					visited[i][j]=true;
				}
			}
		}
		ArrayList<Integer> conn = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j]==1 && visited[i][j]==false) {
					
					getDfs(graph,visited,i,j,n, m);
					conn.add(kkk);
					kkk=0;
					//System.out.println(arr.size());
				}
			}
		}
		
		
		int siz = conn.size();
		long myans = 1;
		for(int i=0;i<siz;i++) {
			int no = conn.get(i);
			myans = ((myans%mm) * (ansarr[no]%mm))%mm;
			//System.out.println(myans);
		}
		System.out.println(myans);
	
	}
}

private static void getDfs(int[][] graph, boolean[][] visited, int i, int j,int n,int m) {
	// TODO Auto-generated method stub
	//System.out.println(i + " " + j);
	visited[i][j]=true;
	kkk++;
	if(i-2>=0 && j-1 >=0  && visited[i-2][j-1]==false) {
		getDfs(graph, visited, i-2, j-1, n, m);
	}
	if(i-1>=0 && j-2 >=0 && visited[i-1][j-2]==false) {
		getDfs(graph, visited, i-1, j-2, n, m);
	}
	if(i+1<n && j-2 >=0 && visited[i+1][j-2]==false) {
		getDfs(graph, visited, i+1, j-2, n, m);
	}
	if(i+2<n && j-1 >=0 && visited[i+2][j-1]==false) {
		getDfs(graph, visited, i+2, j-1, n, m);
	}
	if(i-2>=0 && j+1 <m && visited[i-2][j+1]==false) {
		getDfs(graph, visited, i-2, j+1, n, m);
	}
	if(i-1>=0 && j+2<m && visited[i-1][j+2]==false) {
		getDfs(graph, visited, i-1, j+2, n, m);
	}
	if(i+1<n && j+2<m && visited[i+1][j+2]==false) {
		getDfs(graph, visited, i+1, j+2, n, m);
	}
	if(i+2<n && j+1 <m && visited[i+2][j+1]==false) {
		getDfs(graph, visited, i+2, j+1, n, m);
	}
}

}
