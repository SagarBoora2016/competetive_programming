package strings;

import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		String pattern = s.nextLine();
		System.out.println(KMP.findString(text, pattern));
	}
	public static int findString(String text, String pattern) {
		// Write your code here
		int n = text.length();
		int m = pattern.length();
		int i=0;
		int j=0;
		int arr[] = get(pattern,m);
		//System.out.println(n + " " + m);
		while(i <n && j<m) {
			//System.out.println(i + " " + j);
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j==0) {
					i++;
				}else {
					j = arr[j-1];
				}
			}
			//System.out.println(i + " " + j);
		}
		//System.out.println(i);
		if(j==m) {
			return i-pattern.length();
		}else {
			return m;
		}
	}
	private static int[] get(String s, int m) {
		// TODO Auto-generated method stub
		int arr[] = new int[m];
		arr[0]=0;
		int i=1;
		int j=0;
		while(i<m) {
			if(s.charAt(i)==s.charAt(j)) {
				arr[i]=j+1;
				i++;
				j++;
			}else {
				if(j<=0) {
					arr[i]=0;
					i++;
				}else {
					j = arr[j-1];
				}
			}
		}
		return arr;
	}

}
