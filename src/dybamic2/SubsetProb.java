package dybamic2;

import java.util.Scanner;

public class SubsetProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		//boolean a = get(arr,k,0,0);
		boolean a = get(arr,k);
		if(a) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	private static boolean get(int[] arr, int k) {
		// TODO Auto-generated method stub
		boolean ans[][] = new boolean[arr.length+1][k+1];
		for(int i=0;i<arr.length;i++) {
			ans[i][0] = true;
		}
		for(int i=1;i<k+1;i++) {
			ans[0][i] = false;
		}
		for(int i=1;i<arr.length+1;i++) {
			for(int j=1;j<k+1;j++) {
				ans[i][j] = ans[i-1][j];
				if(j>=arr[i-1]) {
					ans[i][j] = ans[i][j] || ans[i-1][j-arr[i-1]];
				}
			}
		}
		return ans[arr.length][k];
	}

	private static boolean get(int[] arr, int k, int sum, int index) {
		// TODO Auto-generated method stub
		if(k==sum) {
			return true;
		}
		if(index>=arr.length) {
			return false;
		}
		
		return get(arr,k,sum+arr[index],index+1) || get(arr,k,sum,index+1);
	}
}
