import java.util.*;
public class Even_Odd_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int evenSum=0;
		int oddSum=0;
		for(int i=0;i<n;i++) {
			if(i%2==1 && arr[i]%2==1) {
				evenSum+=arr[i];
			}
			if(i%2==0 && arr[i]%2==0) {
				oddSum+=arr[i];
			}
		}
		System.out.println(evenSum + " " + oddSum);
	}

}
