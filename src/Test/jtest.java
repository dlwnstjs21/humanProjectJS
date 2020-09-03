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
	public void inserttree() {
		treedto m = new treedto();
		m.setTid("a");
		m.setTname("aaa");
		m.setInfo("aaaa");
		m.setCnt(2);
		tdao.inserttree(m);
		
	}
	public void updatecnt() {
		tdao.updatetreecnt(2, "a");
	}
	public void delete() {
		tdao.deletetree("a");
		
	}
}
