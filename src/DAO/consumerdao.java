package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.consumerdto;

public class consumerdao {
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

	public ArrayList<consumerdto> selectAllconsumer() {
		String sql = "select * from consumer";
		Statement st = null;
		ArrayList<consumerdto> clist = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					consumerdto ctem = new consumerdto();
					ctem.setUid(rs.getString("cid"));
					ctem.setUname(rs.getString("uname"));
					ctem.setAddr(rs.getString("addr"));
					clist.add(ctem);
				}
				return clist;
			} catch (Exception e) {
			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return null;
	}

	public void insertuser(String id,String name,String addr) {// ȸ�����
		String sql = "insert into consumer values (?,?,?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.setString(2, name);
				ppst.setString(3, addr);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
				}
			}
		}

	}

	public void deleteconsumer(String id) {
		String sql = "delete from consumer where cid=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				} // TODO: handle exception
			}
		}
	}

	public void updateconsumer(String name, String addr, String id) {
		String sql = "update consumer set uname=? , addr =? where cid =?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, name);
				ppst.setString(2, addr);
				ppst.setString(3, id);
				ppst.executeUpdate();
			} catch (Exception e) {
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

}
