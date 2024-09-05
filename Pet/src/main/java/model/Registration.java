package model;

import dao.PetRegistrationDAO;

public class Registration {
	public void execute(Pet pet) {				
		//データベースに登録
		PetRegistrationDAO  dao = new PetRegistrationDAO();
		dao.create(pet);
	}
}