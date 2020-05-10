package gfg;

/*package whatever //do not write package name here */

import java.util.*;

import javafx.scene.Node; 

public class Exam 
{
	public void diagonalPrint(TreeNode root)
	{
	   // your code here
		HashMap<Integer,ArrayList<Integer> > map = new HashMap<>();
		get(root,0,map);
		Set<Integer> st = map.keySet();
		for(int i : st) {
			ArrayList<Integer> ar = map.get(i);
			for (int j = 0; j < ar.size(); j++) {
				System.out.print(ar.get(i) + " ");
			}
			System.out.println();
		}
	}
	public static void get(Node root, int ht,HashMap<Integer,ArrayList<Integer>> map) {
		if(root==null) {
			return;
		}
		if(map.containsKey(ht)) {
			
		}else {
			map.put(ht, new ArayList<Integer>);
		}
		ArrayList<Integer> ar = map.get(ht);
		ar.add(root.data);
		get(root.left,ht-1,map);
		get(root.rightt,ht,map);
		
	}
} 