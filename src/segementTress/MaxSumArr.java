package segementTress;

import java.util.Scanner;

public class MaxSumArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int tree[] = new int[4*n];
		buildTree(arr,tree,0,n-1,1);
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
		int q = sc.nextInt();
		while(q-->0) {
			int x=sc.nextInt();
			int y = sc.nextInt();
			x--;
			y--;
			int ans=query(arr,tree,0,n-1,x,y,1);
			System.out.println(ans);
		}
	}

	private static int query(int[] arr, int[] tree, int st, int end, int l, int r, int treeNode) {
		// TODO Auto-generated method stub
		if(end<l || st>r) {
			return 0;
		}
		if(st>=l && end<=r) {
			return tree[treeNode];
		}
		int mid=(st+end)/2;
		int a1 = query(arr, tree, st, mid, l, r, 2*treeNode);
		int a2 = query(arr, tree, mid+1, end, l, r, 2*treeNode+1);
		return a1+a2;
	}

	private static void buildTree(int[] arr, int[] tree, int st, int end, int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			tree[treeNode] =  arr[st];
			return;
		}
		int mid = (st+end)/2;
		buildTree(arr, tree, st, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode] =  Math.max(tree[2*treeNode+1]+tree[2*treeNode],Math.max(tree[2*treeNode+1], tree[2*treeNode]));
	}
}
