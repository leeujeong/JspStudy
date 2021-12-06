package dml;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.MyConnetcion;

public class DmlMainClass {

	public static void insert1() {
		Connection con = null;
		PreparedStatement ps = null;
		int resultCount = 0;
		String sql = null;
		
		try {
			con = MyConnetcion.getConnection();
			
			sql = "INSERT INTO PRODUCT(PNO, PNAME,PRICE,PDATE) VALUES (PRODUCT_SEQ.NEXTVAL,'홈런볼', '1500','21/09/01')";
			
			ps = con.prepareStatement(sql);
			
			con.setAutoCommit(false);
			
			resultCount = ps.executeUpdate();
			
			if(resultCount > 0) {
				con.commit();
				System.out.println("파일추가");
			}else {
				System.out.println("파일추가 안됨");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyConnetcion.close(con, ps, null);
		}
	}

	public static void insert3() {
		
		Connection con = null;
		PreparedStatement ps = null;
		int resultCount = 0;
		String sql = null;
		
		String pName="꼬북침";
		int price = 1500;
		
		try {
			con = MyConnetcion.getConnection();
			sql = "INSERT INTO PRODUCT(PNO,PNAME,PRICE,PDATE) VALUES (PRODUCT_SEQ.NEXTVAL,?,? SYSDATE)";
			ps = con.prepareStatement(sql);
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
