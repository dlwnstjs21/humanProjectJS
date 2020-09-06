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
			no =in.nextInt();
			in.nextLine();
			
			switch(no) {
			case 1: join();
			case 2: treelist();
			case 3: buy();
			case 4: buybasket();
			default : break;
			}
		}
	}
	private void buybasket() {
		// TODO Auto-generated method stub
		sv.bbuylist();
	}
	private void buy() {
		// TODO Auto-generated method stub
		sv.basketbuy();
	}
	private void treelist() {
		// TODO Auto-generated method stub
		sv.treelist();
	}
	private void join() {
		// TODO Auto-generated method stub
		sv.joinuser();
	}
	private void mene() {
		System.out.println("---고객용---");
		System.out.println("1.회원가입");
		System.out.println("2.나무목록");
		System.out.println("3.구매하기 ");
		System.out.println("4.장바구니 ");
		System.out.println("5.종     료  ");
		// TODO Auto-generated method stub
		
	}
}
