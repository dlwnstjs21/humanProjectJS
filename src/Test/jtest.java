package Test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.treedao;
import DTO.treedto;

public class jtest {
	treedao tdao =null;
	
	@Before
	public void loading() {
		tdao = new treedao();
	}
	@Test
	public void selectAlltree() {
		ArrayList<treedto> tlist = tdao.selectAll();
		for(int i=0; i<tlist.size();i++) {
			System.out.println(tlist.get(i).getTid());
			System.out.println(tlist.get(i).getTname());
			System.out.println(tlist.get(i).getInfo());
			System.out.println(tlist.get(i).getCnt());
		}
	}
	@Test 
	public void insert() {
		tdao.inserttree("1", "자작나무", "자자작", 20);
		
	}
	@Test
	public void updatecnt() {
	selectAlltree();
	 tdao.updatetreecnt( 2 , "2");
	selectAlltree();
	}
	@Test
	public void delete() {
		tdao.deletetree("2");
		selectAlltree();
	}
}
