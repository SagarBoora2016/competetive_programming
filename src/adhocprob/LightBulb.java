package adhocprob;

import java.util.Scanner;

public class LightBulb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        long x = sc.nextLong();
        long y = sc.nextLong();
        String s = sc.next();
        int number=0;
        if(n==0){
            System.out.println(0);
            return;
        }
        if(n==1){
            if(s.charAt(0)=='0'){
                System.out.println(y);
            }else{
                System.out.println(0);
            }
            return;
        }
        char prevBit = s.charAt(0);
        if(s.charAt(0)=='0'){
            number++;
        }
        char currBit=s.charAt(1);
        for(int i=1;i<s.length();i++){
            if(prevBit=='1' && currBit=='0'){
                number++;
            }
            prevBit = currBit;
            currBit = s.charAt(i);
        }
         if(prevBit=='1' && currBit=='0'){
                number++;
        }
        long ans=0;
        if(number==0){
            
        }else{
            ans = Math.min(x,y)*(number-1) + y;
        }
        System.out.println(ans);
	}

}
