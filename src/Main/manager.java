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
		System.out.println("--��ǰ����--");
		int no= -1;
		while(true) {
			sv.treelist();
			System.out.println("1.��ǰ����");
			System.out.println("2.��ǰ����");
			System.out.println("3.��   �� ");
			System.out.println("4.��   �� ");
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
		System.out.println("--������Ʈ--");
		sv.conlist();
		
		
	}
	private void menu() {
		System.out.println("---�����ڿ�---");
		System.out.println("1.������Ʈ");
		System.out.println("2. ��ǰ���� ");
		System.out.println("3. ��     ��  ");
		
		
	}
}
