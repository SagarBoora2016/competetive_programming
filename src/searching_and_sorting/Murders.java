package searching_and_sorting;
import java.util.*;
public class Murders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases= sc.nextInt();
		while(cases-->0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			long x = get(arr,0,n-1);
//			for(int i=0;i<n;i++) {
//				System.out.println(arr[i]);
//			}
			System.out.println(x);
		}
	}

	private static long get(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		if(i>=n) {
			return 0;
		}
		int mid=(i+n)/2;
		long x1 = get(arr,i,mid);
		long x2 = get(arr,mid+1,n);
		
		return x1 + x2 +get(arr,i,mid,mid+1,n);
	}

	private static long get(int[] arr, int i, int mid, int j, int n) {
		// TODO Auto-generated method stub
		int a1[] = new int[mid-i+1];
		int a2[] = new int[n-mid];
		for(int i1=0;i1<a1.length;i1++) {
			a1[i1] = arr[i+i1];
		}
		for(int i1=0;i1<a2.length;i1++) {
			a2[i1] = arr[j+i1];
		}
		int a3[] = new int[a1.length + a2.length];
		int i1=0;
		int j1=0;
		int index=0;
		long ans=0;
		while(i1<a1.length && j1<a2.length) {
			if(a1[i1]<a2[j1]) {
				ans = ans + (a2.length - j1)*a1[i1];
				a3[index++] = a1[i1++];
			}else {
				a3[index++] = a2[j1++];
			}
		}
		while(i1 < a1.length) {
			a3[index++] = a1[i1++];
		}
		while(j1 < a2.length) {
			a3[index++] = a2[j1++];
		}
		index=0;
		i1=0;
		for(i1=0;i1<a3.length;i1++) {
			arr[i1+i] = a3[index++];
		}
		return ans;
	}
}
