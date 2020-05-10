package assignmext_nacltrack;

import java.util.Scanner;

public class Is_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			if(isPossible(arr)) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
	}

	private static boolean isPossible(int[] arr) {
		// TODO Auto-generated method stub
		int ifPossible=0;
		while(ifPossible==0) {
			//System.out.println(ifPossible);
			for(int i=1;i<arr.length;i++) {
				if(arr[i]-arr[i-1]==-1) {
					ifPossible++;
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
			if(ifPossible==0) {
				ifPossible = 1;
			}else {
				ifPossible=0;
			}
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
		}
		int flag=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				
			}else {
				flag++;
				break;
			}
		}
		if(flag>0) {
			return false;
		}else {
			return true;
		}
		//return false;
	}

}
