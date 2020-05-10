package dynamic1;

import java.util.Scanner;

public class MinimumCholo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);  
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		System.out.println(MinimumCholo.getMin(arr, N));
	}
	
	public static int getMin(int arr[], int N){
		int ans[] = new int[arr.length];
        ans[0]=1;
        for(int i=1;i<N;i++){
            if(arr[i]>arr[i-1]){
                ans[i] = 1+ans[i-1];
            }else{
                ans[i]=1;
            }
        }
        for(int i=N-2;i>=0;i--){
            if(arr[i]>arr[i+1] && ans[i] <=ans[i+1] ){
                ans[i]=1+ans[i+1];
            }
        }
        int a1=0;
        for(int i=0;i<N;i++){
            a1+=ans[i];
        }
		return a1;
  }
	
}
