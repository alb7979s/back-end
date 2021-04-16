package kr.co.mlec.file.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	static final String URL = "jdbc:mysql://127.0.0.1:3306/daejeondb?useSSL=false&serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String ID = "ssafy";
	static final String PASSWORD = "ssafy";

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

//	가변길이 파라미터 : 0~* 개의 동일한 타입을 파라메터로 받을 수 있다. 만약 또 다른 파라메터와 함께 사용하고 싶다면 가변길이 파라메터는 맨 뒤에 위치 시켜야 한다.
	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int update(String sql, Object... args) throws SQLException {
		try (Connection con = getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			int index = 1;
			for (Object arg : args) {
				pstmt.setObject(index++, arg);
			}
			return pstmt.executeUpdate();
		}
	}
}
