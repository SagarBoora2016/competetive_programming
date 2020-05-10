package dynamic1;

import java.util.Scanner;

public class MaximumSquareMatrix {

	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner s=new Scanner(System.in);
			int n=s.nextInt();
			int m=s.nextInt();
			int arr[][]=new int[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					arr[i][j]=s.nextInt();
			System.out.println(MaximumSquareMatrix.findMaxSquareWithAllZeros(arr));
		}
		
		
		public static int findMaxSquareWithAllZeros(int[][] arr){
			
			int ans[][] = new int[arr.length][arr[0].length];
			int ans1=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i][0]==0) {
					ans[i][0]=1;
					ans1=ans[i][0];
				}else {
					ans[i][0]=0;
				}
			}
			for(int i=0;i<arr[0].length;i++) {
				if(arr[0][i]==0) {
					ans[0][i]=1;
					ans1=ans[0][i];
				}else {
					ans[0][i]=0;
				}
			}
			for(int i=1;i<arr.length;i++) {
				for(int j=1;j<arr[0].length;j++) {
					if(arr[i][j]==1) {
						ans[i][j]=0;
					}else {
						if(arr[i-1][j] == arr[i][j-1] && arr[i][j-1]==arr[i-1][j-1] && arr[i-1][j-1]==0) {
							ans[i][j] = 1+Math.min(ans[i-1][j], Math.min(ans[i][j-1], ans[i-1][j-1]));
						}else if(arr[i-1][j] == arr[i][j-1] && arr[i][j-1]==arr[i-1][j-1] && arr[i-1][j-1]==1) {
							ans[i][j]=1;
						}
						
						else {
							ans[i][j] = 1;
						}
						ans1 = Math.max(ans[i][j],ans1);
						if(ans1 ==7) {
							System.out.println(i + " " + j);
						}
					}
				}
			}
//			for(int i=0;i<arr.length;i++) {
//				for(int j=0;j<arr[0].length;j++) {
//					System.out.print(ans[i][j]);
//				}
//				System.out.println();
//			}
	        return ans1;
		}

	

}
