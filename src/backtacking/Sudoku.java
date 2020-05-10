package backtacking;

import java.util.Scanner;

public class Sudoku {
	static int row=0;
	static int col=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println("Inpit");
		if(solveSudoku(arr,9)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		
	}
	public static boolean solveSudoku(int[][] arr, int n) throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(1000);
		int r=-1;
		int c=-1;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(arr[i][j]==0) {
					
					for(int k=1;k<=9;k++) {
					///	System.out.println(i + " " + j);
						if(isPossible(arr,i,j,k)) {
							arr[i][j]=k;
							
							if(solveSudoku(arr, 9)) {
								return true;
							}
							arr[i][j]=0;
						}
						if(k==9) {
							return false;
						}
					}
					
				}
			}
		}
		return true;
	}
	public static boolean isPossible(int[][] arr, int i, int j, int k) {
		// TODO Auto-generated method stub
		System.out.println("row and col " + i + " " + j + " " + k);
		for(int i1=0;i1<9;i1++) {
			if(arr[i1][j]==k) {
				//System.out.println(i1 + " " + j + " here");
				return false;
			}
		}
		for(int i1=0;i1<9;i1++) {
			if(arr[i][i1]==k) {
				System.out.println(i + " " + i1 + " here");
				return false;
			}
		}
		int myRow = i/3;
		int myCol=j/3;
		myRow = myRow*3;
		myCol = myCol*3;
		for(int i1=myRow;i1<myRow+3;i1++) {
			for(int j1=myCol;j1<myCol+3;j1++) {
				if(arr[i1][j1]==k) {
					//System.out.println(i1 + " fone " + j1);
					return false;
				}
			}
		}
		return true;
	}
	
}


