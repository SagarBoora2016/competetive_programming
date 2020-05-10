package backtacking;

import java.util.Scanner;

public class CrosswordPuzzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char crossWord[][] = new char[10][10];
		for(int i=0;i<10;i++) {
			String s = sc.next();
			for(int j=0;j<10;j++) {
				crossWord[i][j] = s.charAt(j);
				System.out.print(crossWord[i][j]);
			}
			System.out.println();
		}
		String tofill[] = sc.next().split(";");
		if(fillMyCrossword(crossWord,tofill)) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					System.out.print(crossWord[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static boolean fillMyCrossword(char[][] crossWord, String[] tofill) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(crossWord[i][j]=='-' || crossWord[i][j]!='+') {
					if(crossWord[i][j]=='-') {
						if(canFillVertical(crossWord,tofill,i,j)) {
							int r=i;
							int c=j;
							int length=0;
							while(r<10 && c<10 && crossWord[i][j]!='+') {
								r++;
								c++;
								length++;
							}
							for(int k=0;k<tofill.length;k++) {
								if(length>=tofill[k].length()) {
									r=i;
									for(int l =r;l<tofill[k].length();l++) {
										crossWord[r][j]=tofill[k].charAt(l);
									}
									if(fillMyCrossword(crossWord, tofill)) {
										return true;
									}
									for(int l =r;l<tofill[k].length();l++) {
										crossWord[r][j]=tofill[k].charAt(l);
									}
								}
							}
							
							resetVertical(crossWord,tofill,i,j);
						}
						if(canFillHorizental(crossWord,tofill,i,j)) {
							fillHorizental(crossWord,tofill,i,j);
							if(fillMyCrossword(crossWord, tofill)) {
								return true;
							}
							resetHorizental(crossWord,tofill,i,j);
						}
					}else {
						for(int k=0;k<tofill.length;k++) {
							if(crossWord[i][j] == tofill[k].charAt(0)) {
								
							}
						}
					}
				}
			}
		}
		return true;
	}

	private static void fillVertical(char[][] crossWord, String[] tofill, int r, int c) {
		// TODO Auto-generated method stub
		int length=0;
		int i=r;
		int j=c;
		while(i<10 && j<10 && crossWord[i][j]!='+') {
			length++;
			++i;
			++j;
		}
		for(int k=0;k<tofill.length;k++) {
			if(tofill[k].length() <= length) {
				return true;
			}
		}
		
	}

	private static boolean canFillVertical(char[][] crossWord, String[] tofill, int r, int c) {
		// TODO Auto-generated method stub
		int length=0;
		int i=r;
		int j=c;
		while(i<10 && j<10 && crossWord[i][j]!='+') {
			length++;
			++i;
			++j;
		}
		for(int k=0;k<tofill.length;k++) {
			if(tofill[k].length() <= length) {
				return true;
			}
		}
		return false;
	}
}
