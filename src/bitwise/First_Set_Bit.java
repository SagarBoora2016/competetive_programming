package bitwise;

import java.util.Scanner;

public class First_Set_Bit {

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
	        System.out.print(1<<pow);
		
	}

}
