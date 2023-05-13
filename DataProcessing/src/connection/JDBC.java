package connection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static JDBC instance = null;
    private Connection conn = null;
    
    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성불가
    private JDBC() {
        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 데이터베이스 연결 생성
            String url = "jdbc:oracle:thin:@localhost:1521:dink09";
            String user = "scott";
            String password = "tiger";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    // 유일한 인스턴스를 반환하는 static 메서드를 정의
    public static JDBC getInstance() {
        if (instance == null) {
            instance = new JDBC();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    // Connection 종료
    public void closeConnection() {
        try {
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Connection이 정상적으로 종료되었는지 확인
    public void isClosed() {
        try {
            if (conn.isClosed()) {
                System.out.println("JDBC 연결 해제 성공");
            } else {
                System.out.println("JDBC 연결 해제 실패");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void loadScript(String filePath) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String query = sb.toString();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
