package dybamic2;

import java.util.Arrays;
import java.util.Scanner;

public class EditDis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(EditDis.editDistance(str1, str2));
		
	}
	public static int editDistance(String s1, String s2){
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		*/
		int arr[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i], -1);
		}
		return get(s1,s2,s1.length(),s2.length(),arr);
	}
	private static int get(String s1, String s2, int m, int n, int[][] arr) {
		// TODO Auto-generated method stub
		if(arr[m][n]>-1) {
			return arr[m][n];
		}
		if(m==0) {
			return n;
		}
		if(n==0) {
			return m;
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			int ans= get(s1.substring(1), s2.substring(1),m-1,n-1,arr);
			arr[m][n]=ans;
			return ans;
		}else {
			int op1 =1+ get(s1.substring(1), s2.substring(1), m-1, n-1, arr);
			int op2 =1+ get(s1.substring(1), s2, m-1, n, arr);
			int op3 =1+ get(s1, s2.substring(1), m, n-1, arr);
			int ans = Math.min(op1, Math.min(op2, op3));
			arr[m][n] = ans;
			return ans;
		}
	}

}
