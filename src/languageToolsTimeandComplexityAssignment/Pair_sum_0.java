package languageToolsTimeandComplexityAssignment;

import java.util.HashMap;
import java.util.Scanner;

public class Pair_sum_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			if(map.containsKey(arr[i])) {
				map.put(arr[i],map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		for(int i=0;i<n;i++) {
			int x= arr[i];
			int v1 = map.get(x);
			map.put(arr[i], 0);
			int v2=0;
			if(map.containsKey(-x)) {
				v2= map.get(-x);
				map.put(-x, 0);
			}
			int v = v1*v2;
			for(int i1=0;i1<v;i1++) {
				System.out.println( Math.min(x, -x)+ " " + Math.max(x, -x));
			}
			
		}
		
	}
}
