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
		System.out.println("---회원가입---");
		Scanner in = new Scanner(System.in);
		System.out.println("회원가입하시려면 1 번을 돌아가시려면 2번을 입력해주세요.");
		no = in.nextInt();
		in.nextLine();
		if (no == 1) {
			consumerdto udto = new consumerdto();
			System.out.println("id를 입력해주세요");
			id = in.nextLine();
			udto.setUid(id);
			System.out.println("name 을 입력해주세요");
			name = in.nextLine();
			udto.setUname(name);
			System.out.println("주소를 입력해주세요");
			addr = in.nextLine();
			udto.setAddr(addr);

			uudao.insertuser(udto);
			System.out.println("가입이 완료되었습니다.");

		}
	}

	@Override
	public void treelist() {
		// TODO Auto-generated method stub
		ArrayList<treedto> list = ttdao.selectAll();
		System.out.println("나무목록입니다");
		for (int i = 0; i < list.size(); i++) {
			treedto tempdto = new treedto();
			tempdto = list.get(i);
			System.out.println("제품번호: " + tempdto.getTid());
			System.out.println("나무이름: " + tempdto.getTname());
			System.out.println("나무정보: " + tempdto.getInfo());
			System.out.println("수     량: " + tempdto.getCnt());
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
		System.out.println("구매를 하시려면 1, 없으면 2 을 입력하세요");
		int no = in.nextInt();
		in.nextLine();
		if (no == 1) {
			basketdto bdto = new basketdto();
			System.out.println("userid 를입력하세요");
			userid = in.nextLine();
			bdto.setUid(userid);
			System.out.println("구매할 나무 id 를입력하세요 ");
			treeid = in.nextLine();
			bdto.setTid(treeid);
			System.out.println("구매할 수량을 입력하세요");
			scnt = in.nextInt();
			in.nextLine();
			bdto.setCnt(scnt);

			bbdao.insertbuy(bdto);
			ttdao.updatetreecnt(scnt, treeid);
			System.out.println("구매가 완료되었습니다.");
		}

	}
	@Override
	public void bbuylist() {
		ArrayList<basketdto> list = bbdao.basketlist();
		System.out.println("구매목록입니다.");
		for (int i = 0; i < list.size(); i++) {
			basketdto bbbdto = new basketdto();
			bbbdto = list.get(i);
			System.out.println("구매자id : " + bbbdto.getUid());
			System.out.println("구매한나무: " + bbbdto.getTid());
			System.out.println(" 수    량  : " + bbbdto.getCnt());
		}
	}

}
