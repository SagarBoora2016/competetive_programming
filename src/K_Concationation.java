import java.util.*;
public class K_Concationation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases-->0) {
			int n =sc.nextInt();
			int k=sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int curr_sum=0;
			int best_sum=0;
			for(int i=0;i<n;i++) {
				curr_sum+=best_sum;
				if(best_sum<curr_sum) {
					best_sum = curr_sum;
				}
				if(curr_sum<0) {
					curr_sum=0;
				}
			}
			
			
			if(k>=2) {
				int p_sum = getP(arr,n);
				int s_sum = getS(arr,n);
				int mySum=0;
				for(int i=0;i<n;i++) {
					mySum+=arr[i];
				}
				if(mySum>=0) {
					System.out.println(Math.max(best_sum, p_sum+s_sum + (k-2) * mySum));
				}else {
					System.out.println(Math.max(best_sum, p_sum+s_sum));
				}
				
			}else {
				System.out.println(best_sum);
			}
		
			//System.out.println(best_sum);
		}
	}

	private static int getS(int[] arr, int n) {
		// TODO Auto-generated method stub
		int curr_sum=0;
		int best_sum=0;
		int i=0;
		while(i<n) {
			curr_sum +=arr[i];
			if(best_sum<curr_sum) {
				best_sum = curr_sum;
			}
			i++;
		}
		return best_sum;
	}

	private static int getP(int[] arr, int n) {
		// TODO Auto-generated method stub
		int curr_sum=0;
		int best_sum=0;
		int i=n-1;
		while(i>=0) {
			curr_sum+=arr[i];
			i--;
			if(best_sum<curr_sum) {
				best_sum = curr_sum;
			}
		}
		return best_sum;
	}

}
