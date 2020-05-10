package dynamic1;

import java.util.*;

public class AjdacenBits {
		static int m = 1000000000+7;
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
			int cases = sc.nextInt();
			while(cases-->0) {
				int i= sc.nextInt();
				int n = sc.nextInt();
				int k = sc.nextInt();
				long arr[][][] = new long[n+1][k+1][2];
				arr[1][0][0]=1;
				arr[1][0][1]=1;
				for(int j=2;j<=n;j++) {
					arr[j][0][0] = (arr[j-1][0][1]%m + arr[j-1][0][0]%m)%m; 
					arr[j][0][1]=arr[j-1][0][0]%m;
				}
				for(int j=2;j<=n;j++) {
					for(int l=1; l<=k;l++) {
						arr[j][l][0] = (arr[j-1][l][0]%m + arr[j-1][l][1]%m)%m;
						arr[j][l][1] = (arr[j-1][l-1][1]%m + arr[j-1][l][0]%m)%m;
						
					}
				}
//				int ans=f(n,k,0,arr);
//				ans+=f(n,k,1,arr);
				long ans = (arr[n][k][0]%m + arr[n][k][1]%m)%m;
				System.out.println(i + " " +ans);
			}
			sc.close();
		}

		private static long f(int n, int k, int first,long arr[][][]) {
			
			
			// TODO Auto-generated method stub
			if(n<0) {
				return 0;
			}
			if(k<0) {
				return 0;
			}
			
			if(n==1) {
				if(k==0) {
					return 1;
				}else {
					return 0;
				}
			}
	
			
			long ans=0;
			if(first==0) {
				ans =f(n-1,k,0,arr) + f(n-1,k,1,arr);
			}else {
				ans= f(n-1,k-1,1,arr) + f(n-1,k,0,arr);
			}
			arr[n][k][first] = ans;
			return ans;
	        
	    }
	        
		
   
}
