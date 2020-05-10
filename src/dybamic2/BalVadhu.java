package dybamic2;

import java.util.Arrays;
import java.util.Scanner;

public class BalVadhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			String s1 = sc.next();
			String s2 = sc.next();
			int k = sc.nextInt();
			int m = s1.length();
			int n = s2.length();
			int arr[][][] = new int[m+1][n+1][k+1];
			for(int i=0;i<m+1;i++) {
				for(int j=0;j<n+1;j++) {
					Arrays.fill(arr[i][j], -1);
				}
			}
			int ans = get(s1,s2,m,n,arr,k);
			System.out.println(Math.max(ans, 0));
			
		}
	}

	private static int get(String s1, String s2, int m, int n, int[][][] arr, int k) {
		// TODO Auto-generated method stub
		//System.out.println(m + "  " + n);
		if(arr[m][n][k]>-1) {
			return arr[m][n][k];
		}
		if(m<=0 || n<=0) {
			if(k!=0) {
				return Integer.MIN_VALUE;
			}
			return 0;
		}
		if(k<=0) {
			return 0;
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			int op1 = s2.charAt(0) + get(s1.substring(1),s2.substring(1),m-1,n-1,arr,k-1);
			int op2 =  get(s1.substring(1),s2,m-1,n,arr,k);
			int op3 = get(s1,s2.substring(1),m,n-1,arr,k);
			arr[m][n][k] = Math.max(op1, Math.max(op2, op3));
		}else {
			int op2 = get(s1.substring(1),s2,m-1,n,arr,k);
			int op3 = get(s1,s2.substring(1),m,n-1,arr,k);
			arr[m][n][k]= Math.max(op2, op3);
		}
		return arr[m][n][k];
	}
}
