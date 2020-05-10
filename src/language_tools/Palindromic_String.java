package language_tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Palindromic_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			String s = sc.next();
			gtPal(s);
		}
	}

	private static void gtPal(String s) {
		// TODO Auto-generated method stub
		int arr[] = new int[26];
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-'a']++;
			if(map.containsKey(s.charAt(i))) {
				ArrayList<Integer> list = map.get(s.charAt(i));
				list.add(i);
				map.put(s.charAt(i), list);
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(s.charAt(i), list);
			}
		}
		int odd_count=0;
		for(int i=0;i<26;i++) {
			if(arr[i]%2!=0) {
				odd_count++;
			}
		}
		if(odd_count >=2 || (s.length()%2==0 && odd_count>0)) {
			System.out.println(-1);
			return;
		}
		System.out.println("Not -1");
		int c[] =new int[s.length()];
		int stIndex=0;
		int lIndex = s.length()-1;
		
		for(int i=0;i<26;i++) {
			//System.out.println('a' + i);
			char c1= (char)('a' + i);
			if(map.containsKey(c1)) {
				ArrayList<Integer> list = map.get(s.charAt(i));
				//System.out.println(list);
				if(list.size()%2!=0) {
					int length = list.size()/2;
					//System.out.println(list);
					while(length>0) {
						c[stIndex++] = list.get(0);
						list.remove(0);
						c[lIndex--] = list.get(0);
						list.remove(0);
						length--;
					}
					c[s.length()/2] = list.get(0);
					list.remove(0);
				}else {
				//	System.out.println(list);
					int length = list.size()/2;
					for(int j =0;j<length;j++) {
						c[stIndex++] = list.get(0);
					//	System.out.println(list);
						list.remove(0);
					//	System.out.println(list);
						c[lIndex--] = list.get(0);
						list.remove(0);
						
					}
				}
			}
		}
		for(int i=0;i<s.length();i++) {
			System.out.print(c[i] + " ");
		}
	}
}
