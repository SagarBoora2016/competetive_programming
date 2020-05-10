package bitwise;

import java.util.Scanner;

public class Turn_off_1stSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 	Scanner sc = new Scanner(System.in);
	        int n =sc.nextInt();
	        if(n==0){
	            System.out.print(n);
	            return;
	        }
	        int i=1;
	        int pow=0;
	        int k=0;
	        while(k==0){
	            int x=i<<pow;
	            if(n==(n|x)){
	                k++;
	                break;
	            }
	            pow++;
	        }
	        k = 1<<pow;
	        n = n^k;
	        System.out.print(n);
		
	}

}
