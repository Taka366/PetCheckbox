package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.PetTodayDAO;

public class TodayLogic {
	public List<Pet> execute() {
		//現在の日付を取得
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String s = f.format(now);
		
		//DAOよりデータを習得
		PetTodayDAO petDAO = new PetTodayDAO();
		List<Pet> todayLog = petDAO.todayLog(s);
		return todayLog;
	}
}