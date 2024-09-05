package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.TimeframeEntry;

public class TimeframeEntryDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/pet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public List<TimeframeEntry> entry(){
		List<TimeframeEntry> timeframeEntries = new ArrayList<>();
		
		//JDBCドライバ読み込み
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		//TIMEFRAME項目のリスト化
		try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql = "SELECT NUMBER,TIMEFRAME FROM TIMEFRAMES ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果表に格納されたレコードの内容を
			//TimeframeEntryインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int number = rs.getInt("NUMBER"); 
				String timeframe = rs.getString("TIMEFRAME");
				TimeframeEntry timeframeEntry = new TimeframeEntry(number,timeframe);
				timeframeEntries.add(timeframeEntry);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		timeframeEntries.sort(Comparator.comparingInt(TimeframeEntry::getNumber));
		return timeframeEntries;
	}
}