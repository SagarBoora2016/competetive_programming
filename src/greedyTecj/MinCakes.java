package greedyTecj;

import java.util.Arrays;
import java.util.Scanner;

public class MinCakes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int index=0;
		long sum=0;
		for(int i=n-1;i>=0;i--) {
			sum= sum + arr[i] * (int)Math.pow(2, index++);
		}
		System.out.println(sum);
	}

}
