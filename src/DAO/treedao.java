package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.treedto;

public class treedao {
	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pwd = "1111";

	ResultSet rs = null; // �������� ����� �����ϴ� ����

	public Connection conn() {
		try { // try catch ������ ���ܰ� �߻��� ��� �ý����� �������� ���� �ϱ� ���� ����
			Class.forName(driver); // DB�� �����ϱ� ���� ����̹� �ε�.
			conn = DriverManager.getConnection(url, id, pwd); // db�� ����
			System.out.println("DB������ �Ǿ����ϴ�.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<treedto> selectAll() {//��� ���� ����
		String sql="select * from tree";
		Statement st = null;
		ArrayList<treedto> tlist = new ArrayList<>();
		if(conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					treedto temp = new treedto();
					temp.setTid(rs.getString("tid"));
					temp.setTname(rs.getString("tname"));
					temp.setInfo(rs.getString("info"));
					temp.setCnt(rs.getInt("cnt"));
					tlist.add(temp);
				}
				for(int i=0; i<tlist.size(); i++) {
					if(tlist.get(i).getCnt()==0) {
						System.out.println(tlist.get(i).getTname()+"�� ��� �����ϴ�.");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(st != null)st.close();
					if(conn != null)conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return tlist;
		
	}
	
	public void inserttree(treedto tdto) {//���� ����ϱ�
		String sql ="insert into tree values(?,?,?,?)";
		PreparedStatement ppst = null;
		if(conn != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, tdto.getTid());
				ppst.setString(2, tdto.getTname());
				ppst.setString(3, tdto.getInfo());
				ppst.setInt(4, tdto.getCnt());
				ppst.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	public void  deletetree(String id) {//���� ���ֱ�
		String sql = "delete from tree where tid=?";
		PreparedStatement ppst = null;
		if(conn != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public void updatetreecnt(int cnt,String id) {//���� ���� ����
		String sql="update tree set cnt=-? wher id=?";
		PreparedStatement ppst =null;
		if(conn != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setString(1 ,id );
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(ppst != null)ppst.close();
					if(conn != null)conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	
}
