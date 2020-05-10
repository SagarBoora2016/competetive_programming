package dybamic2;

import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(LIS.lcs(str1, str2));
		
	}
	
	
	public static int lcs(String s1, String s2){
		
        
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		*/
	        int arr[][] = new int[s1.length()+1][s2.length()+1];
	        for(int i=0;i<s1.length()+1;i++){
	           for(int j=0;j<s2.length()+1;j++){
	               arr[i][j]=-1;
	           }
	        }
	        return get(s1,s2,arr,s1.length(),s2.length());

		}
	    public static int get(String s1,String s2,int arr[][],int m,int n){
	        if(m==0|| n==0){
	            return 0;
	        }
	        if(arr[m][n]>=0){
	            return arr[m][n];
	        }
	        if(s1.charAt(0)==s2.charAt(0)){
	            arr[m][n] = 1+ get(s1.substring(1),s2.substring(1),arr,m-1,n-1);
	        }else{
	            int a1 =get(s1.substring(1),s2,arr,m-1,n);
	            int a2=get(s1,s2.substring(1),arr,m,n-1);
	            arr[m][n] = Math.max(a1,a2);
	        }
	        return arr[m][n];
	        
	    }

}
