package greedyTecj;

import java.util.Arrays;
import java.util.Scanner;

public class WeightJobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Wjb w[] = new Wjb[n];
		for(int i=0;i<n;i++) {
			w[i]= new Wjb();
			w[i].stTime = sc.nextInt();
			w[i].endTime = sc.nextInt();
			w[i] .profit = sc.nextInt();
		}
		Arrays.sort(w);
		long arr[] = new long[n];
		arr[0] = w[0].profit;
		for(int i=1;i<n;i++) {
			int stTime=w[i].stTime;
			int work=0;
			int index=getBst(0,i,w,-1,stTime);
			if(index==-1) {
				
			}else {
				work+=arr[index];
			}
			work+=w[i].profit;
			arr[i] = Math.max(arr[i-1], work);
		}
		System.out.println(arr[n-1]);
	}

	private static int getBst(int i, int i2, Wjb[] w, int ans,int stTime) {
		// TODO Auto-generated method stub
		if(i>i2) {
			return ans;
		}
		int mid = (i+i2)/2;
		if(w[mid].endTime<=stTime) {
			ans=mid;
			return getBst(mid+1,i2,w,ans,stTime);
		}else {
			return getBst(i,mid-1,w,ans,stTime);
		}
	//	return 0;
	}

}

class Wjb implements Comparable<Wjb>{
	int stTime;
	int endTime;
	int profit;
	public int compareTo(Wjb w) {
		return this.endTime - w.endTime;
	}
}