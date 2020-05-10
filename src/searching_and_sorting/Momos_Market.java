package searching_and_sorting;

import java.util.Scanner;

public class Momos_Market {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int shop [] = new int[n];
		long ans[] = new long[n];
		for(int i=0;i<n;i++) {
			shop[i] = sc.nextInt();
			if(i==0) {
				ans[0]=shop[i];
			}else {
				ans[i] = shop[i] + ans[i-1];
			}
		}
		int q = sc.nextInt();
		long price[] = new long[q];
		
		for(int i=0;i<q;i++) {
			price[i] = sc.nextLong();
		}
		
//		for(int i=0;i<q;i++) {
//			System.out.println(get(shop,price[i]));
//		}
//		System.out.println();
//		
		for(int i=0;i<q;i++) {
			long ans1=-1;
			long myPrice=getBinary(shop,price[i],ans, 0 ,n-1,ans1);
			if(myPrice==-1) {
				System.out.println(0+ " " + (price[i]));
			}else {
				long aa=price[i] - ans[(int) myPrice];
				System.out.println((myPrice+1)+ " " + aa);
			}
			
		}
	}

	private static long getBinary(int[] shop, long l, long[] ans, int i, int m,long myAns) {
		// TODO Auto-generated method stub
		if(i>m) {
			return myAns;
		}
		int mid = (i+m)/2;
		if(l > ans[mid] ) {
			myAns = mid;
			return getBinary(shop,l,ans,mid+1,m,myAns);
		}else {
			return getBinary(shop,l,ans,i,mid-1,myAns);
		}
	}

	private static long get(int[] shop, long l) {
		// TODO Auto-generated method stub
		long price=l;
		long noOfMomos = 0;
		for(int i=0;i<shop.length;i++) {
			if(price >= shop[i]) {
				noOfMomos++;
				price=price-shop[i];
			}else {
				break;
			}
		}
		System.out.print(noOfMomos + " ");
		return price;
	}
	
}