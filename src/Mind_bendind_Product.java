import java.util.Scanner;

public class Mind_bendind_Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int ansArr[] = new int[n];
		ansArr[0] = 1;
		for(int i=1;i<n;i++) {
			ansArr[i] = arr[i-1]* ansArr[i-1];
		}
		int rightPrr=1;
		for(int i=0;i<n;i++) {
			System.out.print(ansArr[i] + " ");
		}
		System.out.println();
		for(int i=n-1;i>=0;i--) {
			ansArr[i] = ansArr[i]* rightPrr;
			rightPrr = arr[i]*rightPrr;
		}
		for(int i=0;i<n;i++) {
			System.out.print(ansArr[i] + " ");
		}
	}
}
