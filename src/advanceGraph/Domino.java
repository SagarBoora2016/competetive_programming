package advanceGraph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Domino {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			int n = sc.nextInt();
			int val = sc.nextInt();
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
			//ArrayList<ArrayList<Integer>> arrt = new ArrayList<ArrayList<Integer>>(n);
			
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> x = new ArrayList<>();
				arr.add(x);
//				ArrayList<Integer> y = new ArrayList<>();
//				arrt.add(y);
			}
			while(val-->0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				a--;b--;
				arr.get(a).add(b);
				//System.out.println(a + " " + b);
				//arrt.get(b).add(a);
			}
			int ans=0;
			boolean visi[] = new boolean[n];
			boolean visiT[] = new boolean[n];
			Stack<Integer> st = new Stack<>();
		//	Stack<Integer> stt = new Stack<>();
			for(int i=0;i<n;i++) {
				if(visi[i]==false) {
					//System.out.print( i + " ");
					ans++;
					dfs(arr,i,visi,st);
				}	
			}
			//System.out.println(ans);
			int ans2=0;
			while(!st.isEmpty()) {
				if(visiT[st.peek()]==false) {
					ans2++;
					dfs2(arr,visiT,st.peek());
				}
				st.pop();
			}
			//System.out.println(ans + " " + ans2);
			//Arrays.fill(visiT, false);
			System.out.println(Math.min(ans, ans2));
		}
		
		
	}

	private static void dfs2(ArrayList<ArrayList<Integer>> arrt, boolean[] visiT, int peek) {
		// TODO Auto-generated method stub
		visiT[peek]=true;
		for(int j=0;j<arrt.get(peek).size();j++) {
			if(visiT[arrt.get(peek).get(j)]==false) {
				//System.out.print();
				dfs2(arrt, visiT, arrt.get(peek).get(j));
			}
		}
	}

	private static void dfs(ArrayList<ArrayList<Integer>> arr, int i, boolean[] visi,Stack<Integer> st) {
		// TODO Auto-generated method stub
		visi[i]=true;
		for(int j=0;j<arr.get(i).size();j++) {
			if(visi[arr.get(i).get(j)]==false) {
				System.out.print(arr.get(i).get(j) + " ");
				dfs(arr, arr.get(i).get(j), visi,st);
			}
		}
		//stt.push(i);
		st.push(i);
	}

}
