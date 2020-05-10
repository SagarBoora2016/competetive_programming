package searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CAndies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			long arr[] = new long[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextLong();
			}
			Arrays.sort(arr);
			long a=0;
			System.out.println(get(arr,a,arr[n-1],0,k));
		}
	}
	private static long get(long[] arr, long i, long l,long ans,long k) {
		// TODO Auto-generated method stub
		if(i>l) {
			return ans;
		}
		long mid=(i+l)/2;
		if(isPossible(arr,mid,k)) {
			ans=mid;
			return get(arr,mid+1,l,ans,k);
		}else {
			return get(arr,i,mid-1,ans,k);
		}
	}

	private static boolean isPossible(long[] arr, long mid, long k) {
		// TODO Auto-generated method stub
		//k = no of students
		//mid=to give choco
		long ans=0;
		for(int i=0;i<arr.length;i++) {
			ans+=(arr[i]/mid);
		}
		if(ans>=k) {
			return true;
		}else {
			return false;
		}
	}
}
