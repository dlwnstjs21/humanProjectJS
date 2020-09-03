package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.consumerdto;

public class consumerdao {
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
	
	public void insertuser(consumerdto udto) {//ȸ�����
		String sql="insert into user values (?,?,?)";
		PreparedStatement ppst =null;
		if(conn != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, udto.getUid());
				ppst.setString(2 ,udto.getUname());
				ppst.setString(3 ,udto.getAddr());
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
