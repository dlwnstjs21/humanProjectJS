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
	public void joinuser() {//ȸ������
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

			uudao.insertuser(id,name,addr);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		}
	}

	@Override
	public void treelist() {//���� ����Ʈ
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
	public void basketbuy() {//�����ϱ�
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
	public void bbuylist() {//�����Ѹ�Ϻ���
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

	@Override
	public void uptree() {
		treelist();
		String treeid = null;
		int tcnt = -1;
		Scanner in = new Scanner(System.in);
		treedto tdto = new treedto();
		System.out.println("������ ���� id �� �Է����ּ���.");
		treeid =in.nextLine();
		tdto.setTid(treeid);
		System.out.println("�� ������ �Է����ּ���");
		tcnt =in.nextInt();
		in.nextLine();
		tdto.setCnt(tcnt);
		
		ttdao.updatetreecnt(tcnt, treeid);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
		
		
		
		
	}

	@Override
	public void deltree() {
		treelist();
		String treeid = null;
		Scanner in = new Scanner(System.in);
		treedto tdto = new treedto();
		System.out.println("������ ���� id �� �Է����ּ���.");
		treeid =in.nextLine();
		tdto.setTid(treeid);
		
		ttdao.deletetree(treeid);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
	}

	@Override
	public void conlist() {
		ArrayList<consumerdto> clist = uudao.selectAllconsumer();
		System.out.println("ȸ�� ����Դϴ�.");
		for (int i = 0; i < clist.size(); i++) {
				consumerdto ccdto = new consumerdto();
				ccdto = clist.get(i);
				System.out.println(" ȸ�� id : " + ccdto.getUid());
				System.out.println(" ȸ�� �̸�: " + ccdto.getUname());
				System.out.println(" ��   ��   : " + ccdto.getAddr());
		}		
	}

	@Override
	public void stocktree() {
		ArrayList<treedto> list = ttdao.selectAll();
		System.out.println("��� ��� �Դϴ�.");
		treelist();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getCnt()==0) {
				treedto tempdto = new treedto();
				tempdto = list.get(i);
				System.out.println("���� ��� 0�� ��ǰ : ��ǰid :"+tempdto.getTid()+"��ǰ �̸�:"+tempdto.getTname());
			}else {
				System.out.println("��� 0���� ��ǰ�� �����ϴ�.");
			}
		}
		
	}

	@Override
	public void instree() {
		int cnt = -1;
		String id = null;
		String name = null;
		String info = null;
		System.out.println("---�������---");
		Scanner in = new Scanner(System.in);
			treedto tdto = new treedto();
			System.out.println("���� id�� �Է����ּ���");
			id = in.nextLine();
			tdto.setTid(id);
			System.out.println("���� �̸��� �Է����ּ���");
			name = in.nextLine();
			tdto.setTname(name);
			System.out.println("���� ������ �Է����ּ���.");
			info = in.nextLine();
			tdto.setInfo(info);
			System.out.println("������ �Է����ּ���.");
			cnt = in.nextInt();
			in.nextLine();
			tdto.setCnt(cnt);

			ttdao.inserttree(id, name, info, cnt);
			System.out.println("�����  �Ϸ�Ǿ����ϴ�.");
		
	}


}
