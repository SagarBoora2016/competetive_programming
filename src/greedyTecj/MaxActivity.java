package greedyTecj;

import java.util.Arrays;
import java.util.Scanner;

public class MaxActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Activity act [] = new Activity[n];
		for(int i=0;i<n;i++) {
			act[i]= new Activity();
			act[i].startTime = sc.nextLong();
			act[i].finishTime = sc.nextLong();
		}
		Arrays.sort(act);
		long stTime=act[0].startTime;
		long finishTime = act[0].finishTime;
		long times=1;
		for(int i=1;i<n;i++) {
			if(act[i].startTime >= finishTime) {
				times++;
				finishTime = act[i].finishTime;
				
			}
		}
		System.out.println(times);
	}

}
class Activity implements Comparable<Activity>{
	long startTime;
	long finishTime;
	public int compareTo(Activity a) {
		if(finishTime == a.finishTime ) {
			return (int)this.startTime -(int) a.startTime;
		}
		return (int)this.finishTime - (int)a.finishTime;
	}
}