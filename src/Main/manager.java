package Main;

import java.util.Scanner;

import Interface.serviceImpl;

public class manager {
	private Scanner in = new Scanner(System.in); 
	private serviceImpl sv = new serviceImpl();
	
	public manager() {
		int no =-1;
		while(true) {
			menu();
			no = in.nextInt();
			in.nextLine();
			
			switch(no) {
			case 1: consumerlist(); break;
			case 2: clean(); break;
			default : break;
			}
			
		}

	}
	private void clean() {
		System.out.println("--물품정리--");
		int no= -1;
		while(true) {
			sv.treelist();
			System.out.println("1.물품삭제");
			System.out.println("2.물품수정");
			System.out.println("3.재   고 ");
			System.out.println("4.이   전 ");
			no = in.nextInt();
			in.nextLine();
			
			switch(no) {
			case 1: deletetree(); break;
			case 2: updatetree(); break;
			case 3: xlist(); break;
			default : break;
			}
			
		}
		
	}
	private void xlist() {
		sv.stocktree();
		
	}
	private void updatetree() {
		// TODO Auto-generated method stub
		sv.uptree();
	}
	private void deletetree() {
		// TODO Auto-generated method stub
		sv.deltree();
	}
	private void consumerlist() {
		System.out.println("--고객리스트--");
		sv.conlist();
		
		
	}
	private void menu() {
		System.out.println("---관리자용---");
		System.out.println("1.고객리스트");
		System.out.println("2. 물품정리 ");
		System.out.println("3. 이     전  ");
		
		
	}
}
