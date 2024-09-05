package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class PetWeekDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/pet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Pet> weekLog(String today,String week){
		List<Pet> weekLog = new ArrayList<>();
		//JDBCドライバ読み込み
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "SELECT ID,DAYS,TIME,ACTION,TIMEFRAME,NAME FROM PETS WHERE DAYS BETWEEN '" + week + "' AND '" + today + "';";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果表に格納されたレコードの内容を
			//Petインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("ID")); 
				String days = rs.getString("DAYS");
				String time = rs.getString("TIME");
				String action = rs.getString("ACTION");
				String timeframe = rs.getString("TIMEFRAME");
				String name = rs.getString("NAME");
				
				Pet pet = new Pet(id,days,time,action,timeframe,name);
				weekLog.add(pet);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return weekLog;
	}
}