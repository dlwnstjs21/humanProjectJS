package Main;

import java.util.Scanner;

import Interface.serviceImpl;

public class shop {
	private Scanner in = new Scanner(System.in);
	private serviceImpl sv = new serviceImpl();
	public shop() {
		int no =-1;
		while(true) {
			mene();
			System.out.println("번호를 고르세요");
			no =in.nextInt();
			in.nextLine();
			
			switch(no) {
			case 1: join(); break;
			case 2: list(); break;
			case 3: buy(); break;
			case 4: buylist(); break;
			default : break;
			}
		}

	}
	private void join() {
		sv.joinuser();
	}
	private void list() {
		sv.treelist();
	}
	private void buy() {
		sv.basketbuy();
	}
	private void buylist() {
		sv.bbuylist();
	}
	private void mene() {
		System.out.println("---tree---");
		System.out.println("1.회원가입");
		System.out.println("2.나무 보기");
		System.out.println("3.구매하기");
		System.out.println("4.구매목록");
		System.out.println("5. 종   료");
		// TODO Auto-generated method stub
		
	}
}
