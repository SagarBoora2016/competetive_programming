package dybamic2;

import java.util.Scanner;

public class Party {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int budget = sc.nextInt();
			int n = sc.nextInt();
			if(budget==0 && n==0) {
				break;
			}else {
				int cost[] = new int[n];
				int fun[] = new int[n];
				int index=0;
				while(n-->0) {
					cost[index] = sc.nextInt();
					fun[index++] = sc.nextInt();
				}
			//	A a = get(cost,fun,budget,0,0,0);
				int arr[][] = new int[cost.length+1][budget+1];
				int wt[][] = new int[cost.length+1][budget+1];
				for(int i=1;i<arr.length;i++) {
					for(int j=1;j<arr[0].length;j++) {
						arr[i][j] = arr[i-1][j];
						wt[i][j] = wt[i-1][j];
						//System.out.println(i + " "+ j + " " + (i-cost[j-1]));
						if(j-cost[i-1]>=0) {
							if(arr[i][j]<fun[i-1] +arr[i-1][j-cost[i-1]]) {
								arr[i][j] =  fun[i-1] + arr[i-1][j-cost[i-1]];
								wt[i][j] = cost[i-1] + wt[i-1][j-cost[i-1]];
							}
						}
					}
				}
				
				System.out.println( wt[cost.length][budget] + " " + arr[cost.length][budget]);
			}
		}
		//sc.close();
	}
	private static A get(int[] cost, int[] fun, int budget,int sumCost,int sumFun, int index) {
		// TODO Auto-generated method stub
	//	System.out.println(index + " " + fun.length);
		if(index>=fun.length) {
			A a  = new A();
			a.cost=sumCost;
			a.fun = sumFun;
			return a;
		}
		A a1 = get(cost,fun,budget,sumCost,sumFun,index+1);
		A a2 = new A();
		if(budget-cost[index]>=0) {
			a2 =  get(cost,fun,budget-cost[index],sumCost+cost[index],sumFun + fun[index],index+1);
		}
		A a3 = new A();
		
		 if(a1.fun<a2.fun) {
			 a3=a2;
		 }else {
			 a3=a1;
		 }
		//System.out.println(ans  + " " + index);
		return a3;
	}
}
class A{
	int cost;
	int fun;
}