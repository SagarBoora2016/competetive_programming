package advanceGraph;

import java.util.Scanner;

public class ThreeCycle {

	public static int[]u=new int [5005];
	public static int[]v=new int [5005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		for(int i=0;i<m;i++)
		{
			u[i]=scan.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			v[i]=scan.nextInt();
		}
		System.out.println(new ThreeCycle().solve(n,m,u,v));
	}
	
	public int solve(int n,int m,int U[],int V[]) {
        //write your code here
		
		int graph[][] = new int[n][n];
		for (int i = 0; i < m; i++) {
			graph[U[i]-1][V[i]-1]=1;
			graph[V[i]-1][U[i]-1]=1;
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					continue;
				}
				if (graph[i][j]==1) {
					for (int k = 0; k < n; k++) {
						if(i==k || j==k) {
							continue;
						}
						if(graph[j][k]==1 && graph[i][k]==1) {
							count++;
						}
					}
				}
			}
		}
		return count/6;
    }

}
