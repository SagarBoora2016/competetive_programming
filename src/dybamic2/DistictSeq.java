package dybamic2;
import java.util.*;
public class DistictSeq {

	
	 static final int MAX_CHAR = 256; 
	  static int m = 1000000000+7;
	     
	    // Returns count of distinct sunsequences of str. 
	    static long countSub(String str) 
	    { 
	        // Create an array to store index 
	        // of last 
	        int[] last = new int[MAX_CHAR]; 
	        Arrays.fill(last, -1); 
	          
	        // Length of input string 
	        int n = str.length(); 
	       
	        // dp[i] is going to store count of distinct 
	        // subsequences of length i. 
	        long[] dp = new long[n+1]; 
	       
	        // Empty substring has only one subsequence 
	        dp[0] = 1; 
	       
	        // Traverse through all lengths from 1 to n. 
	        for (int i=1; i<=n; i++) 
	        { 
	            // Number of subsequences with substring 
	            // str[0..i-1] 
	            long a =  ((long)dp[i-1]%m + dp[i-1]%m)%m; 
	            dp[i]=(int) a;
	            // If current character has appeared 
	            // before, then remove all subsequences 
	            // ending with previous occurrence. 
	            if (last[(int)str.charAt(i-1)] != -1) 
	                dp[i] = (dp[i]%m - dp[last[(int)str.charAt(i-1)]]%m)%m; 
	       
	            // Mark occurrence of current character 
	            last[(int)str.charAt(i-1)] = (i-1); 
	        } 
	       
	        return dp[n]; 
	    } 
	    // Driver code 
	    public static void main(String args[]) 
	    { 
	    	Scanner sc = new Scanner(System.in);
	    	int cases = sc.nextInt();
	    	while(cases-->0) {
	    		String s = sc.next();
	    		System.out.println(countSub("AAA"));
	    	}
	        
	    } 
	
	
	
}
