package dynamic1;

import java.util.Scanner;

public class BiotionicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int maxArr[]= new int[n];
		maxArr[0] =1;
		for(int i=1;i<n;i++) {
			maxArr[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(arr[i] > arr[j]) {
					if(maxArr[j] + 1 >maxArr[i]) {
						maxArr[i] = maxArr[j]+1;
					}
				}
			}
		}
		int minArr[] = new int[n];
		minArr[n-1]=0;
		for(int i=n-2;i>=0;i--) {
			minArr[i]=0;
			for(int j=i+1;j<n;j++) {
				if(arr[i] >arr[j]) {
					if(minArr[j] + 1>minArr[i]) {
						minArr[i] = minArr[j]+1;
					}
				}
			}
		}
		
//		for(int i=0;i<n;i++) {
//			System.out.print(maxArr[i] + " ");
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.print(minArr[i] + " ");
//		}
		int output[] = new int[n];
		//System.out.println();
		output[0] = minArr[0];
		int max=output[0];
		for(int i=0;i<n;i++) {
           output[i] = maxArr[i] + minArr[i];
           max=Math.max(max, output[i]);
		}
		output[n-1]=maxArr[n-1];
		max= Math.max(max, output[n-1]);
		System.out.println(max);
	}
}
