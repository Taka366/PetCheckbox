package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Pet;

public class PetRegistrationDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/pet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean create(Pet pet){
		
		//JDBCドライバ読み込み
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		//データベースに接続
		List<String> actionList = pet.getActionList();
		List<String> timeframeList = pet.getTimeframeList();
		List<String> nameList = pet.getNameList();
		for(int i = 0; i < actionList.size(); i++) {
			for(int j = 0; j < timeframeList.size(); j++) {
				for(int k = 0; k < nameList.size(); k++) {
					try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
						//SELECT文を準備
						String sql = "INSERT INTO PETS(DAYS,TIME,ACTION,TIMEFRAME,NAME) VALUES (?,?,?,?,?);";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						
						//INSERT文中の?の設定
						pStmt.setString(1,pet.getDays());
						pStmt.setString(2,pet.getTime());
						pStmt.setString(3,actionList.get(i));
						pStmt.setString(4,timeframeList.get(j));
						pStmt.setString(5,nameList.get(k));
						
						//INSERT文を実行
						int result = pStmt.executeUpdate();
						if(result != 1) {
							return false;
						}
					}catch (SQLException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		return true;
	}
}