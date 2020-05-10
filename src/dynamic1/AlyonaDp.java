package dynamic1;

import java.util.Scanner;

public class AlyonaDp {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int arr[][] = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int dp[][] = new int[r][c];
		for(int i=0;i<c;i++) {
			dp[0][i] = 0;
			//System.out.println(dp[0][i]);
		}
		for(int i=1;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i-1][j] >arr[i][j]) {
					dp[i][j]=i;
				}else {
					dp[i][j] = dp[i-1][j];
				}
				//System.out.print(dp[i][j] + " ");
			}
		//	System.out.println();
		}
		int ansarr[] = new int[r];
		for(int i=0;i<r;i++) {
			int myMin = Integer.MAX_VALUE;
			for(int j=0;j<c;j++) {
				myMin = Math.min(myMin, dp[i][j]);
			}
			ansarr[i] = myMin;
			//System.out.print(ansarr[i] + " ");
		}
		int cases = sc.nextInt();
		while(cases-->0) {
			int le = sc.nextInt();
			int ri = sc.nextInt();
			le--;
			ri--;
			if(ansarr[ri]<=le) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		sc.close();
	}
}
