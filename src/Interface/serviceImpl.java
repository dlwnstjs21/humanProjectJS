package Interface;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.basketdao;
import DAO.treedao;
import DAO.consumerdao;
import DTO.basketdto;
import DTO.treedto;
import DTO.consumerdto;

public class serviceImpl implements service {
	private treedao ttdao = new treedao();
	private basketdao bbdao = new basketdao();
	private consumerdao uudao = new consumerdao();

	@Override
	public void joinuser() {
		// TODO Auto-generated method stub
		int no = -1;
		String id = null;
		String name = null;
		String addr = null;
		System.out.println("---ȸ������---");
		Scanner in = new Scanner(System.in);
		System.out.println("ȸ�������Ͻ÷��� 1 ���� ���ư��÷��� 2���� �Է����ּ���.");
		no = in.nextInt();
		in.nextLine();
		if (no == 1) {
			consumerdto udto = new consumerdto();
			System.out.println("id�� �Է����ּ���");
			id = in.nextLine();
			udto.setUid(id);
			System.out.println("name �� �Է����ּ���");
			name = in.nextLine();
			udto.setUname(name);
			System.out.println("�ּҸ� �Է����ּ���");
			addr = in.nextLine();
			udto.setAddr(addr);

			uudao.insertuser(udto);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		}
	}

	@Override
	public void treelist() {
		// TODO Auto-generated method stub
		ArrayList<treedto> list = ttdao.selectAll();
		System.out.println("��������Դϴ�");
		for (int i = 0; i < list.size(); i++) {
			treedto tempdto = new treedto();
			tempdto = list.get(i);
			System.out.println("��ǰ��ȣ: " + tempdto.getTid());
			System.out.println("�����̸�: " + tempdto.getTname());
			System.out.println("��������: " + tempdto.getInfo());
			System.out.println("��     ��: " + tempdto.getCnt());
		}

	}

	@Override
	public void basketbuy() {
		// TODO Auto-generated method stub
		treelist();
		String userid = null;
		String treeid = null;
		int scnt = -1;
		Scanner in = new Scanner(System.in);
		System.out.println("���Ÿ� �Ͻ÷��� 1, ������ 2 �� �Է��ϼ���");
		int no = in.nextInt();
		in.nextLine();
		if (no == 1) {
			basketdto bdto = new basketdto();
			System.out.println("userid ���Է��ϼ���");
			userid = in.nextLine();
			bdto.setUid(userid);
			System.out.println("������ ���� id ���Է��ϼ��� ");
			treeid = in.nextLine();
			bdto.setTid(treeid);
			System.out.println("������ ������ �Է��ϼ���");
			scnt = in.nextInt();
			in.nextLine();
			bdto.setCnt(scnt);

			bbdao.insertbuy(bdto);
			ttdao.updatetreecnt(scnt, treeid);
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
		}

	}
	@Override
	public void bbuylist() {
		ArrayList<basketdto> list = bbdao.basketlist();
		System.out.println("���Ÿ���Դϴ�.");
		for (int i = 0; i < list.size(); i++) {
			basketdto bbbdto = new basketdto();
			bbbdto = list.get(i);
			System.out.println("������id : " + bbbdto.getUid());
			System.out.println("�����ѳ���: " + bbbdto.getTid());
			System.out.println(" ��    ��  : " + bbbdto.getCnt());
		}
	}

}
