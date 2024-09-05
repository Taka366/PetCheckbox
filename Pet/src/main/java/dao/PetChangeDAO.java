package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pet;

public class PetChangeDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/pet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean change(Pet changeLog){
		//Petインスタンスから各変更値の読み込み
		String id = changeLog.getId();
		String days = changeLog.getDays();
		String time = changeLog.getTime();
		String action = changeLog.getAction();
		String timeframe = changeLog.getTimeframe();
		String name = changeLog.getName();
		
		
		//JDBCドライバ読み込み
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "UPDATE PETS SET DAYS = '" + days + "',TIME = '" + time + "',ACTION = '" + action + "',TIMEFRAME = '" + timeframe + "',NAME = '" + name + "' WHERE ID=" + id + ";";
			PreparedStatement pStmt = conn.prepareStatement(sql);
						
			//INSERT文を実行
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}