package dynamic1;

import java.util.*;

public class AlphaCode {


	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
    int m = 1000000000+7;
	while(sc.hasNext()) {
		String s = sc.next();
	//	System.out.println(s);
		if(s.length()==1 && s.charAt(0)=='0') {
			break;
		}
		int ans[] = new int[s.length()+1];
		ans[0] = 1;
		if(s.length()==1) {
			System.out.println(1);
			continue;
		}
		ans[1]= 1;
		for(int i=2;i<=s.length();i++) {
			ans[i] = ans[i-1];
			int a = Integer.parseInt(""+s.charAt(i-2)); 
            int b = Integer.parseInt(""+s.charAt(i-1));
            if(a==0){
                if(b==0){
                    ans[i]=0;
                }
                continue;
            }
            
            int no = 10*a+b;
            if(b==0 && no>26){
                ans[i]=0;
            }
            if(no==10 || no==20){
                continue;
            }
			if(no<=26) {
				ans[i] += ans[i-2];
			}
            ans[i] = ans[i]%m;
		}
		System.out.println(ans[s.length()]);
	}
	}

}
