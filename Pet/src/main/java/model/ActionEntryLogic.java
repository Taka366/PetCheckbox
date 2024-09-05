package model;

import java.util.List;

import dao.ActionEntryDAO;

public class ActionEntryLogic {
	public List<ActionEntry> execute() {
	//DAOよりデータを習得
	ActionEntryDAO actionEntries = new ActionEntryDAO();
	List<ActionEntry> entry = actionEntries.entry();
	return entry;
	}
}