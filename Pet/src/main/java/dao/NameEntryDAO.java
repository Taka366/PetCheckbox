package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.NameEntry;

public class NameEntryDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/pet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public List<NameEntry> entry(){
		List<NameEntry> nameEntries = new ArrayList<>();
		
		//JDBCドライバ読み込み
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		//NAME項目のリスト化
		try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "SELECT NUMBER,NAME FROM NAMES ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果表に格納されたレコードの内容を
			//NameEntryインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int number = rs.getInt("NUMBER"); 
				String name = rs.getString("NAME");
				NameEntry nameEntry = new NameEntry(number,name);
				nameEntries.add(nameEntry);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		nameEntries.sort(Comparator.comparingInt(NameEntry::getNumber));
		return nameEntries;
	}
}
