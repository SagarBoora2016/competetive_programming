package dynamic1;

import java.util.Scanner;

public class StaircasePeob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		arr[0]=1;
		if(n==1) {
			System.out.println(1);
			return;
		}
		if(n==2) {
			System.out.println(2);
			return;
		}
		if(n==3) {
			System.out.println(4);
			return;
		}
		arr[1]=1;
		arr[2]=2;
		arr[3] =4;
		for(int i=4;i<=n;i++) {
			arr[i] = arr[i-1]+arr[i-3]+arr[i-2];
		}
		System.out.println(arr[n]);
	}

}
