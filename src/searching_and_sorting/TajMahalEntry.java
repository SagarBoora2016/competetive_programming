package searching_and_sorting;

import java.util.Scanner;

public class TajMahalEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int k=0;
		int index=0;
		while(k==0) {
			if(arr[index]<=0) {
				k++;
			}else {
				for(int i=0;i<n;i++) {
					arr[i]--;
				}
				index=(index+1)%n;
			}
		}
		System.out.println(index+1);
	}

}
