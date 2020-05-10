package backtacking;

import java.util.Scanner;

public class Rat_In {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		Rat_In.ratInAMaze(maze);	
	}

	private static void ratInAMaze(int[][] maze) {
		// TODO Auto-generated method stub
		int myArr[][] = new int[maze.length][maze.length];
		start(maze,myArr,0,0);
	}

	private static void start(int[][] maze, int[][] myArr, int row, int col) {
		// TODO Auto-generated method stub
		myArr[row][col]=1;
		//System.out.println(row + " " + col);
		if(row==maze.length-1 && col==maze.length-1) {
			//print
			for(int i=0;i<maze.length;i++) {
				for(int j=0;j<maze.length;j++) {
					System.out.print(myArr[i][j] + " ");
				}
			}
			System.out.println();
			return;
		}
		if(row+1<maze.length && (maze[row+1][col] ==1) && myArr[row+1][col]!=1 ) {
			start(maze,myArr,row+1,col);
		}
		if(row-1>=0 && (maze[row-1][col] ==1)  && myArr[row-1][col]!=1 ) {
			start(maze,myArr,row-1,col);
		}
		if(col+1<maze.length  && (maze[row][col+1] ==1)  && myArr[row][col+1]!=1 ) {
			start(maze,myArr,row,col+1);
		}
		if(col-1>=0  && (maze[row][col-1] ==1)  && myArr[row][col-1]!=1) {
			start(maze,myArr,row,col-1);
		}
		myArr[row][col]=0;
	}

}
