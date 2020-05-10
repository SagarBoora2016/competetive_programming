package greedyTecj;

import java.util.Arrays;
import java.util.Scanner;

public class FracktionalKnap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		Worker[] work= new Worker[n];
		for(int i=0;i<n;i++) {
			work[i] = new Worker();
			work[i].time = sc.nextInt();
			work[i].cost = sc.nextInt();
			work[i].speed=sc.nextInt();
		}
		Arrays.sort(work);
		long cost=work[0].cost;
		int index=1;
		int speed=work[0].speed;
		int maxInd=0;
		while(d>0) {
			if(speed<work[index].speed) {
				speed = work[index].speed;
				cost = cost+work[index].cost;
				maxInd = index;
			}
			d=d-work[maxInd].speed;
			index++;
		}
		System.out.println(cost);
	}	
}
class Worker implements Comparable<Worker>{
	int time;
	int cost;
	int speed;
	public int compareTo(Worker w) {
		
		
		if(this.time == w.time) {
			if(this.speed==w.speed) {
				return this.cost - w.cost;
			}else {
				return	w.speed - this.speed;
			}
		}
		else {
			return this.time - w.time;
		}
	}
}
