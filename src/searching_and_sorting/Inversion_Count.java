package searching_and_sorting;

public class Inversion_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
long solve(int[] A,int n){
		
		//Write your code here.
		int start = 0;
        int end=n-1;
        long a1= get(A,n,start,end);
        // for(int i=0;i<n;i++){
        //     System.out.print(A[i] + " ");
        // }
        return a1;
	}
    long get(int arr[] ,int n,int start,int end){
        
        if(start>=end){
            return 0;
        }
        int mid= (start+end)/2;
        long x1 = get(arr,n,start,mid);
        long x2 = get(arr,n,mid+1,end);
        return x1 + x2 + get2(arr,n,start,mid,mid+1,end);
        
    }
    
    long get2(int arr[],int n,int start,int mid,int sMid,int end){
        int a1[] =new int[mid-start+1];
        for(int i=0;i<a1.length;i++){
            a1[i] = arr[i+start];
        }
        int a2[] = new int[end-mid];
        for(int i=0;i<a2.length;i++){
            a2[i] = arr[i+sMid];
        }
        int a3[] = new int[a1.length+a2.length];
        int i=0;
        int j=0;
        long count=0;
        int index=0;
        while(i<a1.length && j<a2.length){
            if(a1[i] > a2[j]){
                a3[index++]=a2[j];
                count+=(a1.length-i);
                j++;
            }else{
                a3[index++] = a1[i];
                i++;
            }
        }
        while(i<a1.length){
            a3[index++] = a1[i++];
        }
        while(j<a2.length){
            a3[index++] = a2[j++];
        }
        index=0;
        for(int i1=start;i1<=end;i1++){
            arr[i1] = a3[index++];
        }
        return count;
    }
}
