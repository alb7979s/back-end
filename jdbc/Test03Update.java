package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03Update {
	public static void main(String[] args) throws Exception {
		//1. driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/ssafydb?erverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy",
				"ssafy"
				);
		//3. SQL 작성
		StringBuffer sql = new StringBuffer();
		sql.append("update ssafy_member ");
		sql.append("	set emailid = ?, ");
		sql.append(" where idx = ? ");	
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		int index = 0;
		pstmt.setString(++index, "aaaaa@naver.com");
		pstmt.setInt(++index, 7);	
		
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt + "개의 행이 수정되었습니다.");
		pstmt.close();
		con.close();
	}
}