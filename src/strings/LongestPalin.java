package strings;

import java.util.Scanner;

public class LongestPalin {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		int count = LongestPalin.countPalindromeSubstrings(input);
		System.out.println(count);
	}
	
	public static int countPalindromeSubstrings(String s) {
		// Write your code here
		int no=0;
		for(int i=0;i<s.length();i++) {
			int i1=i-1;
			int i2= i+1;
			no++;
			int len=1;
			while(i1>=0 && i2<s.length() && s.charAt(i1) == s.charAt(i2)) {
					no++;
					i1--;
					i2++;
			}
		//	System.out.println(i + " " + i);
			if(i>0) {
				int i11=i-1;
				int i22=i;
				int l2=0;
				while(i11>=0 && i22<s.length() && s.charAt(i11) == s.charAt(i22)) {
						no++;
						i11--;
						i22++;
				}
			}
		}
		return no;
	}

}
