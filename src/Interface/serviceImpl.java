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
	public void joinuser() {//회원가입
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

			uudao.insertuser(id,name,addr);
			System.out.println("가입이 완료되었습니다.");

		}
	}

	@Override
	public void treelist() {//나무 리스트
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
	public void basketbuy() {//구매하기
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
	public void bbuylist() {//구매한목록보기
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

	@Override
	public void uptree() {
		treelist();
		String treeid = null;
		int tcnt = -1;
		Scanner in = new Scanner(System.in);
		treedto tdto = new treedto();
		System.out.println("수정할 나무 id 를 입력해주세요.");
		treeid =in.nextLine();
		tdto.setTid(treeid);
		System.out.println("뺄 수량을 입력해주세요");
		tcnt =in.nextInt();
		in.nextLine();
		tdto.setCnt(tcnt);
		
		ttdao.updatetreecnt(tcnt, treeid);
		System.out.println("수정이 완료되었습니다.");
		
		
		
		
		
	}

	@Override
	public void deltree() {
		treelist();
		String treeid = null;
		Scanner in = new Scanner(System.in);
		treedto tdto = new treedto();
		System.out.println("삭제할 나무 id 를 입력해주세요.");
		treeid =in.nextLine();
		tdto.setTid(treeid);
		
		ttdao.deletetree(treeid);
		System.out.println("삭제가 완료되었습니다.");
		
	}

	@Override
	public void conlist() {
		ArrayList<consumerdto> clist = uudao.selectAllconsumer();
		System.out.println("회원 목록입니다.");
		for (int i = 0; i < clist.size(); i++) {
				consumerdto ccdto = new consumerdto();
				ccdto = clist.get(i);
				System.out.println(" 회원 id : " + ccdto.getUid());
				System.out.println(" 회원 이름: " + ccdto.getUname());
				System.out.println(" 주   소   : " + ccdto.getAddr());
		}		
	}

	@Override
	public void stocktree() {
		ArrayList<treedto> list = ttdao.selectAll();
		System.out.println("재고 목록 입니다.");
		treelist();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getCnt()==0) {
				treedto tempdto = new treedto();
				tempdto = list.get(i);
				System.out.println("현재 재고가 0인 물품 : 제품id :"+tempdto.getTid()+"제품 이름:"+tempdto.getTname());
			}else {
				System.out.println("재고가 0개인 제품이 없습니다.");
			}
		}
		
	}

	@Override
	public void instree() {
		int cnt = -1;
		String id = null;
		String name = null;
		String info = null;
		System.out.println("---나무등록---");
		Scanner in = new Scanner(System.in);
			treedto tdto = new treedto();
			System.out.println("나무 id를 입력해주세요");
			id = in.nextLine();
			tdto.setTid(id);
			System.out.println("나무 이름을 입력해주세요");
			name = in.nextLine();
			tdto.setTname(name);
			System.out.println("나무 정보를 입력해주세요.");
			info = in.nextLine();
			tdto.setInfo(info);
			System.out.println("수량을 입력해주세요.");
			cnt = in.nextInt();
			in.nextLine();
			tdto.setCnt(cnt);

			ttdao.inserttree(id, name, info, cnt);
			System.out.println("등록이  완료되었습니다.");
		
	}


}
