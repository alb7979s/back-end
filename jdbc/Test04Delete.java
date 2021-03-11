package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test04Delete {
	public static void main(String[] args) throws Exception {
		//1. driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. connection
		Connection con = DriverManager.getConnection(
				"",
				"ssafy",
				"ssafy"
				);
		//3. SQL 작성
		StringBuffer sql = new StringBuffer();
		sql.append("delete ");
		sql.append("	from ssafy_member ");
		sql.append(" where idx = ? ");
		
		//4. SQL 실행하기 위한 실행객체 얻기(Statement 타입)
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		int index = 0;
		pstmt.setInt(++index, 10);
		
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt + "개의 행이 삭제되었습니다. ");
		pstmt.close();
		con.close();
	}
}
