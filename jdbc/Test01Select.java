package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01Select {
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
		sql.append("select * ");
		sql.append("	from employees ");
		sql.append("	order by employee_id ");
		
		//4. SQL 실행하기 위한 실행객체 얻기(Statement 타입)
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		//5. SQL 실행
		//실행문 종류에 따라서 2가지 메서드를 기억
		//select: executeQuery 메서드 사용(return: ResultSet, 결과값들 셋으로) 
		//그 외: executeUpdate 메서드 사용(return: int, 몇 개가 업데이트 되었는지)
		ResultSet rs = pstmt.executeQuery();
		
		//6. 결과 처리
		//rs 처음 오면 첫번째 행 그 위를 가리키고 있음. rs.next()해줘서 실제 데이터 가리키게 해줘야함, 데이터 끝 넘어가면 false
		//뽑고 싶으면 rs.getString('Column명'), rs.getInt('Column명') 이런식으로 
		while(rs.next()) {
			int employeeId = rs.getInt("employee_id");
			String firstName = rs.getString("first_name");
			System.out.printf("%d %s %n", employeeId, firstName);
		}
		
		//7. 닫기 (근데 try resources 쓰면 되긴함, 지금처럼 짠 경우는 닫아야겠쥬?)
		pstmt.close();
		con.close();
		//rs는 저절로 닫힘
	}
}