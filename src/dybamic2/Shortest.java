package dybamic2;

import java.util.Scanner;

public class Shortest {

public static void main(String[] args) {
		
		String S,V;
		
		Scanner scan = new Scanner(System.in);
		
		S = scan.next();
		V = scan.next();
		System.out.println(new Shortest().solve(S,V));

	}
	
	 static final int MAX = 1005; 
	  
	    // Returns length of shortest common subsequence  
	    static int solve(String S, String T)  
	    { 
	        int m = S.length(), n = T.length(); 
	  
	        // declaring 2D array of m + 1 rows and  
	        // n + 1 columns dynamically  
	        int dp[][] = new int[m + 1][n + 1]; 
	  
	        // T string is empty  
	        for (int i = 0; i <= m; i++)  
	        { 
	            dp[i][0] = 1; 
	        } 
	  
	        // S string is empty  
	        for (int i = 0; i <= n; i++) 
	        { 
	            dp[0][i] = MAX; 
	        } 
	  
	        for (int i = 1; i <= m; i++)  
	        { 
	            for (int j = 1; j <= n; j++)  
	            { 
	                char ch = S.charAt(i - 1); 
	                int k; 
	                for (k = j - 1; k >= 0; k--) 
	                { 
	                    if (T.charAt(k) == ch) 
	                    { 
	                        break; 
	                    } 
	                } 
	  
	                // char not present in T  
	                if (k == -1)  
	                { 
	                    dp[i][j] = 1; 
	                }  
	                else
	                { 
	                    dp[i][j] = Math.min(dp[i - 1][j], 
	                                    dp[i - 1][k] + 1); 
	                } 
	            } 
	        } 
	  
	        int ans = dp[m][n]; 
	        if (ans >= MAX)  
	        { 
	            ans = -1; 
	        } 
	        return ans; 
	    } 
	

}
