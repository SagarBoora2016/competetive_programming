package advanceGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Bottom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			int val = sc.nextInt();
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
			ArrayList<ArrayList<Integer>> arrt = new ArrayList<ArrayList<Integer>>(n);
			
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> x = new ArrayList<>();
				arr.add(x);
				ArrayList<Integer> y = new ArrayList<>();
				arrt.add(y);
			}
			while(val-->0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				a--;b--;
				arr.get(a).add(b);
				//System.out.println(a + " " + b);
				arrt.get(b).add(a);
			}
			boolean visi[] = new boolean[n];
			boolean visiT[] = new boolean[n];
			Stack<Integer> st = new Stack<>();
			for(int i=0;i<n;i++) {
				if(visi[i]==false) {
					dfs(arr,i,visi,st);
				}	
			}
			ArrayList<ArrayList<Integer>> scc = new ArrayList<ArrayList<Integer>>();	
			while(!st.isEmpty()) {
				if(visiT[st.peek()]==false) {
					ArrayList<Integer> y = new ArrayList<>();
					
					dfs2(arrt,visiT,st.peek(),y);
					//System.out.println(y.size() + " y");
					scc.add(y);
				}	
				st.pop();
			}
		//	System.out.println(scc.size());
			ArrayList<Integer> ans = new ArrayList<>();
			for (int i = 0; i < scc.size(); i++) {
				ArrayList<Integer> l1 = scc.get(i);
				//System.out.println(l1.size() + " size");
//				for(int i1=0;i1<l1.size();i1++) {
//					System.out.print(l1.get(i1) + " ");
//				}
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j=0;j<l1.size();j++) {
					map.put(l1.get(j),1);
				}
				if(get(l1,map,arr)) {
					for(int j=0;j<l1.size();j++) {
						ans.add(l1.get(j));
					}
				}
			}
			//System.out.println(ans.size());
			Collections.sort(ans);
			for(int j=0;j<ans.size();j++) {
				System.out.print((ans.get(j)+1) + " ");
			}
			System.out.println();
		}
		
		
	}

	private static boolean get(ArrayList<Integer> l1, HashMap<Integer, Integer> map,
			ArrayList<ArrayList<Integer>> arr) {
		// TODO Auto-generated method stub
	//	boolean ans=true;
		if(l1.size()==1) {
			return true;
		}
		for(int i=0;i<l1.size();i++) {
			int ele = l1.get(i);
			//System.out.println(ele + " my");
			//System.out.println(arr.get(ele).size());
			for(int j=0;j<arr.get(ele).size();j++) {
				//	System.out.println("elee " + arr.get(ele).get(j));
				if(!map.containsKey(arr.get(ele).get(j))) {
					return false;
				}
			}
		}
		return true;
	}

	private static void dfs2(ArrayList<ArrayList<Integer>> arrt, boolean[] visiT, int peek,ArrayList<Integer> y) {
		// TODO Auto-generated method stub
		visiT[peek]=true;
		y.add(peek);
		for(int j=0;j<arrt.get(peek).size();j++) {
			if(visiT[arrt.get(peek).get(j)]==false) {
				//System.out.print();
				dfs2(arrt, visiT, arrt.get(peek).get(j),y);
			}
		}
	}

	private static void dfs(ArrayList<ArrayList<Integer>> arr, int i, boolean[] visi,Stack<Integer> st) {
		// TODO Auto-generated method stub
		visi[i]=true;
		for(int j=0;j<arr.get(i).size();j++) {
			if(visi[arr.get(i).get(j)]==false) {
				//System.out.print(arr.get(i).get(j) + " ");
				dfs(arr, arr.get(i).get(j), visi,st);
			}
		}
		st.push(i);
	}

}

