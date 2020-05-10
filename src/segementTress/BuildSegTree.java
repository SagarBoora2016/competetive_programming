package segementTress;

public class BuildSegTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
		int tree[] = new int[2*arr.length];
		BuildTree(arr,tree,0,arr.length-1,1);
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
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
