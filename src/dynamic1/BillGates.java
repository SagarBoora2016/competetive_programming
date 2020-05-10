package dynamic1;

import java.util.Arrays;
import java.util.Scanner;

public class BillGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int k =sc.nextInt();
		int arr[] = new int[n];
		long arrsum[] = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long ans[] = new long[n];
		ans[0]=0;
		arrsum[0]=arr[0];
		for(int i=1;i<k;i++) {
			ans[i] =ans[i-1] + i*arr[i] - arrsum[i-1];
			arrsum[i]=arrsum[i-1]+arr[i];
			//System.out.println(ans[i]);
		}
		for(int i=k;i<n;i++) {
			arrsum[i] =arrsum[i] -  arrsum[i-k];
			ans[i] = ans[i-1] -2*(arrsum[i]) +(k-1)*arr[i-k] + (k-1) * arr[i];
			arrsum[i] = arrsum[i-1] + arr[i];
		}
		long min = Integer.MAX_VALUE;
		for(int i=k-1;i<n;i++) {
			//System.out.print(ans[i] +  " ");
			min = Math.min(min, ans[i]);
		}
		System.out.println(min);
		
	}
}
