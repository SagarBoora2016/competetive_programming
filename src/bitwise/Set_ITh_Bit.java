package bitwise;

import java.util.Scanner;

public class Set_ITh_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		int z = 1<<i;
		int ans = n|z;
		System.out.println(ans);
	}

}
