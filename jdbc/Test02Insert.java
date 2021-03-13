
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02Insert {
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
		// sql 절별로 내리는 연습하기! 실무가면 엄~청 길어진것도 본대, 가독성 좋아지도록 
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ssafy_member ( ");	//뒤에 마지막 한칸 띄어주기~ 백엔드 할때 알려준대유
		sql.append("	userid, username, userpwd, emailid, emaildomain, joindate ");
		sql.append(") values ( ");
		sql.append(" ?, ?, ?, ?, ? ");		//동적으로 넣어줄거임
		sql.append(") ");
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		// ? 자리에 값 설정하기
		int index = 0;
		pstmt.setString(++index, "dssafy");
		pstmt.setString(++index, "a");
		pstmt.setString(++index, "dy");
		pstmt.setString(++index, "safy");
		pstmt.setString(++index, "dsy");
		pstmt.setString(++index, "dsfy");
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt + "개의 행이 추가되었습니다.");
		pstmt.close();
		con.close();
	}
}
