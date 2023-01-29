package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import entity.Data;

public class SetData {
    private static Connection conn = null;; //DB 커넥션 연결 객체
    private static PreparedStatement pstmt = null;
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "19931223";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/lotto";//DBMS접속할 db명
    
    public SetData() {
        try {
            System.out.println("생성자");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB 연결 성공");
        } catch (Exception e) {
            System.out.println("DB 연결 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }        
    }
    
    public static void insertLottoNum(Data data) throws SQLException {
    	String SQL = "INSERT INTO DATA(NO, NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUMB, DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, data.getNo());
        pstmt.setInt(2, data.getNum1());
        pstmt.setInt(3, data.getNum2());
        pstmt.setInt(4, data.getNum3());
        pstmt.setInt(5, data.getNum4());
        pstmt.setInt(6, data.getNum5());
        pstmt.setInt(7, data.getNum6());
        pstmt.setInt(8, data.getNumb());
        pstmt.setString(9, data.getDate());

        // 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
        int r = pstmt.executeUpdate();

        System.out.println("변경된 row : " + r);
    }
    
    public static ArrayList<HashMap<Integer, Integer>> selectLottoNum1() throws SQLException {
    	String SQL = "SELECT NUM1, NUM2, NUM3, NUM4, NUM5, NUM6 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		
      	ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
  		while(rs.next()) {
  			HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
  			temp.put(1, rs.getInt("NUM1"));
  			temp.put(2, rs.getInt("NUM2"));
  			temp.put(3, rs.getInt("NUM3"));
  			temp.put(4, rs.getInt("NUM4"));
  			temp.put(5, rs.getInt("NUM5"));
  			temp.put(6, rs.getInt("NUM6"));
  			list.add(temp);
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNum2() throws SQLException {
    	String SQL = "SELECT NUM2 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUM2"));
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNum3() throws SQLException {
    	String SQL = "SELECT NUM3 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUM3"));
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNum4() throws SQLException {
    	String SQL = "SELECT NUM4 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUM4"));
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNum5() throws SQLException {
    	String SQL = "SELECT NUM5 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUM5"));
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNum6() throws SQLException {
    	String SQL = "SELECT NUM6 FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUM6"));
  		}
        
        return list;
    }
    
    public static ArrayList<Integer> selectLottoNumb() throws SQLException {
    	String SQL = "SELECT NUMB FROM DATA";
    	Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
        
      	ArrayList<Integer> list = new ArrayList<Integer>();
  		while(rs.next()) {
  			list.add(rs.getInt("NUMB"));
  		}
        
        return list;
    }
}