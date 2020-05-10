package languageToolsTimeandComplexityAssignment;

import java.util.ArrayList;
import java.util.HashMap;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static ArrayList<Integer> longestSubsequence(int[] arr){
        
		ArrayList<Integer> list = new ArrayList<>();
            if(arr.length==0){
                return null;
            }
		HashMap<Integer,Boolean> map = new HashMap<>();
		HashMap<Integer,Integer> map2 = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],true);
            if(map2.containsKey(arr[i])){
                
            }else{
                map2.put(arr[i], i);
            }
			
		}
		int length=0;
		int maxLength=0;
		int st=0;
		int maxSt=0;
		int end=0;
		int maxEnd=0;
		int xIndex=0;
		for(int i=0;i<arr.length;i++) {
			//System.out.println(maxSt + " " + maxEnd);
			if(map.get(arr[i])==true) {
			//	System.out.println("first");
				length=1;
				int a = arr[i];
				map.put(a, false);
				st=a;
				end=a;
				while(map.containsKey(a+1)) {
				//	System.out.println(a);
				//	System.out.println("Seocnd");
					a = a+1;
					end=a;
					length++;
					map.put(a, false);
				}
				a = arr[i];
				while(map.containsKey(a-1)) {
					//System.out.println("third");
					a=a-1;
					st=a;
					length++;
					map.put(a,false);
				}
				int index=map2.get(arr[i]);
				if(length>=maxLength) {
					if(maxLength==length) {
						int a1 = map2.get(st);
						int a2 = map2.get(maxSt);
						if(a1<a2) {
							maxSt=st;
							maxEnd=end;
							
						}else {
							
						}
					}else {
						maxLength=length;
						maxSt=st;
						maxEnd=end;
					}
				
				}
			}else {
				continue;
			}
		}
		for(int i=maxSt;i<=maxEnd;i++) {
			list.add(i);
		}
		return list;
		
		// Write your code here

	}
}
