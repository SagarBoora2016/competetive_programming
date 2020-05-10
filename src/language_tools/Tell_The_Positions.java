package language_tools;

import java.util.Arrays;
import java.util.Scanner;

public class Tell_The_Positions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Aa arr[] = new Aa[n];
		for(int i=0;i<n;i++) {
			arr[i] = new Aa();
			arr[i].rollNo=i+1;
			arr[i].name = sc.next();
			int x=sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			arr[i].sum = x+y+z;
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			System.out.println(i+1 + " " + arr[i].name);
			
		}
	}

}
class Aa implements Comparable<Aa>{
	int rollNo;
	String name;
	int sum=0;
	public int compareTo(Aa a) {
		if(this.sum == a.sum) {
			return this.rollNo - a.rollNo;
		}else {
			return a.sum-this.sum;
		}
	}
}
