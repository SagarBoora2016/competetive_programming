package segementTress;

import java.util.Scanner;

public class MaximumPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Node node[] = new Node[4*n];
		for(int i=0;i<node.length;i++) {
			node[i] = new Node();
		}
		buildTree(arr,node,0,n-1,1);
//		for(int i=0;i<node.length;i++) {
//			System.out.println(node[i].max + " " + node[i].secMax);
//		}
		int q = sc.nextInt();
		while(q-->0) {
			char c = sc.next().charAt(0);
			if(c=='Q') {
				int l = sc.nextInt();
				int r = sc.nextInt();
				l--;
				r--;
				Node ans = query(arr,node,0,n-1,l,r,1);
				System.out.println(ans.max + ans.secMax);
			//	System.out.println("done");
			}else {
				int index=sc.nextInt();
				index--;
				int value = sc.nextInt();
				update(arr,node,0,n-1,1,index,value);
			}
		}
		sc.close();
	}

	private static Node query(int[] arr, Node[] node, int st, int end, int l, int r,int treeNode) {
		// TODO Auto-generated method stub
		//outside
		if(end<l || st>r) {
			Node n = new Node();
			n.max= Integer.MIN_VALUE;
			n.secMax= Integer.MIN_VALUE;
			return n;
		}
		if(st==end) {
			return node[treeNode];
		}
		if(l<=st && r>=end) {
			return node[treeNode];
		}else {
			int mid = (st+end)/2;
			Node a = query(arr, node, st, mid, l, r,2*treeNode);
			Node b = query(arr, node, mid+1, end, l, r,2*treeNode+1);
			Node myN = new Node();
			myN.max = Math.max(a.max,b.max);
			myN.secMax=Math.min(Math.max(a.max, b.secMax), Math.max(a.secMax, b.max));
			//System.out.println(treeNode + " " + myN.max +  " " + myN.secMax);
			return myN;
		}
		
	}

	private static void update(int[] arr, Node[] node, int st, int end, int treeNode,int index,int value) {
		// TODO Auto-generated method stub
		if(st==end) {
			arr[st] = value;
			node[treeNode].max = arr[st];
			node[treeNode].secMax = Integer.MIN_VALUE;
			return;
		}
		int mid = (st+end)/2;
		if(index<=mid) {
			update(arr, node, st, mid, 2*treeNode, index, value);
		}else {
			update(arr, node, mid+1, end, 2*treeNode+1, index, value);
		}
		node[treeNode].max = Math.max(node[2*treeNode].max, node[2*treeNode+1].max);
		node[treeNode].secMax = Math.min(Math.max(node[2*treeNode].max, node[2*treeNode+1].secMax), Math.max(node[2*treeNode+1].max, node[2*treeNode].secMax));
	}

	private static void buildTree(int[] arr, Node[] node, int st, int end, int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			node[treeNode].max = arr[st];
			node[treeNode].secMax= Integer.MIN_VALUE;
			return;
		}
		int mid= (st+end)/2;
		buildTree(arr, node, st, mid, 2*treeNode);
		buildTree(arr, node, mid+1, end, 2*treeNode+1);
		node[treeNode].max = Math.max(node[2*treeNode].max, node[2*treeNode+1].max);
		node[treeNode].secMax = Math.min(Math.max(node[2*treeNode].max, node[2*treeNode+1].secMax), Math.max(node[2*treeNode+1].max, node[2*treeNode].secMax));
		
	}
}
class Node{
	int max;
	int secMax;
	
}
