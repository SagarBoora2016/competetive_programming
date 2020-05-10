package fpbitmasking;

import java.util.Scanner;

public class GhostType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A arr[] = new A[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new A();
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i].no = 4;
			arr[i].name = "jhelllo";
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].no + " " + arr[i].name);
		}
	}
	
}
class A{
	int no;
	String name;
}
