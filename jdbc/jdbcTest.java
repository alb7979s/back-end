package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

// 프로젝트 - 우클릭 - Build path - add external archives 해서 mysql-connector-java-8.0.23.jar 파일 넣어주면 됨
public class jdbcTest {
	public jdbcTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		jdbcTest jdbc = new jdbcTest();
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/ssafydb?erverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", 
				"ssafy", 
				"ssafy");
	}
}
