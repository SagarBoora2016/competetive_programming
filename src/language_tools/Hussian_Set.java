package language_tools;
import java.util.*;
public class Hussian_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int query [] = new int[q];
		for(int i=0;i<q;i++) {
			query[i]=sc.nextInt();
		}
		int i=1;
		int last = query[q-1];
		int index=0;
		Arrays.sort(arr);
		int j=n-1;
		Queue<Integer> queue = new LinkedList<>();
		while(i<=last) {
		//	System.out.println( i + " hhh  " + last + "    " + " a1 " );
			int a1=0,a2=0;
			if(!queue.isEmpty()) {
				a1 = queue.peek();
			}
			if(j>=0) {
				a2=arr[j];
			}
			//System.out.println(" a1= " +a1+ " a2= " + a2 + " ");
			if(a1>a2) {
				queue.remove();
				int ans = a1/2;
				if(i==query[index]) {
					index++;
					System.out.println(a1);// + " i " + i + " " + ans);
					if(ans>0) {
						queue.add(ans);
					}
				}
			}
			if(a2>=a1 && a2!=0) {
				j--;
				int ans=a2/2;
				if(query[index]==i) {
					System.out.println(a2);// + " i " + i + " " + ans);
					index++;
				}
				if(a2!=0) {
					queue.add(ans);
					
				}
			}
			i++;
		}
	}

}
