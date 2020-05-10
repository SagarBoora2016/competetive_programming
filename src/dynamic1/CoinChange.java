package dynamic1;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int numDenominations = s.nextInt();
		int denominations[] = new int[numDenominations];
		for(int i = 0; i < numDenominations; i++){
			denominations[i] = s.nextInt();
		}
		
		int value = s.nextInt();
		
		System.out.println(CoinChange.countWaysToMakeChange(denominations, value));
		
	}
	
	public static int countWaysToMakeChange(int denominations[], int value){

		return get(denominations,value,0);

	}

	private static int get(int[] denominations, int value, int index) {
		// TODO Auto-generated method stub
		int arr[][] = new int[denominations.length+1][value+1];
		for(int i=0;i<value+1;i++) {
			arr[0][i]=0;
		}
		for(int i=0;i<denominations.length+1;i++) {
			arr[i][0]=1;
		}
		for(int i=1;i<denominations.length+1;i++) {
			for(int j=1;j<value+1;j++) {
				if(denominations[i-1] > j) {
					arr[i][j] = arr[i-1][j];
				}else {
					arr[i][j] = arr[i][j-denominations[i-1]] + arr[i-1][j] ;
				}
			}
		}
		return arr[denominations.length][value];
	}

}
