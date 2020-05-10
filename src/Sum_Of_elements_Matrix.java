import java.util.*;
public class Sum_Of_elements_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[0][i];
		}
		for(int i=0;i<n;i++) {
			sum+=arr[i][n-1];
		}
		for(int i=0;i<n;i++) {
			sum+=arr[n-1][i];
		}
		for(int i=0;i<n;i++){
			sum+=arr[i][0];
		}
		sum= sum-arr[0][0]-arr[n-1][0] - arr[0][n-1] - arr[n-1][n-1];
		for(int i=1;i<n-1;i++) {
			sum+=arr[i][i];
		}
		for(int i=n-2;i>0;i--) {
			sum+=arr[n-i-1][i];
		}
		if(n%2!=0) {
			sum=sum-arr[n/2][n/2];
		}
		System.out.println(sum);
	}

}
