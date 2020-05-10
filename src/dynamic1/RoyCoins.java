package dynamic1;

import java.util.Scanner;

public class RoyCoins {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[1000000+1];
		int m = sc.nextInt();
		while(m-->0) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
            a1--;
            a2--;
            
			int min = Math.min(a1, a2);
			int max = Math.max(a1, a2);
			arr[min] = arr[min]+1;
			if(max+1<n) {
				arr[max+1] = arr[max+1]-1;
			}
		}
		int q = sc.nextInt();
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			arr[i]=sum;
            //System.out.print(arr[i] + " ");
		}
        System.out.println();
        int ansarr[] = new int[1000000+1];
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                continue;
            }
            ansarr[arr[i]]++; 
          
        }
      //  System.out.print(ansarr[0] + " ");
         for(int i=1;i<n;i++){
         //   ansarr[arr[i]]++; 
            ansarr[i] = ansarr[i-1] + ansarr[i];
            // System.out.print(ansarr[i] + " ");
        }
        int max=ansarr[n-1];
		while(q-->0) {
			int a= sc.nextInt();
			int ans=0;
		    if(a==0){
                ans=max;
            }else if(ansarr[n-1]>max){
                ans=0;
            }
            else{
                ans = max-ansarr[a-1];
            }
			System.out.println(ans);
		}
	}
}