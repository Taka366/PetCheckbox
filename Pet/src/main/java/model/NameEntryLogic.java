package model;

import java.util.List;

import dao.NameEntryDAO;

public class NameEntryLogic {
	public List<NameEntry> execute() {
		//DAOよりデータを習得
		NameEntryDAO nameEntries = new NameEntryDAO();
		List<NameEntry> entry = nameEntries.entry();
		return entry;
		}
}
