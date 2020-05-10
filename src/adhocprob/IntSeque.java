package adhocprob;

import java.util.Arrays;
import java.util.Scanner;

public class IntSeque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int l = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        Arrays.sort(arr);
	        int min =arr[0];
	        int max = arr[n-1];
	        int ans = Integer.MAX_VALUE;
	        for(int i=min;i<=max;i++) {
	        	int inc=0;
	        	int dec=0;
	        	for(int j=0;j<n;j++) {
	        		if(arr[j]>i) {
	        			dec = dec + arr[j]-i;
	        		}else {
	        			inc = inc  + -(arr[j]-i);
	        		}
	        	}
	      //  	System.out.println(inc + " " + dec);
	        	if(dec>inc) {
	        		
	        	}else {
	        		int newCost = dec*k + (inc-dec)*l;
	        		if(ans>newCost) {
	        			ans=newCost;
	        		}
	        	}
	        	 //System.out.println(ans);
	        }
	       System.out.println(ans);
	       sc.close();
	        
	}

}
