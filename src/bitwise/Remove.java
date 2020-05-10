package bitwise;

import java.util.Scanner;

public class Remove {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		int z = 1<<(i);
		z = z-1;
		System.out.println(n&z);
	}
}
