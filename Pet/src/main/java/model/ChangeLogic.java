package model;

import dao.PetChangeDAO;

public class ChangeLogic {
	public void change(Pet changeLog) {
		//テーブルからレコード削除するDAOの呼び出し
			PetChangeDAO dao = new PetChangeDAO();
			dao.change(changeLog);
	}
}