package language_tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



public class Different_Names {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s11 = sc.nextLine();
		String s [] = s11.split(" ");
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<s.length;i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i],map.get(s[i]) +1);
			}else {
				map.put(s[i], 1);
			}
		}
		int my=0;
		for(String m:   map.keySet()) {
			int x = map.get(m);
			if(x>1) {
				my++;
				System.out.println(m + " " + x);
			}
		}
		if(my==0) {
			System.out.println(-1);
		}
	}
}
