package languageToolsTimeandComplexityAssignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Triplet_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<>();
 		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			int temp = arr[i];
			int reqSum = sum-temp;
			arr[i]=0;
			int l=0;
			int r = n-1;
			while(l<r) {
				//System.out.println("l  " + l + " r " + r + " i = "+ i);
				if(arr[l] + arr[r]==reqSum && arr[l]!=0 && arr[r]!=0 ) {
					int arr2[] = new int[3];
					arr2[0] = temp;
					arr2[1] = arr[l];
					arr2[2] = arr[r];
					if(map.containsKey(arr2[0]) || map.containsKey(arr2[1]) || map.containsKey(arr2[2])) {
						
					}else {
						Arrays.sort(arr2);
						System.out.println(arr2[0] + " " + arr2[1]  + " " + arr2[2]);
					}
					
					l++;
				}else if(arr[l] + arr[r] < reqSum) {
					l++;
					
				}else {
					r--;
					
				}
			}
			arr[i] = temp;	
			map.put(arr[i], 1);
		}
	}

}
