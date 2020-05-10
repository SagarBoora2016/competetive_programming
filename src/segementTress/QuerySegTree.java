package segementTress;

public class QuerySegTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,2,3,4,5};
		int tree[] = new int[2*arr.length];
		BuildTree(arr,tree,0,arr.length-1,1);
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
		//update(arr,tree,0,arr.length-1,2,9,1);
		System.out.println();
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		int left=2;
		int right=4;
		int st=0;
		int end=arr.length-1;
		int treeNode=1;
		int ans= getAns(tree,st,end,treeNode,left,right);
		System.out.println(ans);
	}

	private static int getAns(int[] tree, int st, int end, int treeNode, int left, int right) {
		// TODO Auto-generated method stub
		if(st==end) {
			return tree[treeNode];
		}
		//outside
		int mid = (st+end)/2;
		if(end<left || st > right) {
			return 0;
		}
		else if(st>=left && end<=right) {
			return tree[treeNode];
		}else {
			return getAns(tree,st,mid,2*treeNode,left,right) +getAns(tree,mid+1,end,2*treeNode+1,left,right); 
			
		}
		
		
		
	}

	private static void update(int[] arr, int[] tree, int st, int end, int index, int value, int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			arr[index]=value;
			tree[treeNode] = arr[st];
			return;
		}
		int mid = (st+end)/2;
		if(index<=mid) {
			update(arr,tree,st,mid,index,value,2*treeNode);
			tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
		}else {
			update(arr,tree,mid+1,end,index,value,2*treeNode+1);
			tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
		}
	}

	

	private static void BuildTree(int[] arr, int[] tree, int st, int end, int treeNode) {
		// TODO Auto-generated method stub
		if(st==end) {
			tree[treeNode] = arr[st];
			return;
		}
		int mid = (st+end)/2;
		BuildTree(arr,tree,st,mid,2*treeNode);
		BuildTree(arr,tree,mid+1,end,2*treeNode+1);
		tree[treeNode] = tree[2*treeNode] +tree[2*treeNode+1]; 
	}


	
}
