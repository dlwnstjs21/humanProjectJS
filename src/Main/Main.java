package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int no =-1;
		System.out.println("고객은 1번 ,관리자는 2번");
		while(true) {
			no =in.nextInt();
			in.nextLine();
			
			switch(no) {
			case 1: new shop(); break;
			case 2: new manager(); break;
				default : break;
			}
		}
	}

}

