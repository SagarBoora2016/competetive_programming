package fpbitmasking;

import java.util.*;

public class Bandy {

	static int MAXN = 16;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n;
		int[][] like = new int[MAXN][MAXN];
		n = scan.nextInt();
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n; j++){
				like[i][j] = scan.nextInt();
			}
		}
		System.out.println(new Bandy().solve(like,n));

	}
	long solve(int[][] like,int N){
		
		//Write your code here.
		long dp[] = new long[1<<N];
		Arrays.fill(dp, 0);
		dp[0]=1;
		for(int max=0;max<(1<<N)-1 ;max++) {
			int temp=max;
			int k=0;
			while(temp>0) {
				if(temp%2==1) {
					k++;
				}
				temp=temp/2;
			}
			for(int j=0;j<N;j++) {
				if( (max&(1<<j)) ==0 && like[k][j]==1 ) {
					dp[max|(1<<j)] += dp[max];
				}
			}
		}
		
		return dp[(1<<N ) -1];
		
	}

}
