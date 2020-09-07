package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.basketdto;

public class basketdao {
	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
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
	
	public void insertbuy(basketdto bdto) {//��ٱ���(����)
		String sql="insert into basket values(?,?,?)";
		PreparedStatement ppst =null;
		if(conn != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, bdto.getTid());
				ppst.setString(2 ,bdto.getUid());
				ppst.setInt(3 ,bdto.getCnt());
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
	public ArrayList<basketdto> basketlist() {
		String sql = "select * from basket";
		ArrayList<basketdto> blist = new ArrayList<>();
		Statement st = null; // ����������
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					basketdto btemp = new basketdto();
					btemp.setUid(rs.getString("cid"));
					btemp.setTid(rs.getString("tid"));
					btemp.setCnt(rs.getInt("cnt"));
					blist.add(btemp);
				}
			} catch (Exception e) {
			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return blist;
	}
	public void updatebasek(int cnt , String id) {
		String sql="update basket set cnt=? where cid=?";
		PreparedStatement ppst = null;
		if(conn() != null) {
			try {
				ppst =conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setString(2, id);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) ppst.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	public void deletebasket(String id) {
		String sql="delete from basket where cid=?";
		PreparedStatement ppst = null;
		if(conn() != null) {
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
					// TODO: handle exception
				}
			}
		}
		
		
	}
}
