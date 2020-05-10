package assignmext_nacltrack;

import java.util.Scanner;

public class Collecting_Balls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long myAns=0;
		long ans = get(n,1,n/2, myAns);
		System.out.println(ans);
		//System.out.println(isPossible(n, 1));
	}

	private static long get(long n, long st, long end, long myAns) {
		// TODO Auto-generated method stub
		//System.out.println(st + " " + end);
		if(st>end) {
			return myAns;
		}
		long mid = (st+end)/2;
		if(isPossible(n,mid)) {
			return get(n,st,mid-1,mid);
		}else {
			return get(n,mid+1,end,myAns);
		}		
	}

	private static boolean isPossible(long n, long mid) {
		// TODO Auto-generated method stub
		long arun=0;
		long sharma=0;
		long n1=n;
		while(n>mid) {
			arun +=mid;
			n=n-mid;
			long x1=n/10;
			sharma+=x1;
			n = n-x1;
			//System.out.println( "N " + n);
		}
		arun +=n;
		n=n1;
		if(n%2==1) {
			n++;
		}
		//System.out.println(arun + " " + n);
		if(arun>=(n/2)) {
			
			return true;
		}else {
			return false;
		}
	}

}
