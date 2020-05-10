package fpbitmasking;

import java.util.*;

public class Delima {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String [] v = new String[n];
		for(int i = 0; i < n; i++)
		{
			v[i] = scan.next();
		}
		System.out.println(Delima.minimumTouchRequired(n,v));
	}
	public static int minimumTouchRequired(int n, String[] input) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, they are passed as function arguments.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		int dp[][] = new int[input[0].length()+1][1<<(n+1)];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], 1000000);
		}
		int mask = (1<<n) -1;
		return find(0,input,mask,dp);
	}
	private static int find(int pos, String[] input, int mask, int[][] dp) {
		// TODO Auto-generated method stub
		if((mask & (mask-1)) ==0) {
			return 0;
		}
		if(pos>=input.length) {
			return 1000000;
		}
		
		if(dp[pos][mask]!=1000000) {
			return dp[pos][mask];
		}
		int nm1=0;
		int nm2=0;
		int touch=0;
		for(int i=0;i<input.length;i++) {
			if((mask & 1<<i) >0) {
				touch++;
				if(input[i].charAt(pos) == '0') {
					nm1 = nm1 |(1<<i) ;
				}else {
					nm2 = nm2 |(1<<i) ;
				}
			}
		}
		int asn1 = touch + find(pos+1, input, nm1, dp) + find(pos+1, input, nm2, dp);
		int ans2 = find(pos+1, input, mask, dp);
		dp[pos][mask] = Math.min(ans2, asn1);
		return dp[pos][mask];
	}
}
