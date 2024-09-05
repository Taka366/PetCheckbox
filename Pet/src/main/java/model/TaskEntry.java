//タスク管理用選択項目リストのEntityの作成

package model;

import java.io.Serializable;
import java.util.List;

public class TaskEntry implements Serializable {
	private List<String> actionEntry;
	private List<String> timeframeEntry;
	private List<String> nameEntry;

	public TaskEntry(){}
	
	public TaskEntry(List<String> actionEntry,List<String> timeframeEntry,List<String> nameEntry) {
		this.actionEntry = actionEntry;
		this.timeframeEntry = timeframeEntry;
		this.nameEntry = nameEntry;
	}

	//ゲッター
	public List<String> getActionEntry() {
		return actionEntry;
	}

	public List<String> getTimeframeEntry() {
		return timeframeEntry;
	}

	public List<String> getNameEntry() {
		return nameEntry;
	}
	
}