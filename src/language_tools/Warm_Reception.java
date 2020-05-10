package language_tools;
import java.util.*;
public class Warm_Reception {
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			A arr[] = new A[n];
			ArrayList<Integer> edTimeList = new ArrayList<>();
			ArrayList<Integer> stTimeList = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				arr[i] = new A();
				arr[i].stTime = sc.next();
				stTimeList.add(Integer.parseInt(arr[i].stTime));
			}
			for(int i=0;i<n;i++) {
				arr[i].edTime = sc.next();
				//edTimeList.add(Integer.parseInt(arr[i].edTime));
			}
			int count=1;
			Arrays.sort(arr);
//			for(int i=0;i<n;i++) {
//				System.out.println(arr[i].stTime);
//			}
//			
			int mySt = Integer.parseInt(arr[0].stTime);
			int myEd = Integer.parseInt(arr[0].edTime);
			int maxCount=1;
			for(int i=1;i<n;i++) {
				count=1;
				for(int j=i-1;j>=0;j--) {
					if(Integer.parseInt(arr[i].stTime) < Integer.parseInt(arr[j].edTime)) {
						count++;
					}
				}
				if(maxCount< count) {
					maxCount = count;
				}
			}
			System.out.println(maxCount);
		}

	}
	class A implements Comparable<A>{
		String stTime;
		String edTime;
		public int compareTo(A a) {
			if(this.stTime.equals(a.stTime)) {
				return Integer.parseInt(this.edTime) - Integer.parseInt(a.edTime);
			}else {
				return Integer.parseInt(this.stTime) - Integer.parseInt(a.stTime);
			}
		}
	}