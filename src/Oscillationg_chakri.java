import java.util.Scanner;

public class Oscillationg_chakri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		int maxArr[] = new int[n];
		maxArr[n-1] = arr[n-1];
		for(int i=n-2;i>=0;i--) {
			maxArr[i] = Math.max(maxArr[i+1],arr[i]);
		}
		int max=-1;
		for(int i=0;i<n-1;i++) {
			int x = maxArr[i+1] - arr[i];
			if(max<x) {
				max=x;
			}
		}
		System.out.println(max);
	}

}
