package advanceGraph;

import java.util.HashMap;
import java.util.Scanner;

public class ConnDots {

public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N,M,i;
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		String[] board = new String[N];
		
		for(i = 0; i < N; i++){
			
			board[i] = scan.next();
			
		}
		System.out.println(new ConnDots().solve(board,N,M));

	}
	int solve(String[] board , int n, int m)
	{
		// Write your code here.
		HashMap<Character,Integer> map =new HashMap<>();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map.containsKey(board[i].charAt(j))) {
					int a = map.get(board[i].charAt(j));
					map.put(board[i].charAt(j), a+1);
				}else {
					map.put(board[i].charAt(j),1);
				}
			}
		}
		int a=0;
		HashMap<Character,Integer> map2 = new HashMap<>();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map2.containsKey(board[i].charAt(j))) {
					continue;
				}else {
					boolean visited[][] = new boolean[n][m];
					int aa = get(board,n,m,board[i].charAt(j),i,j,visited);
					map2.put(board[i].charAt(j), 1);
					if(aa==map.get(board[i].charAt(j))) {
						return 1;
					}
				}
			}
		}	
		return 0;
	}
	private int get(String[] board, int n, int m, char charAt, int i, int j,boolean visited[][]) {
		// TODO Auto-generated method stub
		
		if(i>=n || i<0 || j<0 || j>=m) {
			return 0;
		}
		if(visited[i][j]==true) {
			return 0;
		}
		visited[i][j]=true;
		if(board[i].charAt(j)!=charAt) {
			return 0;
		}
		int ans = 1;
		ans+=get(board, ans, m, charAt, i+1, j, visited);
		ans+=get(board, ans, m, charAt, i-1, j, visited);
		ans+=get(board, ans, m, charAt, i, j+1, visited);
		ans+=get(board, ans, m, charAt, i, j-1, visited);
		return ans;
		
		
	}
}