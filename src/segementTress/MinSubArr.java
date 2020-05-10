package segementTress;

import java.util.Scanner;

public class MinSubArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int q = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int tree[] = new int[4*n];
		buildTree(arr,tree,0,n-1,1);
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		while(q-->0) {
			char c = sc.next().charAt(0);
			if(c=='q') {
				int l =sc.nextInt();
				int r = sc.nextInt();
				l--;
				r--;
				int ans = query(tree,0,n-1,l,r,1);
				System.out.println(ans);
			}else {
				int index=sc.nextInt();
				index--;
				int value = sc.nextInt();
				update(arr,tree,0,n-1,index,value,1);
//				for (int i = 1; i < tree.length; i++) {
//					System.out.print(tree[i] + " ");
//				}
//				System.out.println();
			}
		}
		sc.close();
	}

	private static void update(int[] arr, int[] tree, int st, int end, int index, int value,int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			arr[index]=value;
			tree[treeNode]= arr[st];
			return;
		}
		int mid=(st+end)/2;
		if(index<=mid) {
			update(arr, tree, st, mid, index, value, 2*treeNode);
		}else {
			update(arr, tree, mid+1, end, index, value, 2*treeNode+1);
		}
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
	}

	private static int query(int[] tree, int st, int end, int l, int r, int treeNode) {
		// TODO Auto-generated method stub
		if(end<l || st>r) {
			return Integer.MAX_VALUE;
		}
		if(st==end) {
			return tree[treeNode];
		}
		
		if(st>=l && end<=r) {
			return tree[treeNode];
		}
		int mid = (st+end)/2;
		int a1 = query(tree, st, mid, l, r, 2*treeNode);
		int a2 = query(tree, mid+1,end, l, r, 2*treeNode+1);
		return Math.min(a1, a2);
		
	}

	private static void buildTree(int[] arr, int[] tree, int st, int end, int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			tree[treeNode] = arr[st];
			return;
		}
		
		int mid = (st+end)/2;
		buildTree(arr, tree, st, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
	}

}
