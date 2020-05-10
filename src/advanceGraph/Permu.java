package advanceGraph;

import java.util.*;

public class Permu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-->0) {
			boolean ans=true;
			int n = sc.nextInt();
			int p[] = new int[n];
			int q[] = new int[n];
			int m = sc.nextInt();
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			
			for (int i = 0; i < q.length; i++) {
				p[i] = sc.nextInt();
				p[i]--;
				ArrayList<Integer> ar = new ArrayList<>();
				arr.add(ar);
			}
			for (int i = 0; i < q.length; i++) {
				q[i] = sc.nextInt();
				q[i]--;
				
			}
			while(m-->0) {
				int a = sc.nextInt();
				int b= sc.nextInt();
				a--;b--;
				arr.get(a).add(b);
				arr.get(b).add(a);
				
			}
			ArrayList<ArrayList<Integer>> conn = new ArrayList<ArrayList<Integer>>();
			
			boolean visited[] = new boolean[n];
			for(int i=0;i<visited.length;i++) {
				if(visited[i]==false) {
					ArrayList<Integer> myLis = new ArrayList<>();
					myLis = dfs(arr,visited,i,myLis);
					conn.add(myLis);
				}
			}
			int ifFound = 0;
			int k = conn.size();
			int index=0;
			while(k-->0) {
				ArrayList<Integer> lis = conn.get(index);
				HashMap<Integer,Integer> map = new HashMap<>();
				for (int i = 0; i < lis.size(); i++) {
					map.put(p[lis.get(i)], 1);
				}
				for (int i = 0; i < lis.size(); i++) {
					int no = lis.get(i);
					if(map.containsKey(q[no])) {
						
					}else {
						ifFound++;
						break;
					}
				}
				if(ifFound>0) {
					break;
				}
				
				index++;
			}
			if(ifFound==0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		
		
		
		}
	}

	private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int node,ArrayList<Integer> myLis) {
		// TODO Auto-generated method stub
		visited[node] = true;
		myLis.add(node);
		ArrayList<Integer> a1 = arr.get(node);
		for(int i=0;i<a1.size();i++) {
			if(visited[a1.get(i)]==false) {
				dfs(arr, visited, a1.get(i),myLis);
			}
		}
		return myLis;
		
	}
}
