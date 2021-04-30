import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

// 간단한 커넥션풀을 만들어보자 

public class ConnectionPoolTest {
	private static int INIT_COUNT = 3;
	private static String URL = "jdbc:mysql://127.0.0.1:3306/mybatisDB?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static String USER = "";
	private static String PASSWORD = "";
	
	private static List<Connection> free = new LinkedList<>();
	private static List<Connection> used = new LinkedList<>();
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for(int i = 1; i <= INIT_COUNT; i++) {
				free.add(DriverManager.getConnection(URL, USER, PASSWORD));
			}
		}catch(Exception e) {
			System.out.println("최초 서버 구동시 커넥션 열결하다 에러 발생");
			e.printStackTrace();
		}
	}
	// 사용자의 연결 요청
	public static Connection getConnection() throws Exception {	//서버에 커넥션 한계치 넘으면 에러
		if(free.isEmpty()) {
			throw new Exception("사용할 수 있는 커넥션이 없습니다. 잠시 후 이용해 주세요");
		}
		Connection con = free.remove(0);
		used.add(con);
		return con;
	}
	// 사용자의 연결 닫기 요청(반환 요청)
	public static void close(Connection con) {
		used.remove(con);
		free.add(con);
	}
	public static void main(String[] args) {
		try {
			for(int i = 1; i <= 10; i++) {
				Thread.sleep(2000);
				Connection con = ConnectionPoolTest.getConnection();
				System.out.println(i + "번째 " + con);
				ConnectionPoolTest.close(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
