import java.util.*;
public class Max_Prod_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int best_so=0;
		int max_So_far=1;
		int min_so_far=1;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
		//	System.out.println(" i th = " + max_So_far + " " + min_so_far);
			if(arr[i]>0) {
				min_so_far = Math.min(min_so_far*arr[i],1);
				max_So_far = max_So_far*arr[i];
				if(best_so<max_So_far) {
					best_so=max_So_far;
				}
			}else if(arr[i]<0) {
					int temp = max_So_far;
					max_So_far = Math.max(max_So_far, min_so_far*arr[i]);
					min_so_far = Math.min(min_so_far, temp*arr[i]);
				//	System.out.println(min_so_far);
					if(best_so<max_So_far) {
						best_so = max_So_far;
					}
				}else {
					max_So_far=1;
					min_so_far=1;
				}
			}
		
		System.out.println(best_so);
	}

}
