package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.PetWeekDAO;

public class WeekLogic {
	public List<Pet> execute() {
		//現在の日付を取得
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String today = sdf.format(now);
		
		//Date型の日時をCalender型に変換
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        
        //1週間前の日を計算する
        calendar.add(Calendar.DATE, -6);
        
        // Calendar型の日時をDate型に戻す
        Date d1 = calendar.getTime();
        String week = sdf.format(d1);
		
		//DAOよりデータを習得
		PetWeekDAO petDAO = new PetWeekDAO();
		List<Pet> weekLog = petDAO.weekLog(today,week);
		return weekLog;
	}
}