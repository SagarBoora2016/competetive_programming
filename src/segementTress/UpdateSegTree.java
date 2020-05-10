package segementTress;

public class UpdateSegTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,2,3,4,5};
		int tree[] = new int[2*arr.length];
		BuildTree(arr,tree,0,arr.length-1,1);
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
		update(arr,tree,0,arr.length-1,2,9,1);
		System.out.println();
		for (int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
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
