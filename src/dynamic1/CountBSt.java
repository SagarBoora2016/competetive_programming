package dynamic1;

import java.util.Scanner;

public class CountBSt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans= countTrees(n);
		System.out.println(ans);
	}
    
	static int no=1000000000+7;	
	public static int countTrees(int n) {
	/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		if(n==0||n==1) {
			return 1;
		}
		int ans=0;
		for(int i=1;i<n;i++) {
			ans+=(countTrees(i-1) +countTrees(n-i));
		}
		return ans;
		
	}


}
