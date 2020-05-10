package dybamic2;

import java.util.Scanner;

public class SuperSeq {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		int min_len = SuperSeq.smallestSuperSequence(str1, str2);
		System.out.print(min_len);
	}
	
	
	
	
	public static int smallestSuperSequence(String X, String Y) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
		int m = X.length();
		int n = Y.length();
		
		int[][] dp = new int[m + 1][n + 1]; 
	      
        // Fill table in bottom up manner 
        for (int i = 0; i <= m; i++) 
        { 
            for (int j = 0; j <= n; j++) 
            { 
            // Below steps follow above recurrence 
            if (i == 0) 
                dp[i][j] = j; 
            else if (j == 0) 
                dp[i][j] = i; 
            else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
                    dp[i][j] = 1 + dp[i - 1][j - 1]; 
            else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],  
                                           dp[i][j - 1]); 
            } 
        } 
      
        return dp[m][n]; 
	}
	

}
