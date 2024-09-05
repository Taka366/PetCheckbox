package model;

import dao.PetDeleteDAO;

public class Del {	
	public void delete(int id) {
		//テーブルからレコード削除するDAOの呼び出し
		PetDeleteDAO dao = new PetDeleteDAO();
		dao.delete(id);
	}
}