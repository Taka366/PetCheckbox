package model;

import java.util.List;

import dao.TimeframeEntryDAO;

public class TimeframeEntryLogic {
	public List<TimeframeEntry> execute() {
		//DAOよりデータを習得
		TimeframeEntryDAO timeframeEntries = new TimeframeEntryDAO();
		List<TimeframeEntry> entry = timeframeEntries.entry();
		return entry;
		}
}