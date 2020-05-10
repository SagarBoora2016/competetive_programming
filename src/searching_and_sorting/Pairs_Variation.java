package searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

 class Pairs_Variation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = binSear(arr,n,k);
		int ans2 = twoPoi(arr,n,k);
		System.out.println(ans); ///+ " " + ans2);
	}

	private static int twoPoi(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		int count=0;
		while(i<n && j<n) {
			if(Math.abs(arr[j] - arr[i]) >=k) {
				count+=(n-j);
				i++;
			}else {
				j++;
			}
		}
		return count;
	}

	private static int binSear(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<n-1;i++) {
			int curr = arr[i];
			int secInd = getSec(i,arr,k,i+1,n-1,0);
			count+=(n-secInd);
			//System.out.println(count);
		}
		return count;
	}

	private static int getSec(int i, int[] arr, int k,int st,int j,int ans) {
		// TODO Auto-generated method stub
		if(st>j) {
			return ans;
		}
		int mid=(st+j)/2;
		if(Math.abs(arr[mid] - arr[i]) >=k) {
			ans=mid;
			return getSec(i,arr,k,st,mid-1,ans);
		}else {
			if(ans==0) {
				ans=j+1;
			}
			return getSec(i,arr,k,mid+1,j,j+1);
		}
		
	}
}
