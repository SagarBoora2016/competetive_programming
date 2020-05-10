package dynamic1;

import java.util.Scanner;

public class JonSnow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		
		int rangers[] = new int[1024];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			rangers[arr[i]]++;
		}
		while(k-->0) {
			int count=0;
			int newRan[] = new int[1024];
			for(int i=0;i<rangers.length;i++) {	
				if(rangers[i]==0) {
					continue;
				}
				if(rangers[i]%2==0) {
					int num = rangers[i]/2;
					newRan[i]+=num;
					int nx = i^x;
					newRan[nx]+=num;
				}else {
					if(count%2!=0) {
						int num = rangers[i]/2;
						newRan[i]+=(num+1);
						int nx = i^x;
						//System.out.println(nx + " nx " + i + " even " + num);
						newRan[nx]+=num;
					}else {
						int num = rangers[i]/2;
						newRan[i]+=num;
						int nx = i^x;
						//System.out.println(nx + " nx " + i + " odd " + num);
						newRan[nx]+=(num+1);
					}
				}
				count +=rangers[i];
			}
			rangers = newRan;
		}
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<1024;i++) {
			if(rangers[i]!=0) {
				min = i;
				break;
			}
		}
		for(int i=1023;i>=0;i--) {
			if(rangers[i]!=0) {
				max = i;
				break;
			}
		}
		
		System.out.println(max + " " + min);
	}

}
