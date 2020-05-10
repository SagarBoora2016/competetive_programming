package dybamic2;

import java.util.Arrays;
import java.util.Scanner;

public class Knap {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0 ; i < n; i++){
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0 ; i < n; i++){
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(Knap.knapsack(weight, value, maxWeight));
		
	}
	public static int knapsack(int[] weight,int value[],int maxWeight){

		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
			//int ans1=get(weight,value,maxWeight,0);
			int ans2=getIte(weight, value, maxWeight);
			
			//System.out.println( ans2);
			return ans2;
		}
	private static int getIte(int[] weight, int[] value, int maxWeight) {
		// TODO Auto-generated method stub
		 int prev[] = new int[maxWeight+1];
		 int next[] = new int[maxWeight+1];
		 for(int i=0;i<maxWeight+1;i++) {
			 prev[i]=0;
		 }
		 int m = weight.length+1;
		 int n = maxWeight+1;
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				int op1 = prev[j];
				int op2= 0;
				if(j- weight[i-1] >=0) {
					op2 = value[i-1] + prev[j-weight[i-1]];
				}
				next[j] =Math.max(op1, op2); 
			}
			for(int j=0;j<n;j++) {
				prev[j]=next[j];
				//System.out.print(prev[j] + " ");
			}
			//System.out.println();
		}
		return next[n-1];
	}
//	private static int get(int[] weight, int[] value, int maxWeight, int index, int[][] arr, int m, int n) {
//		// TODO Auto-generated method stub
//		if(arr[m][n]>-1) {
//			return arr[m][n];
//		}
//		if(index>=weight.length) {
//			return 0;
//		}
//		
//		int op1 = get(weight,value,maxWeight,index+1);
//		int op2=0;
//		if(maxWeight-weight[index]>=0) {
//			op2 = value[index] + get(weight,value,maxWeight-weight[index],index+1);
//		}
//		arr[m][n] = Math.max(op1, op2);
//		return Math.max(op1, op2);
//	}
//	private static int get(int[] weight, int[] value, int maxWeight, int index) {
//		// TODO Auto-generated method stub
//		if(index>=weight.length) {
//			return 0;
//		}
//		
//		int op1 = get(weight,value,maxWeight,index+1);
//		int op2=0;
//		if(maxWeight-weight[index]>=0) {
//			op2 = value[index] + get(weight,value,maxWeight-weight[index],index+1);
//		}
//		return Math.max(op1, op2);
//	}

}
