package backtacking;

import java.util.Scanner;

public class N_Queen {
	static int arr[][] = new int[11][11];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		placeNQueens(n);
		
	}
	private static void placeNQueens(int n) {
		// TODO Auto-generated method stub
		nQueenHelper(n,0);
	}
	private static void nQueenHelper(int n, int row) {
		// TODO Auto-generated method stub
		//System.out.println("Here");
		if(row==n) {
			//System.out.println("Here");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(isPossible(row,i)) {
				arr[row][i]=1;
				nQueenHelper(n, row+1);
				arr[row][i]=0;
			}
		}
	}
	private static boolean isPossible(int row, int col) {
		// TODO Auto-generated method stub
		for(int i=row-1;i>=0;i--) {
			if(arr[i][col]==1){
				return false;
			}
		}
		for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--) {
			if(arr[i][j]==1) {
				return false;
			}
		}
		for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++) {
			if(arr[i][j]==1) {
				return false;
			}
		}
		return true;
	}
}
