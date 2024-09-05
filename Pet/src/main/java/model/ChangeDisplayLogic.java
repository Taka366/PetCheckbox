package model;

import java.util.List;

import dao.ChangeDisplayDAO;

public class ChangeDisplayLogic {
	public List<Pet> excute(int changeId) {
		//修正画面に表示するレコードのDAOの呼び出し
		ChangeDisplayDAO dao = new ChangeDisplayDAO();
		List<Pet> log = dao.read(changeId);
		return log;
	}
}