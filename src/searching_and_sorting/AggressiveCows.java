package searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases-->0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int cows = sc.nextInt();
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int ans=0;
			//System.out.println(arr[n-1]);
			int ans1 = get(arr,cows,0,arr[n-1]-1,ans);
			System.out.println(ans1);
		}
		
	}

	private static int get(int[] arr, int cows, int i, int j,int ans) {
		// TODO Auto-generated method stub
		if(i>j) {
			return ans;
		}
		int mid = (i+j)/2;
		//System.out.println(mid);
		if(possible(mid,arr,cows)) {
			ans = mid;
			return get(arr,cows,mid+1,j,ans);
		}else {
			return get(arr,cows,0,mid-1,ans);
		}
	}

	private static boolean possible(int mid, int[] arr, int cows) {
		// TODO Auto-generated method stub
		//System.out.println(" mis" + mid);
		cows--;
		int index=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-arr[index]>=mid) {
				index=i;
				cows--;
			}
			if(cows<=0) {
				return true;
			}
		}
		if(cows<=0) {
			return true;
		}
		//System.out.println(cows);
		return false;
	}

}
